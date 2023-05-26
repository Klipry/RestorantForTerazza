package com.example.restorantforterazza.LineMenu

import android.content.ContentValues.TAG
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.widget.Button
import android.widget.EditText
import com.example.restorantforterazza.R
import com.google.firebase.firestore.FirebaseFirestore

class Ibuyer : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ibuyer)
        val sharedPref = getSharedPreferences("myAppPreferences", Context.MODE_PRIVATE)
        val login = sharedPref.getString("login", "")
        val item = intent.getStringExtra("Item")
        val ForItem1 = intent.getIntExtra("ForItem1",0)
        var priceItem = intent.getStringExtra("PriceItem")
        val sparja = intent.getIntExtra("sparja",0)
        val capust = intent.getIntExtra("capust",0)
        val brokoli = intent.getIntExtra("brokoli",0)
        val perec = intent.getIntExtra("perec",0)
        val baclajan = intent.getIntExtra("baclajan",0)
        val DateCur: EditText = findViewById(R.id.editTextTextDateCur)
        val TimeCur: EditText = findViewById(R.id.editTextTextTimeCur)
        var oplata: String
        //////////Обработка кнопок.
        // Ограничение ввода даты
        val datePattern = Regex("^[0-3][0-9]\$") // Регулярное выражение для проверки формата даты
        DateCur.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                // Проверяем, соответствует ли введенная дата формату
                if (!s.toString().matches(datePattern)) {
                    DateCur.error = "Введите дату в формате ДД"
                } else {
                    DateCur.error = null
                }
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
        })

// Ограничение ввода времени
        val timePattern =
            Regex("^([0-1][0-9]|2[0-3]):[0-5][0-9]\$") // Регулярное выражение для проверки формата времени
        TimeCur.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                // Проверяем, соответствует ли введенное время формату
                if (!s.toString().matches(timePattern)) {
                    TimeCur.error = "Введите время в формате ЧЧ:ММ"
                } else {
                    TimeCur.error = null
                }
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
        })
        //////////////

        val buttonCard: Button = findViewById(R.id.buttonCardCur)
        val NallButton: Button = findViewById(R.id.buttonNalCur)
        buttonCard.setOnClickListener {
            oplata = "Карта"
            if (DateCur.text.length==2 && TimeCur.text.length ==5) {
                val dateCur = DateCur.text.toString()
                val timeCur = TimeCur.text.toString()

                val zakaz = hashMapOf(
                    "номер" to login,
                    "наименование" to item,
                    "колл-во" to ForItem1,
                    "колл-во итоговая цена" to priceItem,
                    "колл-во спаржи" to sparja,
                    "колл-во капусты" to capust,
                    "колл-во броколи" to brokoli,
                    "колл-во перца" to perec,
                    "колл-во баклажанов" to baclajan,
                    "Оплата" to oplata,
                    "Дата" to dateCur,
                    "Время" to timeCur,
                    "Метод" to "Самовывоз"

                )

// Добавляем данные в коллекцию "zakaz"
                FirebaseFirestore.getInstance().collection("zakaz").add(zakaz)
                    .addOnSuccessListener {
                        Log.d(TAG, "Data added successfully!")
                    }
                    .addOnFailureListener { e ->
                        Log.w(TAG, "Error adding document", e)
                    }
                val intent=Intent(this,ThanksForBuy::class.java)
                startActivity(intent)

            }


        }
        NallButton.setOnClickListener {
            oplata = "наличные"
            if (DateCur.text.length==2 && TimeCur.text.length ==5) {
                val dateCur = DateCur.text.toString()
                val timeCur = TimeCur.text.toString()
                val zakaz = hashMapOf(
                    "номер" to login,
                    "наименование" to item,
                    "колл-во" to ForItem1,
                    "колл-во итоговая цена" to priceItem,
                    "колл-во спаржи" to sparja,
                    "колл-во капусты" to capust,
                    "колл-во броколи" to brokoli,
                    "колл-во перца" to perec,
                    "колл-во баклажанов" to baclajan,
                    "Оплата" to oplata,
                    "Дата" to dateCur,
                    "Время" to timeCur,
                    "Метод" to "Самовывоз"

                )

// Добавляем данные в коллекцию "zakaz"
                FirebaseFirestore.getInstance().collection("zakaz").add(zakaz)
                    .addOnSuccessListener {
                        Log.d(TAG, "Data added successfully!")
                    }
                    .addOnFailureListener { e ->
                        Log.w(TAG, "Error adding document", e)
                    }
                val intent=Intent(this,ThanksForBuy::class.java)
                startActivity(intent)
            }

        }
    }
}
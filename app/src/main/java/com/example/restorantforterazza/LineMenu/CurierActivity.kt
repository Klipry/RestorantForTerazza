package com.example.restorantforterazza.LineMenu

import android.content.ContentValues
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

class CurierActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_curier)
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
        val adress:EditText=findViewById(R.id.editTextTextAdress)
        val NumberHome:EditText=findViewById(R.id.editTextTexNumberHome)
        val NumberEntrance:EditText=findViewById(R.id.editTextTextNumberEntrance)
        val floor:EditText=findViewById(R.id.editTextTextFloor)
        val flat:EditText=findViewById(R.id.editTextTextFlat)
        val data:EditText=findViewById(R.id.editTextTextData)


        val datePattern = Regex("^[0-3][0-9]\$") // Регулярное выражение для проверки формата даты
        data.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                // Проверяем, соответствует ли введенная дата формату
                if (!s.toString().matches(datePattern)) {
                    data.error = "Введите дату в формате ДД"
                } else {
                    data.error = null
                }
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
        })
        val time:EditText=findViewById(R.id.editTextTextTime)
        val timePattern =
            Regex("^([0-1][0-9]|2[0-3]):[0-5][0-9]\$") // Регулярное выражение для проверки формата времени
        time.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                // Проверяем, соответствует ли введенное время формату
                if (!s.toString().matches(timePattern)) {
                    time.error = "Введите время в формате ЧЧ:ММ"
                } else {
                    time.error = null
                }
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
        })
        val card:Button=findViewById(R.id.buttonCard)
        val nall:Button=findViewById(R.id.buttonMoney)
        var oplata:String
        card.setOnClickListener {
            oplata = "Карта"
            if (data.text.length==2 && time.text.length ==5) {
                val dateCur = data.text.toString()
                val timeCur = time.text.toString()
                val addressText = adress.editableText.toString()
                val numberHomeText = NumberHome.text.toString()
                val numberEntranceText = NumberEntrance.editableText.toString()
                val floorText = floor.text.toString()
                val flatText = flat.editableText.toString()


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
                    "Метод" to "доставка",
                    "Адрес" to addressText,
                    "Номер дома" to numberHomeText,
                    "Номер подъезда" to numberEntranceText,
                    "этаж" to floorText,
                    "Квартира" to flatText

                )

// Добавляем данные в коллекцию "zakaz"
                FirebaseFirestore.getInstance().collection("zakaz").add(zakaz)
                    .addOnSuccessListener {
                        Log.d(ContentValues.TAG, "Data added successfully!")
                    }
                    .addOnFailureListener { e ->
                        Log.w(ContentValues.TAG, "Error adding document", e)
                    }
                val intent= Intent(this,ThanksForBuy::class.java)
                startActivity(intent)

            }
        }
        nall.setOnClickListener {
            oplata = "Наличные"
            if (data.text.length==2 && time.text.length ==5) {
                val dateCur = data.text.toString()
                val timeCur = time.text.toString()
                val addressText = adress.editableText.toString()
                val numberHomeText = NumberHome.text.toString()
                val numberEntranceText = NumberEntrance.editableText.toString()
                val floorText = floor.text.toString()
                val flatText = flat.editableText.toString()


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
                    "Метод" to "доставка",
                    "Адрес" to addressText,
                    "Номер дома" to numberHomeText,
                    "Номер подъезда" to numberEntranceText,
                    "этаж" to floorText,
                    "Квартира" to flatText

                )

// Добавляем данные в коллекцию "zakaz"
                FirebaseFirestore.getInstance().collection("zakaz").add(zakaz)
                    .addOnSuccessListener {
                        Log.d(ContentValues.TAG, "Data added successfully!")
                    }
                    .addOnFailureListener { e ->
                        Log.w(ContentValues.TAG, "Error adding document", e)
                    }
                val intent= Intent(this,ThanksForBuy::class.java)
                startActivity(intent)

            }
        }

    }
}
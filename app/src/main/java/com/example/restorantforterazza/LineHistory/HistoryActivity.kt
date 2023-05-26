package com.example.restorantforterazza.LineHistory

import android.content.ContentValues.TAG
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.restorantforterazza.HistoryAdapter
import com.example.restorantforterazza.HistoryModel
import com.example.restorantforterazza.databinding.ActivityHistoryBinding
import com.google.firebase.firestore.FirebaseFirestore

class HistoryActivity : AppCompatActivity() {
    lateinit var binding: ActivityHistoryBinding
    lateinit var adapter: HistoryAdapter
    lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHistoryBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initial()
    }

    private fun initial() {
        recyclerView = binding.Rc
        recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = HistoryAdapter()
        recyclerView.adapter = adapter
        loadData()
    }

    private fun loadData() {
        // Получаем доступ к коллекции в Firestore
        val db = FirebaseFirestore.getInstance()
        val collectionRef = db.collection("zakaz")

        // Получаем все документы из коллекции и обрабатываем их в цикле
        collectionRef.get()
            .addOnSuccessListener { result ->
                val historyList = ArrayList<HistoryModel>()
                for (document in result) {
                    // Получаем данные из каждого документа
                    val address = document.getString("Адрес") ?: ""
                    val time = document.getString("Время") ?: ""
                    val date = document.getString("Дата") ?: ""
                    val apartment = document.getString("Квартира") ?: ""
                    val method = document.getString("Метод") ?: ""
                    val houseNumber = document.getString("Номер дома") ?: ""
                    val entranceNumber = document.getString("Номер подъезда") ?: ""
                    val payment = document.getString("Оплата") ?: ""
                    val quantity = document.getDouble("колл-во")?.toString() ?: ""
                    val totalPrice = document.getString("колл-во итоговая цена") ?: ""
                    val itemName = document.getString("наименование") ?: ""
                    val phoneNumber = document.getString("номер") ?: ""
                    val floor = document.getString("этаж") ?: ""

                    // Создаем объект HistoryModel и добавляем его в список
                    val history = HistoryModel("Адрес:$address" +
                            "\n дата и время:  $date | $time" +
                            "\n Квартира: $apartment | Метод:  $method  | номер дома:  $houseNumber " +
                            "| Этаж:  $floor |  Подъезд: $entranceNumber " +
                            "\n оплата: $payment | В заказе: $itemName | Кол-во:  $quantity | стоймость: $totalPrice \n" +
                            "Номер телефона: \n $phoneNumber ")
                    historyList.add(history)
                }

                // Обновляем адаптер после того, как все данные будут загружены
                updateAdapter(historyList)
            }
            .addOnFailureListener { exception ->
                Log.d(TAG, "Error getting documents: ", exception)
            }
    }

    private fun updateAdapter(historyList: List<HistoryModel>) {
        adapter.setList(historyList)
    }
}



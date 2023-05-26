package com.example.restorantforterazza.LineSittingReally

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import com.example.restorantforterazza.LineSitting.Bron
import com.example.restorantforterazza.MainActivity
import com.example.restorantforterazza.R

class SittingReally : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sitting_really)
        val out: ImageView = findViewById(R.id.imageViewOut)
        out.setOnClickListener {
            // Получаем объект SharedPreferences
            val sharedPrefs = getSharedPreferences("myAppPreferences", Context.MODE_PRIVATE)

            // Удаляем SharedPreferences
            sharedPrefs.edit().clear().apply()

            // Запускаем MainActivity
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish() // Закрываем текущую активити
        }
        val butttonBron=findViewById<Button>(R.id.Buttonbron)
        butttonBron.setOnClickListener {
            val intent =Intent(this,Bron::class.java)
            startActivity(intent)
        }

    }
}

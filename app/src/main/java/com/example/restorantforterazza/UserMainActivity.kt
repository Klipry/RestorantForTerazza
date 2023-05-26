package com.example.restorantforterazza

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.example.restorantforterazza.LineHistory.HistoryActivity
import com.example.restorantforterazza.LineMenu.MenuActivity
import com.example.restorantforterazza.LineNews.NewsActivity
import com.example.restorantforterazza.LineOtziv.OtzivActivity
import com.example.restorantforterazza.LineSitting.SittingActivity
import com.example.restorantforterazza.LineSittingReally.SittingReally

class UserMainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_main)
        //Clickable image
        val menu:ImageView =findViewById(R.id.imageMenu)
        val otziv:ImageView=findViewById(R.id.imageOtzivi)
        val history:ImageView = findViewById(R.id.imageViewHistory)
        val news:ImageView = findViewById(R.id.imageViewNews)
        val siting:ImageView = findViewById(R.id.imageViewSetting)
        val instruction:ImageView=findViewById(R.id.imageViewInstruction)

        //click menu
        menu.setOnClickListener {
            val intent = Intent (this,MenuActivity::class.java)
            startActivity(intent)
        }
            //click otziv
        otziv.setOnClickListener {
            val intent = Intent (this,OtzivActivity::class.java)
            startActivity(intent)
        }
        //history
        history.setOnClickListener {
            val intent = Intent (this,HistoryActivity::class.java)
            startActivity(intent)
        }
        news.setOnClickListener {
            val intent = Intent (this,NewsActivity::class.java)
            startActivity(intent)
        }
        instruction.setOnClickListener {
            val intent = Intent (this,SittingActivity::class.java)
            startActivity(intent)
        }
        siting.setOnClickListener {
            val intent = Intent (this, SittingReally::class.java)
            startActivity(intent)

        }


    }
}
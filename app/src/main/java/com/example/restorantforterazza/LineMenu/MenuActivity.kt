package com.example.restorantforterazza.LineMenu

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.example.restorantforterazza.LineMenu.Formadjio.FormajioActivity
import com.example.restorantforterazza.LineMenu.Kitchen.KitchenActivity
import com.example.restorantforterazza.LineMenu.Kolbaski.KolbaskiActivity
import com.example.restorantforterazza.LineMenu.Semga.SemgaActivity
import com.example.restorantforterazza.LineMenu.ribai.RibaiActivity
import com.example.restorantforterazza.LineMenu.shaslik.ShashlikActivity
import com.example.restorantforterazza.R

class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)
        val shashlik: ImageView =findViewById(R.id.imageViewShaslik)
        val ribai: ImageView =findViewById(R.id.imageViewRibai)
        val kitchen: ImageView =findViewById(R.id.imageViewKitchen)
        val formadjio: ImageView =findViewById(R.id.imageViewFormadjio)
        val kolbaski: ImageView =findViewById(R.id.imageViewKolbaski)
        val semga: ImageView =findViewById(R.id.imageViewSemga)
        //Clickable
        shashlik.setOnClickListener {
            val intent = Intent(this,ShashlikActivity::class.java)
            startActivity(intent)
        }
        ribai.setOnClickListener {
            val intent = Intent(this,RibaiActivity::class.java)
            startActivity(intent)
        }
        kitchen.setOnClickListener {
            val intent = Intent(this,KitchenActivity::class.java)
            startActivity(intent)
        }
        formadjio.setOnClickListener {
            val intent = Intent(this,FormajioActivity::class.java)
            startActivity(intent)
        }
        kolbaski.setOnClickListener {
            val intent = Intent(this,KolbaskiActivity::class.java)
            startActivity(intent)
        }
        semga.setOnClickListener {
            val intent = Intent(this,SemgaActivity::class.java)
            startActivity(intent)
        }


    }
}
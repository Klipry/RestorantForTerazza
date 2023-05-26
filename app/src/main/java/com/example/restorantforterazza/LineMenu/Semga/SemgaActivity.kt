package com.example.restorantforterazza.LineMenu.Semga

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.example.restorantforterazza.R
import com.example.restorantforterazza.basket

class SemgaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_semga)
        val plusSpardja:Button =findViewById(R.id.plusSpardja)
        val plusCapust:Button =findViewById(R.id.plusCapust)
        val plusBrokoli:Button =findViewById(R.id.plusBrokoli)
        val plusBolgPerec:Button =findViewById(R.id.plusBolgPerec)
        val plusBaklajan:Button =findViewById(R.id.plusBoklajani)
        val minusSpardja:Button =findViewById(R.id.minusSpardja)
        val minusCapust:Button =findViewById(R.id.minusCapust)
        val minusBrokoli:Button =findViewById(R.id.minusBrokoli)
        val minusBolgPerec:Button =findViewById(R.id.minusBalgPerec)
        val minusBoklagan:Button=findViewById(R.id.plusItem1)
        var textSpardja:TextView=findViewById(R.id.textViewSpardja)
        val textCapust:TextView = findViewById(R.id.textViewCapust)
        val textBrokoli:TextView = findViewById(R.id.textViewBrokoli)
        val textBolgarPerec:TextView = findViewById(R.id.textViewBolgPerec)
        val textBoclagan:TextView = findViewById(R.id.textViewBoklajani)
        val button:Button=findViewById(R.id.button2)
        var sparja=1;
        var capust=1;
        var brokoli=1;
        var perec=1;
        var baclajan=1;
        val textItem:TextView=findViewById(R.id.textViewSemgaBuy)
        val Item=textItem.text.toString()
        val price="1990";
/////////////////////////////////////////////////////////////////////////////////////
        plusSpardja.setOnClickListener{
            sparja++
            textSpardja.text=sparja.toString()

        }
        minusSpardja.setOnClickListener{
            if (sparja>1) {
                sparja--
                textSpardja.text=sparja.toString()
            }
        }
        /////////////////////////////////////////////////////////////////////////////////////
        plusCapust.setOnClickListener{

                capust++
            textCapust.text=capust.toString()

        }
        minusCapust.setOnClickListener{

            if (capust>1) {
                capust--
                textCapust.text=capust.toString()
            }
        }
        //////////////////////////////////////////////////////////////
        plusBrokoli.setOnClickListener{

                brokoli++
            textBrokoli.text=brokoli.toString()

        }
        minusBrokoli.setOnClickListener{
            if (brokoli>1) {
                brokoli--
                textBrokoli.text=brokoli.toString()
            }
        }
        ////////////////////////////////////////////////////
        plusBolgPerec.setOnClickListener{
                perec++
            textBolgarPerec.text=perec.toString()

        }
        minusBolgPerec.setOnClickListener{
            if (perec>1) {
                perec--
                textBolgarPerec.text=perec.toString()
            }
        }
        ///////////////////////////////////////////////
        plusBaklajan.setOnClickListener{
                baclajan++
            textBoclagan.text=baclajan.toString()

        }
        minusBoklagan.setOnClickListener{
            if (baclajan>1) {
                baclajan--
                textBoclagan.text=baclajan.toString()
            }
        }
        button.setOnClickListener {
        val intent = Intent (this, basket::class.java)
            intent.putExtra("sparja",sparja)
            intent.putExtra("capust",capust)
            intent.putExtra("brokoli",brokoli)
            intent.putExtra("perec",perec)
            intent.putExtra("baclajan",baclajan)
            intent.putExtra("Item",Item)
            intent.putExtra("price",price)
            startActivity(intent)
        }
    }
}
package com.example.restorantforterazza.LineSitting

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.core.content.ContextCompat
import com.example.restorantforterazza.R

class Bron : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bron)
        val buttonTerazza=findViewById<Button>(R.id.buttonTerazz)
        val buttonzal=findViewById<Button>(R.id.buttonZal)
        val buttonTable1=findViewById<Button>(R.id.table1)
        val buttonTable2=findViewById<Button>(R.id.table2)
        val buttonTable3=findViewById<Button>(R.id.table3)
        val buttonTable4=findViewById<Button>(R.id.table4)
        val buttonTable5=findViewById<Button>(R.id.table5)
        val buttonTable6=findViewById<Button>(R.id.table6)
        val buttonTable7=findViewById<Button>(R.id.table7)
        var iTeraz=0
        var iZal=0
        var iTable=0
        var iTable2=0
        var iTable3=0
        var iTable4=0
        var iTable5=0
        var iTable6=0
        var iTable7=0

        buttonTerazza.setOnClickListener {
            if (iTeraz!=1){
                buttonTerazza.setBackgroundColor(ContextCompat.getColor(this,R.color.GreenButton))
                iTeraz++
            }else{
                buttonTerazza.setBackgroundColor(ContextCompat.getColor(this,R.color.white))
                iTeraz--

            }
        }

        buttonzal.setOnClickListener {
            if (iZal!=1){
                buttonzal.setBackgroundColor(ContextCompat.getColor(this,R.color.GreenButton))
                iZal++
            }else{
                buttonzal.setBackgroundColor(ContextCompat.getColor(this,R.color.white))
                iZal--

            }
        }
        buttonTable1.setOnClickListener {
            if (iTable!=1){
                buttonTable1.setBackgroundColor(ContextCompat.getColor(this,R.color.Red))
                iTable++
            }else{
                buttonTable1.setBackgroundColor(ContextCompat.getColor(this,R.color.white))
                iTable--

            }
        }

        buttonTable2.setOnClickListener {
            if (iTable2!=1){
                buttonTable2.setBackgroundColor(ContextCompat.getColor(this,R.color.Red))
                iTable2++
            }else{
                buttonTable2.setBackgroundColor(ContextCompat.getColor(this,R.color.white))
                iTable2--

            }
        }
        buttonTable3.setOnClickListener {
            if (iTable3!=1){
                buttonTable3.setBackgroundColor(ContextCompat.getColor(this,R.color.Red))
                iTable3++
            }else{
                buttonTable3.setBackgroundColor(ContextCompat.getColor(this,R.color.white))
                iTable3--

            }
        }

        buttonTable4.setOnClickListener {
            if (iTable4!=1){
                buttonTable4.setBackgroundColor(ContextCompat.getColor(this,R.color.Red))
                iTable4++
            }else{
                buttonTable4.setBackgroundColor(ContextCompat.getColor(this,R.color.white))
                iTable4--

            }
        }

        buttonTable5.setOnClickListener {
            if (iTable5!=1){
                buttonTable5.setBackgroundColor(ContextCompat.getColor(this,R.color.Red))
                iTable5++
            }else{
                buttonTable5.setBackgroundColor(ContextCompat.getColor(this,R.color.white))
                iTable5--

            }
        }


        buttonTable6.setOnClickListener {
            if (iTable6!=1){
                buttonTable6.setBackgroundColor(ContextCompat.getColor(this,R.color.Red))
                iTable6++
            }else{
                buttonTable6.setBackgroundColor(ContextCompat.getColor(this,R.color.white))
                iTable6--

            }
        }


        buttonTable7.setOnClickListener {
            if (iTable7!=1){
                buttonTable7.setBackgroundColor(ContextCompat.getColor(this,R.color.Red))
                iTable7++
            }else{
                buttonTable7.setBackgroundColor(ContextCompat.getColor(this,R.color.white))
                iTable7--

            }
        }











    }










    }

package com.example.restorantforterazza
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.example.restorantforterazza.LineMenu.CurierActivity
import com.example.restorantforterazza.LineMenu.Ibuyer
import com.example.restorantforterazza.LineMenu.MenuActivity

class basket : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_basket)
        val textItem:TextView=findViewById(R.id.textViewItem1)
       val item = intent.getStringExtra("Item")
        var priceItem=intent.getStringExtra("price")
        val  sparja = intent.getIntExtra("sparja",0)
        val capust=intent.getIntExtra("capust",0)
        val brokoli = intent.getIntExtra("brokoli",0)
        val perec = intent.getIntExtra("perec",0)
        val baclajan=intent.getIntExtra("baclajan",0)
        textItem.text=item
        val textFor:TextView=findViewById(R.id.textViewkol)
        var ForItem1=1
        val plusItem1:Button=findViewById(R.id.plusItem1)
        val minusItem1:Button=findViewById(R.id.MinusItem1)
        val image:ImageView=findViewById(R.id.imageView4)
        val goMenu:Button=findViewById(R.id.buttonGoMenu)
        val textOplata:TextView=findViewById(R.id.textViewOplata)
        var sum:Int
        val defoltPriceItem=priceItem
        textOplata.text= "Итого к оплате                 " + priceItem.toString()
        plusItem1.setOnClickListener {
            ForItem1++
            sum=defoltPriceItem!!.toInt() * ForItem1
            priceItem = sum.toString()
            textFor.text = ForItem1.toString()
            textOplata.text= "Итого к оплате                          " + priceItem.toString()

        }
        minusItem1.setOnClickListener {
             // проверяем, что количество товара больше 0
                ForItem1--
            sum=defoltPriceItem!!.toInt() * ForItem1
            priceItem = sum.toString()
                textFor.text = ForItem1.toString()
                textOplata.text = "Итого к оплате                 " + priceItem.toString()
                if (ForItem1 == 0) { // проверяем, что количество товара равно 0
                    priceItem = "0"
                    minusItem1.visibility = View.GONE
                    plusItem1.visibility = View.GONE
                    image.visibility = View.GONE
                    textFor.visibility = View.GONE
                    textItem.visibility = View.GONE
                    textOplata.text = "Итого к оплате                 "
                }
            }
        val Curier:Button=findViewById(R.id.Curier)
        val Ibuyers:Button=findViewById(R.id.Ibuyer)
        Curier.setOnClickListener {
            if (priceItem!!.length>2) {
                val intent = Intent(this, CurierActivity::class.java)
                intent.putExtra("ForItem1", ForItem1)
                intent.putExtra("Item", item)
                intent.putExtra("PriceItem", priceItem)
                intent.putExtra("sparja", sparja)
                intent.putExtra("capust", capust)
                intent.putExtra("brokoli", brokoli)
                intent.putExtra("perec", perec)
                intent.putExtra("baclajan", baclajan)
                startActivity(intent)
            }
        }
        Ibuyers.setOnClickListener {
            if (priceItem!!.length>2) {
                val intent = Intent(this, Ibuyer::class.java)
                intent.putExtra("ForItem1", ForItem1)
                intent.putExtra("Item", item)
                intent.putExtra("PriceItem", priceItem)
                intent.putExtra("sparja", sparja)
                intent.putExtra("capust", capust)
                intent.putExtra("brokoli", brokoli)
                intent.putExtra("perec", perec)
                intent.putExtra("baclajan", baclajan)
                startActivity(intent)
            }

        }
        goMenu.setOnClickListener {
            val intent = Intent(this,MenuActivity::class.java)
            startActivity(intent)
        }
        }




    }

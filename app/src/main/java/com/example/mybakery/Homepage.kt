package com.example.mybakery

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.content.Intent
import android.widget.TextView

class Homepage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_homepage)


        val backbtn : ImageView = findViewById(R.id.mainpagebtn)

        backbtn.setOnClickListener() {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        val musictn : TextView = findViewById(R.id.startbtn)
        val orderingbtn : TextView = findViewById(R.id.stopbtn)

        musictn.setOnClickListener(){
            val intent = Intent(this, Mappage::class.java)
            startActivity(intent)
        }

        orderingbtn.setOnClickListener(){
            val intent = Intent(this, Orderpage::class.java)
            startActivity(intent)
        }


        val vanillla : ImageView = findViewById(R.id.vanillacakeimg)
        val lemonn : ImageView = findViewById(R.id.lemoncupcakeimg)
        val pops : ImageView = findViewById(R.id.popsiclesimg)
        val crepee : ImageView = findViewById(R.id.crepeimg)
        val cookie : ImageView = findViewById(R.id.cookiesimg)


        vanillla.setOnClickListener(){
            var vdialogfrag = vanilla()
            vdialogfrag.show(supportFragmentManager,"Vanilla Cake Recipe")
        }

        lemonn.setOnClickListener(){
            var vdialogfrag = lemon()
            vdialogfrag.show(supportFragmentManager,"Lemon Cupcakes Recipe")
        }

        pops.setOnClickListener(){
            var vdialogfrag = popsicles()
            vdialogfrag.show(supportFragmentManager,"Popsicles Recipe")
        }

        crepee.setOnClickListener(){
            var vdialogfrag = crepe()
            vdialogfrag.show(supportFragmentManager,"Crepes Recipe")
        }

        cookie.setOnClickListener(){
            var vdialogfrag = cookies()
            vdialogfrag.show(supportFragmentManager,"Chocolate Chip Cookies Recipe")
        }




    }
}
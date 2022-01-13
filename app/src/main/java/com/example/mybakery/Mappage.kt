package com.example.mybakery

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class Mappage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mappage)

        val backbtn3 : ImageView = findViewById(R.id.mainpagebtn)
        backbtn3.setOnClickListener() {
            val intent = Intent(this, Homepage::class.java)
            startActivity(intent)
        }

        val startaudio : TextView = findViewById(R.id.startbtn)
        startaudio.setOnClickListener(){
            startService(Intent(this, MyService::class.java))
        }

        val stopaudio : TextView = findViewById(R.id.stopbtn)
        stopaudio.setOnClickListener(){
            stopService(Intent(this, MyService::class.java))
        }

    }
}
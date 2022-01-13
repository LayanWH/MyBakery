package com.example.mybakery

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView

class Admin : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_admin)


        val backbtn : ImageView = findViewById(R.id.mainpagebtn)

        backbtn.setOnClickListener() {
            val intent = Intent(this, Orderpage::class.java)
            startActivity(intent)
        }




        val signin : TextView = findViewById(R.id.nextbtn)

        signin.setOnClickListener(){
            val uname : EditText = findViewById(R.id.editTextTextPersonName)
            val pass : EditText = findViewById(R.id.editTextTextPassword)

            val theuname :String = uname.text.toString()
            val thepass : String = pass.text.toString()


            if(theuname!="" && thepass!=""){
                if(theuname=="layanwaleed" && thepass=="Layan123"){
                    val intent = Intent(this, Adminsignedin::class.java)
                    startActivity(intent)
                }

            }

        }

    }
}
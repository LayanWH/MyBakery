package com.example.mybakery

import android.content.ContentValues
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import org.w3c.dom.Text

class Adminsignedin : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_adminsignedin)


        val backbtn : ImageView = findViewById(R.id.mainpagebtn)

        backbtn.setOnClickListener() {
            val intent = Intent(this, Admin::class.java)
            startActivity(intent)
        }

        var rs = contentResolver.query(bakeryProvider.CONTENT_URI,
            arrayOf(bakeryProvider._ID,bakeryProvider.FLAVOUR,bakeryProvider.COLOR,bakeryProvider.SIZE),null,null,null)

        val next : TextView = findViewById(R.id.nextbtn)
        val previous : TextView = findViewById(R.id.previousbtn)
        val insert : TextView = findViewById(R.id.insertbtn)
        val delete : TextView = findViewById(R.id.deletebtn)
        val clear : TextView = findViewById(R.id.clearbtn)
        val update : TextView = findViewById(R.id.updatebtn)

        var theid:EditText=findViewById(R.id.editTextTextPersonName6)
        var theflavour:EditText=findViewById(R.id.editTextTextPersonName2)
        var thecolor:EditText=findViewById(R.id.editTextTextPersonName3)
        var thesize:EditText=findViewById(R.id.editTextTextPersonName5)


        next.setOnClickListener(){

            if(rs?.moveToNext()!!){
                theid.setText(rs.getString(0))
                theflavour.setText(rs.getString(1))
                thecolor.setText(rs.getString(2))
                thesize.setText(rs.getString(3))
            }

        }

        previous.setOnClickListener(){
            if(rs?.moveToPrevious()!!){
                theid.setText(rs.getString(0))
                theflavour.setText(rs.getString(1))
                thecolor.setText(rs.getString(2))
                thesize.setText(rs.getString(3))
            }
        }

        clear.setOnClickListener(){
            theid.setText("")
            theflavour.setText("")
            thecolor.setText("")
            thesize.setText("")
        }

        update.setOnClickListener(){

            var cv = ContentValues()
            cv.put(bakeryProvider.FLAVOUR,theflavour.text.toString())

            contentResolver.update(bakeryProvider.CONTENT_URI,cv,"_ID = ?", arrayOf(theid.text.toString()))
            rs?.requery()

        }

        insert.setOnClickListener(){
            var cv = ContentValues()
            cv.put(bakeryProvider.FLAVOUR,theflavour.text.toString())
            cv.put(bakeryProvider.COLOR,thecolor.text.toString())
            cv.put(bakeryProvider.SIZE,thesize.text.toString().toInt())
            contentResolver.insert(bakeryProvider.CONTENT_URI,cv)
            rs?.requery()
        }

        delete.setOnClickListener(){
            contentResolver.delete(bakeryProvider.CONTENT_URI,"_ID = ?", arrayOf(theid.text.toString()))
            rs?.requery()
        }



    }
}
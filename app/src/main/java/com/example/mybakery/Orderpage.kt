package com.example.mybakery

import android.content.ContentValues
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import android.content.Context
import android.database.sqlite.SQLiteDatabase


class Orderpage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_orderpage)

        val backbtn2 : ImageView = findViewById(R.id.mainpagebtn)
        backbtn2.setOnClickListener() {
            val intent = Intent(this, Homepage::class.java)
            startActivity(intent)
        }




        val colors = arrayOf<String>("Pink", "Purple", "Blue", "Brown")
        val colorspinner : Spinner = findViewById(R.id.spinner2)
        var thecolor = "Pink"
        colorspinner.adapter=ArrayAdapter<String>(this,android.R.layout.simple_expandable_list_item_1,colors)


        colorspinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                thecolor= colors.get(position)

            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }

        }


            val ordeerbtn : TextView = findViewById(R.id.orderBT)
            ordeerbtn.setOnClickListener (){
                val flavour : EditText = findViewById(R.id.flaverED)


                val sizeradiogroup : RadioGroup = findViewById(R.id.sizeRG)
                val selectedOption: Int = sizeradiogroup.checkedRadioButtonId
                val size = this.findViewById<RadioButton>(selectedOption)


                val theflavour=flavour.text.toString()

                if(theflavour!=""){
                    if(thecolor!=""){
                        if(selectedOption!=-1){
                            var cv = ContentValues()
                            cv.put(bakeryProvider.FLAVOUR,theflavour)
                            cv.put(bakeryProvider.COLOR,thecolor)
                            cv.put(bakeryProvider.SIZE,size.text.toString().toInt())
                            contentResolver.insert(bakeryProvider.CONTENT_URI,cv)

                            Toast.makeText(this,"Thank You , Your Order was Submitted ",Toast.LENGTH_SHORT).show()
                        }
                    }
                }
                else
                    Toast.makeText(this,"Sorry , all Fields must be filled to order",Toast.LENGTH_SHORT).show()




            }
        val admintv : TextView = findViewById(R.id.adminBT)
        admintv.setOnClickListener(){
            val intent = Intent(this, Admin::class.java)
            startActivity(intent)

        }

    }


        }






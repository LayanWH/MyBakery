package com.example.mybakery

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class MyHelper(context: Context?): SQLiteOpenHelper(context,"Bakery",null,1) {
    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL("CREATE TABLE allOrders(_id INTEGER PRIMARY KEY AUTOINCREMENT , FLAVOUR TEXT , COLOR TEXT , SIZE INTEGER)")
        db?.execSQL("INSERT INTO allOrders(FLAVOUR,COLOR,SIZE) VALUES('Vanilla','Pink','12')")
        db?.execSQL("INSERT INTO allOrders(FLAVOUR,COLOR,SIZE) VALUES('Chocolate','Brown','22')")
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {

    }

}
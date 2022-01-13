package com.example.mybakery

import android.content.ContentProvider
import android.content.ContentValues
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.net.Uri
import android.provider.SyncStateContract

class bakeryProvider : ContentProvider() {

    companion object {
        val PROVIDER_NAME = "com.example.mybakery/bakeryProvider"
        val URL = "content://$PROVIDER_NAME/allOrders"
        val CONTENT_URI = Uri.parse(URL)

        val _ID = "_id"
        val FLAVOUR = "FLAVOUR"
        val COLOR = "COLOR"
        val SIZE = "SIZE"

        }

    lateinit var db:SQLiteDatabase

    override fun onCreate(): Boolean {
        var helper = MyHelper(context)
        db= helper.writableDatabase
        return if(db==null) false else true
    }

    override fun query(
        uri: Uri,
        cols: Array<out String>?,
        condition: String?,
        condition_val: Array<out String>?,
        order: String?
    ): Cursor? {
        return db.query("allOrders",cols,condition,condition_val,null,null,order)
    }

    override fun getType(uri: Uri): String? {
        return "vnd.android.cursor.dir/vnd.example.allOrders"
    }

    override fun insert(uri: Uri, cv: ContentValues?): Uri? {
        db.insert("allOrders",null,cv)
        context?.contentResolver?.notifyChange(uri,null)
        return uri
    }

    override fun delete(uri: Uri, condition: String?, condition_val: Array<out String>?): Int {
        var count : Int = db.delete("allOrders",condition,condition_val)
        context?.contentResolver?.notifyChange(uri,null)
        return count
    }

    override fun update(
        uri: Uri,
        cv: ContentValues?,
        condition: String?,
        condition_value: Array<out String>?
    ): Int {
        var count : Int = db.update("allOrders",cv,condition,condition_value)
        context?.contentResolver?.notifyChange(uri,null)
        return count
    }
}
package com.example.mybakery

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.fragment.app.DialogFragment

class vanilla : DialogFragment(R.layout.vanilladialog) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val cancelbtn: TextView = view.findViewById(R.id.orderBT)
        cancelbtn.setOnClickListener(){
            dismiss()
        }
    }
}
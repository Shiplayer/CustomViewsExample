package com.example.myapplication

import android.view.View
import android.widget.TextView

class Example {
    var text = "Clicked!"

    fun getOnClickListener() = View.OnClickListener { view: View ->
        if(view is TextView){
            view.text = view.text.toString() + " " + text
        }
    }
}
package com.example.myapplication

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*
import java.io.File

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val example = Example()
        //text.setOnClickListener(example.getOnClickListener())
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(resultCode == Activity.RESULT_OK) {
            if(requestCode == 100){
                if(!data?.dataString.isNullOrEmpty())
                    tv_path.text = File(data!!.dataString!!).absolutePath
                imageView2.setImageURI(data?.data)
            }

            if(requestCode == 101){
                //imageView2.setImageBitmap(data!!.extras.get("data") as Bitmap)
                imageView2.setImageURI(Uri.fromFile(File(customView.currentPhotoPath)))
            }
        }
    }
}

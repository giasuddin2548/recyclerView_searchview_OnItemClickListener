package com.genxmultiplexer.recyclerviewwithonclicklistener.Activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import androidx.core.os.postDelayed
import com.genxmultiplexer.recyclerviewwithonclicklistener.R
import com.squareup.picasso.Picasso

class ActivitySecond : AppCompatActivity() {
    var id: String = ""
    var name: String = ""
    var image: String = ""

    lateinit var imageView: ImageView

    lateinit var textViewId: TextView
    lateinit var textViewName: TextView

    var mHandler:Handler?=null
    var mRunnable:Runnable?=null
    var thread:Thread?=null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        imageView = findViewById(R.id.imageViewId)
        textViewId = findViewById(R.id.textViewId)
        textViewName = findViewById(R.id.textViewNameId)

/*
        val bundle: Bundle = intent.extras!!
        id = bundle.get("ID").toString()
        name = bundle.get("NAME").toString()
        image = bundle.get("IMAGE").toString()


        Picasso.get()
            .load(image)
            .placeholder(R.drawable.ic_launcher_background)
            .error(R.drawable.ic_launcher_background)
            .into(imageView);

        textViewId.text = id
        textViewName.text = name

 */














    }
}


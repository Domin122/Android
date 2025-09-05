package com.example.galeriazdj

import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView

class MainActivity : AppCompatActivity() {

    var images = arrayListOf(R.drawable.a1, R.drawable.a2, R.drawable.a3,R.drawable.a4,R.drawable.a5)
    lateinit var img: ImageView;
    var i = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        img = findViewById(R.id.imageView);
        img.setImageResource(images[i])
    }

    fun changeImage(v: View){
        when (v.id){
            R.id.prev -> {

            }
            R.id.next -> {
                if (i < images.size-1)
                    i++
                else
                    i = 0
                img.setImageResource(images[i])
            }
        }
    }
}
package com.example.imageswitch

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageSwitcher
import android.widget.ImageView
import android.widget.ViewSwitcher

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val imageSwitcher:ImageSwitcher = findViewById(R.id.imageSwitcher)
        val btn:Button = findViewById(R.id.next)
        val btn1:Button = findViewById(R.id.Previous)
        val images = arrayListOf(
            R.drawable.kw1,
            R.drawable.kw2,
            R.drawable.kw3,
            R.drawable.kw4,
            R.drawable.kw5,
            R.drawable.kw6
        )

        var l = 0


        imageSwitcher.setFactory (object: ViewSwitcher.ViewFactory{
            override fun makeView(): View {
                val imgView = ImageView(applicationContext)
                imgView.scaleType = ImageView.ScaleType.CENTER_INSIDE
                return imgView
            }
        })


        btn.setOnClickListener(){
            l++
            if (l>images.size+1 || l>5){
                l = 0
            }
            imageSwitcher.setInAnimation(applicationContext,android.R.anim.slide_in_left)
            imageSwitcher.setOutAnimation(applicationContext,android.R.anim.slide_out_right)
            imageSwitcher.setImageResource(images[l])
        }

        btn1.setOnClickListener(){
            l--
            if (l < 0) {
                l = images.size - 1
            }

            imageSwitcher.setInAnimation(applicationContext,android.R.anim.slide_in_left)
            imageSwitcher.setOutAnimation(applicationContext,android.R.anim.slide_out_right)
            imageSwitcher.setImageResource(images[l])
        }
    }
}
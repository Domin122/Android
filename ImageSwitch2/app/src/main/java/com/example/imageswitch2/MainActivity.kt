package com.example.imageswitch2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.HorizontalScrollView
import android.widget.ImageSwitcher
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.ScrollView
import android.widget.ViewSwitcher

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val imageSwitcher: ImageSwitcher = findViewById(R.id.imageSwitcher)
        val scrollView:HorizontalScrollView = findViewById(R.id.ScrollView)
        val images = arrayListOf(
            R.drawable.kw1,
            R.drawable.kw2,
            R.drawable.kw3,
            R.drawable.kw4,
            R.drawable.kw5,
            R.drawable.kw6
        )

        imageSwitcher.setFactory (object: ViewSwitcher.ViewFactory{
            override fun makeView(): View {
                val imgView = ImageView(applicationContext)
                imgView.scaleType = ImageView.ScaleType.CENTER_INSIDE
                return imgView
            }
        })

        scrollView.setOnClickListener {

        }

    }
}
package com.example.nastart

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView


class MainActivity : AppCompatActivity() {
    lateinit var licznik: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        licznik = findViewById(R.id.licznik)

        val image:ImageView = findViewById(R.id.imageView)

        val plus: Button = findViewById(R.id.plus)
        plus.setOnClickListener {
            var li: Int = licznik.text.toString().toInt()
            li += 1
            licznik.text = li.toString()
            image.setImageResource(R.drawable.like)
        }

        val minus: Button = findViewById(R.id.minus)
        minus.setOnClickListener {
            var li: Int = licznik.text.toString().toInt()
            li -= 1
            if (li < 0) {
                li = 0
            }
            licznik.text = li.toString()
            image.setImageResource(R.drawable.unlike)
        }




    }
}
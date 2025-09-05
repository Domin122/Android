package com.example.animacja

import android.graphics.drawable.AnimationDrawable
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    lateinit var animacja_kon:AnimationDrawable
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val start = findViewById<Button>(R.id.button)
        val stop = findViewById<Button>(R.id.button2)
        val reverse = findViewById<Button>(R.id.button3)
        val animacja = findViewById<ImageView>(R.id.imageView).apply {
            setBackgroundResource(R.drawable.animacja)
            animacja_kon = background as AnimationDrawable
        }

        start.setOnClickListener {
            animacja_kon.start()
        }
        stop.setOnClickListener {
            animacja_kon.stop()
        }
        reverse.setOnClickListener {
            animacja_kon.start()
        }
    }
}
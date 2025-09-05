package com.example.intencja

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        val button2: Button = findViewById(R.id.button2)
        button2.setOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }
    }
}
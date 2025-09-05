package com.example.intencja1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class second : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.second)

        val text:TextView = findViewById(R.id.textView)
        val btn:Button = findViewById(R.id.button2)

        text.text = intent.getStringExtra("My_data")
        btn.setOnClickListener{
            val intencja = Intent(
                applicationContext,
                MainActivity::class.java)
            startActivity(intencja)
        }
    }
}
package com.example.intencja1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btn:Button = findViewById(R.id.button)
        val txt:TextView = findViewById(R.id.TextView)

        btn.setOnClickListener{
            val intencja = Intent(
                applicationContext,
                second::class.java)
            startActivity(intencja)
        }
    }
}
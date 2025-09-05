package com.example.tap

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class start_gry : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.start_gry)

        val button: Button = findViewById(R.id.button)

        button.setOnClickListener {
            val intent = Intent(applicationContext, start_gry::class.java)
            startActivity(intent) }

    }
}
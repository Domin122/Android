package com.example.zapis_stanu


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button


class SecondActivity : AppCompatActivity() {

    lateinit var btn:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        btn = findViewById(R.id.button)
        btn.setOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }


    }
}
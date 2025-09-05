package com.example.aswitch

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Switch
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    lateinit var switch: Switch
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val text:TextView = findViewById(R.id.text1)
        switch = findViewById(R.id.switch2)

        switch.setOnClickListener {
            if (switch.isChecked) {
                switch.foreground = resources.getDrawable((R.drawable.kontron))
                text.text = "Zaznaczono"
            }
            else{
                switch.foreground = resources.getDrawable((R.drawable.kontroff))
                text.text = "Nie Zaznaczono"
            }
        }
    }
}
package com.example.wielowatkowosc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import java.util.Timer
import java.util.TimerTask


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var napis: TextView = findViewById(R.id.napis)
        var licznik = 0


        Timer().scheduleAtFixedRate(object:TimerTask() {
            override fun run() {
                licznik++
                runOnUiThread(object: Runnable{
                    override fun run() {
                        napis.text=licznik.toString()
                    }
                })
            }
        }, 0, 100)
    }
}


package com.example.stan_aktywnosci

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    lateinit var licznik:TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        licznik= findViewById(R.id.textview)
        val btn:Button = findViewById(R.id.button)

        btn.setOnClickListener {
            var licz:Int = licznik.text.toString().toInt()
            licz++
            licznik.text = licz.toString()
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("keyLicznik", licznik.text.toString().toInt())
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        licznik.text = savedInstanceState.getInt("keyLicznik").toString()
    }

}
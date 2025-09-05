package com.example.urzdzeniadomowe

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val podaj_nr = findViewById<EditText>(R.id.editTextText)
        val btnZatwierdz = findViewById<Button>(R.id.button)
        val txtNrPrania = findViewById<TextView>(R.id.textView2)

        val btnOdkurzacz = findViewById<Button>(R.id.button2)
        val StatusOdkurzacz = findViewById<TextView>(R.id.textView4)
        val Ladowanie = findViewById<TextView>(R.id.textView6)

        btnZatwierdz.setOnClickListener {
            val numer = podaj_nr.text.toString()
            if (numer.isNotEmpty() && numer.toIntOrNull() in 1..12) {
                txtNrPrania.text = "Numer prania: $numer"
            } else {
                txtNrPrania.text = "Za duży numer, maksymalnie nr 12 można podać45"
            }
        }

        btnOdkurzacz.setOnClickListener {
            if (StatusOdkurzacz.text == "Odkurzacz: Włączony"){
                StatusOdkurzacz.text = "Odkurzacz: Wyłączony"
            } else{
                StatusOdkurzacz.text = "Odkurzacz: Włączony"
            }

            Ladowanie.text = "Status: naładowany"
        }
    }
}

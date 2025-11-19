package com.example.rejestrujkonto

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button: Button = findViewById(R.id.button)
        val email: EditText = findViewById(R.id.email)
        val haslo: EditText = findViewById(R.id.haslo)
        val powtorz: EditText = findViewById(R.id.powtorz)
        val komunikat: TextView = findViewById(R.id.komunikat)

        button.setOnClickListener {
            val emailText = email.text.toString().trim()
            val hasloText = haslo.text.toString()
            val powtorzText = powtorz.text.toString()

            when {
                !emailText.contains("@") -> {
                    komunikat.text = "Nieprawidłowy adres e-mail"
                }
                hasloText != powtorzText -> {
                    komunikat.text = "Hasła się różnią"
                }
                else -> {
                    komunikat.text = "Witaj $emailText"
                }
            }
        }
    }
}
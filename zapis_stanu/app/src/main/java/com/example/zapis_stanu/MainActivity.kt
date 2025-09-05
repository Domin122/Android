package com.example.zapis_stanu

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import kotlin.properties.Delegates

class MainActivity : AppCompatActivity() {
    lateinit var licznik:TextView
    var zwieksz by Delegates.notNull<Int>()
    lateinit var btn:Button
    lateinit var button:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        licznik = findViewById(R.id.licznik)
        btn = findViewById(R.id.button)
        button = findViewById(R.id.button2)

        button.setOnClickListener{
            val intent = Intent(this,SecondActivity::class.java)
            startActivity(intent)
        }

        btn.setOnClickListener(){
            zwieksz = licznik.text.toString().toInt()
            zwieksz++
            licznik.text = zwieksz.toString()
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("keyLicznik", zwieksz)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        zwieksz = savedInstanceState.getInt("keyLicznik")
        licznik.text = zwieksz.toString()
    }
}
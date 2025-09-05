package com.example.czcionki

import android.os.Bundle
import android.widget.Button
import android.widget.SeekBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var textViewMessage: TextView
    private lateinit var textViewSize: TextView
    private lateinit var seekBar: SeekBar
    private lateinit var toggleButton: Button

    private var isPolishText = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textViewMessage = findViewById(R.id.textViewMessage)
        textViewSize = findViewById(R.id.textViewSize)
        seekBar = findViewById(R.id.seekBar)
        toggleButton = findViewById(R.id.toggleButton)

        textViewMessage.text = "Dzień dobry"

        seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                textViewMessage.textSize = progress.toFloat()
                textViewSize.text = progress.toString()
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {}
            override fun onStopTrackingTouch(seekBar: SeekBar?) {}
        })

        toggleButton.setOnClickListener {
            textViewMessage.text = if (isPolishText) "Buenos dias" else "Dzień dobry"
            isPolishText = !isPolishText
        }
    }
}

package com.example.kostka

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private lateinit var diceImages: Array<ImageView>
    private lateinit var rollButton: Button
    private lateinit var resetButton: Button
    private lateinit var resultText: TextView
    private var totalScore = 0

    private val diceDrawables = arrayOf(
        R.drawable.k1,
        R.drawable.k2,
        R.drawable.k3,
        R.drawable.k4,
        R.drawable.k5,
        R.drawable.k6
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        diceImages = arrayOf(
            findViewById(R.id.dice1),
            findViewById(R.id.dice2),
            findViewById(R.id.dice3),
            findViewById(R.id.dice4),
            findViewById(R.id.dice5)
        )

        rollButton = findViewById(R.id.rollButton)
        resetButton = findViewById(R.id.resetButton)
        resultText = findViewById(R.id.rollResultText)

        resetDiceImages()

        rollButton.setOnClickListener { rollDice() }
        resetButton.setOnClickListener { resetGame() }
    }

    private fun rollDice() {
        val rolls = IntArray(5)
        val counts = IntArray(7)

        for (i in rolls.indices) {
            val roll = Random.nextInt(1, 7)
            rolls[i] = roll
            counts[roll]++
            diceImages[i].setImageResource(diceDrawables[roll - 1])
        }

        var rollSum = 0
        for (value in 1..6) {
            if (counts[value] >= 2) {
                rollSum += value * counts[value]
            }
        }

        totalScore += rollSum
        resultText.text = "Wynik tego losowania: $rollSum\nWynik gry: $totalScore"
    }

    private fun resetGame() {
        totalScore = 0
        resetDiceImages()
        resultText.text = "Wynik tego losowania: 0\nWynik gry: 0"
    }

    private fun resetDiceImages() {
        for (dice in diceImages) {
            dice.setImageResource(R.drawable.question)
        }
    }
}
package com.example.wisielec

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private lateinit var imageView: ImageView
    private lateinit var wordTextView: TextView
    private lateinit var letterInput: EditText
    private lateinit var guessButton: Button
    private lateinit var livesTextView: TextView
    private lateinit var wrongLettersTextView: TextView
    private lateinit var restartButton: Button

    private val wordList = listOf("WISIELEC", "PROGRAM", "KOTLIN",
        "ANDROID", "KOMPUTER",
        "EDUKACJA", "ZABAWA", "GRA", "KLASA", "SZKOŁA")

    private lateinit var secretWord: String
    private var guessedLetters = mutableSetOf<Char>()
    private var wrongLetters = mutableSetOf<Char>()
    private var wrongGuesses = 0
    private val maxWrong = 10

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        imageView = findViewById(R.id.imageView)
        wordTextView = findViewById(R.id.wordTextView)
        letterInput = findViewById(R.id.letterInput)
        guessButton = findViewById(R.id.guessButton)
        livesTextView = findViewById(R.id.livesTextView)
        wrongLettersTextView = findViewById(R.id.wrongLettersTextView)
        restartButton = findViewById(R.id.restartButton)

        startNewGame()

        guessButton.setOnClickListener {
            val input = letterInput.text.toString().uppercase()
            if (input.isNotEmpty()) {
                val letter = input[0]
                if (letter in guessedLetters || letter in wrongLetters) {
                    Toast.makeText(this, "Już próbowałeś tej litery!", Toast.LENGTH_SHORT).show()
                } else if (letter in secretWord) {
                    guessedLetters.add(letter)
                } else {
                    wrongLetters.add(letter)
                    wrongGuesses++
                    updateImage()
                }
                updateDisplay()
                checkGameOver()
            }
            letterInput.text.clear()
        }

        restartButton.setOnClickListener {
            startNewGame()
        }
    }

    private fun startNewGame() {
        secretWord = wordList.random()
        guessedLetters.clear()
        wrongLetters.clear()
        wrongGuesses = 0
        guessButton.isEnabled = true
        updateImage()
        updateDisplay()
        Toast.makeText(this, "Nowa gra! Słowo ma ${secretWord.length} liter.", Toast.LENGTH_SHORT).show()
    }

    private fun updateImage() {
        val imageResId = resources.getIdentifier("wis$wrongGuesses", "drawable", packageName)
        imageView.setImageResource(imageResId)
    }

    private fun updateDisplay() {
        val displayed = secretWord.map {
            if (it in guessedLetters) it else '_'
        }.joinToString(" ")
        wordTextView.text = displayed

        val livesLeft = maxWrong - wrongGuesses
        livesTextView.text = "Pozostało żyć: $livesLeft"
        wrongLettersTextView.text = "Złe litery: ${wrongLetters.joinToString(", ")}"
    }

    private fun checkGameOver() {
        if (wrongGuesses >= maxWrong) {
            wordTextView.text = secretWord.toCharArray().joinToString(" ")
            Toast.makeText(this, "Przegrałeś! Słowo to: $secretWord", Toast.LENGTH_LONG).show()
            guessButton.isEnabled = false
        } else if (secretWord.all { it in guessedLetters }) {
            Toast.makeText(this, "Wygrałeś!", Toast.LENGTH_LONG).show()
            guessButton.isEnabled = false
        }
    }
}
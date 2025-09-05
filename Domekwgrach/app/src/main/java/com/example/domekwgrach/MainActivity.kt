package com.example.domekwgrach

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private var liczniklike = 0
    private lateinit var polub: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        polub = findViewById(R.id.polub)
        updateLikesCount()

        val likeButton: Button = findViewById(R.id.like)
        likeButton.setOnClickListener { incrementLikes() }

        val dislikeButton: Button = findViewById(R.id.unlike)
        dislikeButton.setOnClickListener { decrementLikes() }
    }

    private fun updateLikesCount() {
        polub.text = getString(R.string.tekst_licznika, liczniklike)
    }

    private fun incrementLikes() {
        liczniklike++
        updateLikesCount()
    }

    private fun decrementLikes() {
        if (liczniklike > 0) {
            liczniklike--
            updateLikesCount()
        }
    }
}

package com.example.ratingbar

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.RatingBar
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private lateinit var ratingBar:RatingBar
    lateinit var txtRating:TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ratingBar = findViewById(R.id.ratingBar)
        txtRating = findViewById(R.id.txtRating)

        ratingBar.setOnRatingBarChangeListener(
            object : RatingBar.OnRatingBarChangeListener{
                @SuppressLint("SetTextI18n")
                override fun onRatingChanged(
                    ratingBar: RatingBar?,
                    rating: Float,
                    fromUser: Boolean
                ) {
                    txtRating.text = "Ocena $rating/5"
                }

            }
        )

    }
}
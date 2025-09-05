package com.example.tap

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.MotionEvent
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.core.view.isVisible
import java.util.Random
import java.util.Timer
import java.util.TimerTask

class MainActivity : AppCompatActivity() {
    private lateinit var wroc: Button
    private lateinit var przegrales:  TextView
    private lateinit var timer: Timer
    private var score = 0
    private var lives = 3
    private lateinit var punkty: TextView
    private lateinit var zycia: TextView
    private lateinit var celownik: ImageView
    private lateinit var jablko: ImageView
    private lateinit var jablko1: ImageView
    private lateinit var jablko2: ImageView
    @SuppressLint("ClickableViewAccessibility")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        timer = Timer()

        celownik = findViewById(R.id.imageView2)
        jablko = findViewById(R.id.imageView)
        jablko1 = findViewById(R.id.imageView3)
        jablko2 = findViewById(R.id.imageView4)
        punkty = findViewById(R.id.punkty)
        zycia = findViewById(R.id.zycia)
        wroc = findViewById(R.id.wroc)

        wroc.setOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }


        celownik.setOnTouchListener { v, e ->
            if (e.action == MotionEvent.ACTION_MOVE) {
                celownik.x += e.x - celownik.width / 2
                celownik.y += e.y - celownik.width / 2
            }
            true
        }

        timer.scheduleAtFixedRate(object : TimerTask() {
            override fun run() {
                runOnUiThread {
                    dropApple()
                }
            }
        }, 0, 20000)
    }

    private fun dropApple() {
        val random = Random()
        val x = random.nextInt(screenWidth - jablko.width)
        val y = random.nextInt(screenWidth - jablko.width)
        jablko.x = x.toFloat()
        jablko.y = y.toFloat()

        val handler = Handler()
        var fallSpeed = 6

        val runnable = object : Runnable {
            override fun run() {
                if (jablko.y + jablko.height < screenHeight) {
                    jablko.y += fallSpeed
                    if (jablko.y + jablko.height >= celownik.y && jablko.y < celownik.y + celownik.height) {
                        if (isCollision(jablko, celownik)) {
                            dropApple()
                            updateScore()
                            fallSpeed +=2
                            return
                        }
                    }
                    handler.postDelayed(this, 10)
                } else {
                    loseLife()
                    fallSpeed -= 10
                    jablko.y = 0f
                    if (lives > 0) {
                        dropApple()
                    } else {
                        gameOver()
                    }
                }
            }
        }

        handler.post(runnable)
    }

    private fun updateScore() {
        score += 1
        punkty.text = "Punkty: $score"
    }

    private fun loseLife() {
        lives -= 1
        updateLivesText()
    }


    private fun updateLivesText() {
        zycia.text = "Życia: $lives"
    }

    private fun isCollision(view1: ImageView, view2: ImageView): Boolean {
        return view1.x < view2.x + view2.width &&
                view1.x + view1.width > view2.x &&
                view1.y < view2.y + view2.height &&
                view1.y + view1.height > view2.y
    }

    private fun gameOver() {
        wroc.isVisible
        przegrales.isVisible
    }

    private val screenWidth: Int
        get() = resources.displayMetrics.widthPixels

    private val screenHeight: Int
        get() = resources.displayMetrics.heightPixels
    }

package com.example.drzewotapniecie

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.MotionEvent
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import java.util.*

class Second : AppCompatActivity() {
    private lateinit var timer: Timer
    private lateinit var koszyk: ImageView
    private lateinit var jablko: ImageView
    private lateinit var wroc: Button
    private lateinit var przegrales:  TextView
    private var score = 0
    private var lives = 3
    private lateinit var punkty: TextView
    private lateinit var zycia: TextView
    private var xleft: Float = 0f

    @SuppressLint("ClickableViewAccessibility")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        timer = Timer()

        koszyk = findViewById(R.id.koszyk)
        jablko = findViewById(R.id.jablko)
        punkty = findViewById(R.id.punkty)
        zycia = findViewById(R.id.zycia)
        wroc = findViewById(R.id.wroc)

        wroc.setOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }

        koszyk.setOnTouchListener(View.OnTouchListener { _, event ->
            when (event.action) {
            MotionEvent.ACTION_DOWN -> {
                xleft = event.x
            }
            MotionEvent.ACTION_MOVE -> {
                val xMoved = event.x
                val distanceX = xMoved - xleft
                koszyk.x = koszyk.x + distanceX
            }
        }
        true
    })

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
        jablko.x = x.toFloat()
        jablko.y = 0f

        val handler = Handler()
        var fallSpeed = 10

        val runnable = object : Runnable {
            override fun run() {
                if (jablko.y + jablko.height < screenHeight) {
                    jablko.y += fallSpeed
                    if (jablko.y + jablko.height >= koszyk.y && jablko.y < koszyk.y + koszyk.height) {
                        if (isCollision(jablko, koszyk)) {
                            dropApple()
                            updateScore()
                            fallSpeed +=2
                            return
                        }
                    }
                    handler.postDelayed(this, 10)
                } else {
                    loseLife()
                    fallSpeed = 10
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

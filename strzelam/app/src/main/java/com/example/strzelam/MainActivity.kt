package com.example.strzelam

import android.annotation.SuppressLint
import android.os.Bundle
import android.os.Handler
import android.view.MotionEvent
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import java.util.Random
import java.util.Timer
import java.util.TimerTask

class MainActivity : AppCompatActivity() {
    lateinit var przegrales: TextView
    private lateinit var timer: Timer
    private var score = 0
    private var lives = 3
    private lateinit var punkty: TextView
    private lateinit var zycia: TextView
    private lateinit var celownik: ImageView
    private lateinit var jablko: ImageView
    private lateinit var jablko1: ImageView
    private lateinit var jablko2: ImageView
    lateinit var reset: Button

    @SuppressLint("ClickableViewAccessibility")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        timer = Timer()

        celownik = findViewById(R.id.imageView2)
        jablko = findViewById(R.id.imageView)
        jablko1 = findViewById(R.id.imageView3)
        jablko2= findViewById(R.id.imageView4)
        punkty = findViewById(R.id.punkty)
        zycia = findViewById(R.id.zycia)
        reset = findViewById(R.id.button_1)
        przegrales = findViewById(R.id.Przegrales)

        przegrales.isVisible = false
        reset.isVisible = false


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
                    dropApple1()
                    dropApple2()
                }
            }
        }, 0, 20000)

        reset.setOnClickListener {
            val mIntent = intent
            finish()
            startActivity(mIntent)
        }

    }

    fun gameOver() {
        przegrales.isVisible = true
        reset.isVisible = true

    }

    private fun dropApple() {
        val random = Random()
        val x = random.nextInt(screenWidth - jablko.width)
        val y = random.nextInt(screenWidth - jablko.width)
        jablko.x = x.toFloat()
        jablko.y = y.toFloat()

        val handler = Handler()
        var fallSpeed = 10

        val runnable = object : Runnable {
            override fun run() {
                if (lives == 0) return
                if (jablko.y + jablko.height < screenHeight) {
                    jablko.y += fallSpeed
                    if (jablko.y + jablko.height >= celownik.y && jablko.y < celownik.y + celownik.height) {
                        if (isCollision(jablko, celownik)) {
                            dropApple()
                            updateScore()
                            fallSpeed += 15
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
                        fallSpeed = 0
                    }
                }
            }
        }
        handler.post(runnable)
    }

    private fun dropApple1() {
        val random = Random()
        val x1 = random.nextInt(screenWidth - jablko1.width)
        val y1 = random.nextInt(screenWidth - jablko1.width)
        jablko1.x = x1.toFloat()
        jablko1.y = y1.toFloat()

        val handler = Handler()
        var fallSpeed = 10

        val runnable = object : Runnable {
            override fun run() {
                if (lives == 0) return
                if (jablko1.y + jablko1.height < screenHeight) {
                    jablko1.y += fallSpeed
                    if (jablko1.y + jablko1.height >= celownik.y && jablko1.y < celownik.y + celownik.height) {
                        if (isCollision1(jablko1, celownik)) {
                            dropApple1()
                            updateScore()
                            fallSpeed += 15
                            return
                        }
                    }
                    handler.postDelayed(this, 10)
                } else {
                    loseLife()
                    fallSpeed = 10
                    jablko1.y = 0f
                    if (lives > 0) {
                        dropApple1()
                    } else {
                        gameOver()
                        fallSpeed = 0
                    }
                }
            }
        }
        handler.post(runnable)
    }

    private fun dropApple2() {
        val random = Random()
        val x2 = random.nextInt(screenWidth - jablko2.width)
        val y2 = random.nextInt(screenWidth - jablko2.width)
        jablko2.x = x2.toFloat()
        jablko2.y = y2.toFloat()

        val handler = Handler()
        var fallSpeed = 10

        val runnable = object : Runnable {
            override fun run() {
                if (lives == 0) return
                if (jablko2.y + jablko2.height < screenHeight) {
                    jablko2.y += fallSpeed
                    if (jablko2.y + jablko2.height >= celownik.y && jablko2.y < celownik.y + celownik.height) {
                        if (isCollision2(jablko2, celownik)) {
                            dropApple2()
                            updateScore()
                            fallSpeed += 15
                            return
                        }
                    }
                    handler.postDelayed(this, 10)
                } else {
                    loseLife()
                    fallSpeed = 10
                    jablko2.y = 0f
                    if (lives > 0) {
                        dropApple2()
                    } else {
                        gameOver()
                        fallSpeed = 0
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

    private fun isCollision1(view3: ImageView, view2: ImageView): Boolean {
        return view3.x < view2.x + view2.width &&
                view3.x + view3.width > view2.x &&
                view3.y < view2.y + view2.height &&
                view3.y + view3.height > view2.y
    }

    private fun isCollision2(view4: ImageView, view2: ImageView): Boolean {
        return view4.x < view2.x + view2.width &&
                view4.x + view4.width > view2.x &&
                view4.y < view2.y + view2.height &&
                view4.y + view4.height > view2.y
    }



    private val screenWidth: Int
        get() = resources.displayMetrics.widthPixels

    private val screenHeight: Int
        get() = resources.displayMetrics.heightPixels
}

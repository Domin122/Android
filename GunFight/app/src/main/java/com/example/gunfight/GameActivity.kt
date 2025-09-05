package com.example.gunfight

import android.annotation.SuppressLint
import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.MotionEvent
import android.view.View
import android.view.animation.TranslateAnimation
import android.widget.Button
import android.widget.ImageView
import androidx.constraintlayout.widget.ConstraintLayout
import java.util.ArrayList
import java.util.Random
import kotlin.math.absoluteValue

class GameActivity : AppCompatActivity() {

    lateinit var gameLayout: ConstraintLayout
    lateinit var yValues: FloatArray
    lateinit var up: Button
    lateinit var down: Button
    lateinit var fire: Button
    lateinit var player1: ImageView
    lateinit var player2: ImageView
    lateinit var karoca: ImageView
    private var animUp: TranslateAnimation? = null
    private var animDown: TranslateAnimation? = null
    private var isMovingUp = false


    @SuppressLint("ClickableViewAccessibility")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)

        gameLayout = findViewById(R.id.gameLayout1)
        yValues = FloatArray(6)

        player1 = findViewById(R.id.player1)
        player2 = findViewById(R.id.player2)
        karoca = findViewById(R.id.karoca)


        up = findViewById(R.id.up)
        down = findViewById(R.id.down)
        fire = findViewById(R.id.fire)

        fun checkMinDistance(): Float {
            var minDistance: Float = 1000F
            for (i in 0 until 6) {
                for (j in i + 1 until 6) {
                    val distance = Math.abs(yValues[i] - yValues[j])
                    if (distance < minDistance) {
                        minDistance = distance
                    }
                }
            }
            return minDistance
        }

        fun createMap() {
            for (i in 0 until 6) {
                val obstacle: ImageView = ImageView(this)
                gameLayout.addView(obstacle)

                val x1 = (850..900).random().toFloat()
                val x2 = (1300..1350).random().toFloat()

                val y = (10..850).random().toFloat()
                val leftOrRight = (0..1).random()

                if (leftOrRight == 0) {
                    obstacle.x = x1
                } else {
                    obstacle.x = x2
                }

                obstacle.y = y

                yValues[i] = y

                val treeOrCactus = (0..1).random()
                if (treeOrCactus == 0) {
                    obstacle.setBackgroundResource(R.drawable.pixil_frame_0__3_)
                } else {
                    obstacle.setBackgroundResource(R.drawable.pixil_frame_0__1_)
                }

            }

            val minDistance = checkMinDistance().absoluteValue

            if (minDistance < 100) {
                gameLayout.removeAllViews()
                createMap()
            }
        }

        createMap()

        animUp = TranslateAnimation(0f, 0f, 0f, 800f).apply {
            duration = 6000
            repeatCount = TranslateAnimation.INFINITE
            repeatMode = TranslateAnimation.REVERSE
        }

        animDown = TranslateAnimation(0f, 0f, 0f, -800f).apply {
            duration = 6000
            repeatCount = TranslateAnimation.INFINITE
            repeatMode = TranslateAnimation.REVERSE
        }

        karoca.startAnimation(animDown)

        karoca.setOnTouchListener { _, event ->
            when (event.action) {
                MotionEvent.ACTION_DOWN -> {
                    karoca.clearAnimation()
                    true
                }
                MotionEvent.ACTION_UP -> {
                    if (isMovingUp) {
                        karoca.startAnimation(animUp)
                    } else {
                        karoca.startAnimation(animDown)
                    }
                    isMovingUp = !isMovingUp
                    true
                }
                else -> false
            }
        }
        }
    }





package com.example.tapniecie

import android.annotation.SuppressLint
import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import android.widget.ImageView

class MainActivity : AppCompatActivity() {
    lateinit var star:ImageView;
    @SuppressLint("ClickableViewAccessibility")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var xDown:Float = 0f
        var yDown:Float = 0f

        star = findViewById(R.id.star)

        star.setOnTouchListener(View.OnTouchListener { v, event ->
            when(event.action){
                MotionEvent.ACTION_DOWN ->{
                    xDown = event.x
                    yDown = event.y
                }
                MotionEvent.ACTION_MOVE ->{
                    val xMoved = event.x
                    val yMoved = event.x

                    val distanceX = xMoved - xDown
                    val distanceY = yMoved - yDown

                    star.x = star.x + distanceX
                    star.y = star.y + distanceX
                }
            }


            true
        })


    }
}
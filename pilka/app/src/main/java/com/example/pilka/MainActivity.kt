package com.example.pilka

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView

class MainActivity : AppCompatActivity() {
    lateinit var pilka: ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        pilka = findViewById(R.id.imageView)
    }

    fun wLewo_obrot(v: View){
        pilka.rotation += -5f

    }
    fun wPrawo_obrot(v:View){
        pilka.rotation += 5f
    }

    fun do_gory(v: View){
        pilka.top += -10
    }

    fun na_dol(v: View){
        pilka.top += 10
    }

    fun lewo(v: View){
        pilka.left += -10
    }

    fun prawo(v: View){
        pilka.left += 10
    }
}

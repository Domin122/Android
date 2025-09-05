package com.example.spinner

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.AdapterView.OnItemClickListener
import android.widget.AdapterView.OnItemSelectedListener
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.Spinner
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val emocje = arrayListOf<String>("Złość","Radość","Smutek")

        val adapterX = ArrayAdapter(applicationContext,android.R.layout.simple_list_item_1,emocje)

        val image:ImageView = findViewById(R.id.imageView)
        val spin:Spinner = findViewById(R.id.spinner)
        spin.adapter = adapterX

        spin.onItemSelectedListener = object : OnItemSelectedListener{
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                Toast.makeText(applicationContext, emocje[position],Toast.LENGTH_SHORT).show()

                emocje[3] = image.setImageResource(R.drawable.zo).toString()
                emocje[2] = image.setImageResource(R.drawable.rado).toString()
                emocje[1] = image.setImageResource(R.drawable.smutek).toString()

            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }


        }
    }
}
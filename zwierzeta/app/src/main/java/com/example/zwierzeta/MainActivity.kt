package com.example.zwierzeta

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val listView: ListView = findViewById(R.id.ListView)
        val spinner: Spinner = findViewById(R.id.spinner)
        val editTitle: EditText = findViewById(R.id.editTextText2)
        val editDescipt: EditText = findViewById(R.id.editTextText)
        val button: Button = findViewById(R.id.button)

        val images = listOf(
            R.drawable.bird,
            R.drawable.cat,
            R.drawable.dog
        )

        val titles = listOf(
            getString(R.string.title_bird),
            getString(R.string.title_cat),
            getString(R.string.title_dog)
        )

        val descriptions = listOf(
            getString(R.string.descript_bird),
            getString(R.string.descript_cat),
            getString(R.string.descript_dog)
        )

        listView.adapter = ItemAdapter(this, images,titles,descriptions)
    }

}
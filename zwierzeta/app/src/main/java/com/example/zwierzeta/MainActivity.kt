package com.example.zwierzeta

import android.os.Bundle
import android.view.View
import android.widget.*
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

        val animals = listOf("bird", "cat", "dog","fish","fox","frog","horse","lion","panda")

        spinner.adapter = ArrayAdapter(
            this,
            android.R.layout.simple_spinner_dropdown_item,
            animals
        )

        val animalImages = mapOf(
            "bird" to R.drawable.bird,
            "cat" to R.drawable.cat,
            "dog" to R.drawable.dog,
            "fish" to R.drawable.fish,
            "fox" to R.drawable.fox,
            "frog" to R.drawable.frog,
            "horse" to R.drawable.horse,
            "lion" to R.drawable.lion,
            "panda" to R.drawable.panda
        )

        val animalTitles = mapOf(
            "bird" to R.string.title_bird,
            "cat" to R.string.title_cat,
            "dog" to R.string.title_dog
        )

        val animalDescriptions = mapOf(
            "bird" to R.string.descript_bird,
            "cat" to R.string.descript_cat,
            "dog" to R.string.descript_dog
        )

        val images = mutableListOf<Int>()
        val titles = mutableListOf<String>()
        val descriptions = mutableListOf<String>()

        val adapter = ItemAdapter(this, images, titles, descriptions)
        listView.adapter = adapter

        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>,
                view: View?,
                position: Int,
                id: Long
            ) {
                val selected = animals[position]
                editTitle.setText(getString(animalTitles[selected]!!))
                editDescipt.setText(getString(animalDescriptions[selected]!!))
            }

            override fun onNothingSelected(parent: AdapterView<*>) {}
        }

        button.setOnClickListener {
            val selected = spinner.selectedItem.toString()

            images.add(animalImages[selected]!!)
            titles.add(editTitle.text.toString())
            descriptions.add(editDescipt.text.toString())

            adapter.notifyDataSetChanged()
        }
    }
}
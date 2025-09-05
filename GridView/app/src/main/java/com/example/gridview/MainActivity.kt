package com.example.gridview

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.GridView
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var gridView: GridView
    private lateinit var spinner: Spinner
    private lateinit var imageAdapter: ImageAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        gridView = findViewById(R.id.GridView)
        spinner = findViewById(R.id.spinner)


        val categories = listOf("Buty sportowe", "Samochody", "Rowery")


        val spinnerAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, categories)
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = spinnerAdapter


        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                updateGridView(categories[position])
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }


        updateGridView(categories[0])
    }

    private fun updateGridView(category: String) {
        val imageList = ArrayList<Int>()

        val prefix = when (category) {
            "Buty sportowe" -> "buty"
            "Samochody" -> "auto"
            "Rowery" -> "rower"
            else -> "buty"
        }

        for (i in 1..12) {
            val resId = resources.getIdentifier("${prefix}$i", "drawable", packageName)
            if (resId != 0) imageList.add(resId)
        }

        imageAdapter = ImageAdapter(gridView, imageList)
        gridView.adapter = imageAdapter
    }
}
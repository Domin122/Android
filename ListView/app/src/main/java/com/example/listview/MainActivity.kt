package com.example.listview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val lista = arrayListOf<String>("Test1","Test2")
        val btn:Button = findViewById(R.id.button)
        var txt:TextView = findViewById(R.id.editText)
        val lview:ListView = findViewById(R.id.ListView)

        val adapter:ArrayAdapter<String> = ArrayAdapter(
            applicationContext,
            android.R.layout.simple_list_item_1,
            lista)

        lview.adapter = adapter

        btn.setOnClickListener{
            if (txt.text != "")
                lista.add(txt.text.toString())
            lview.adapter = adapter
        }

        lview.setOnItemClickListener { parent, view, position, id ->
            if (txt.text != "")
                lista.remove(txt.text.toString())
            lview.adapter = adapter
        }
    }
}
package com.example.dialog_znowu

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Adapter
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val imiona = arrayListOf("Ada","Anna","Dorota","Ewelina","Zuzanna")

        val spinner:Spinner = findViewById(R.id.spinner)

        val adapter = ArrayAdapter(
            applicationContext,
            android.R.layout.simple_list_item_1,
            imiona)

        spinner.adapter = adapter

        spinner.onItemSelectedListener = object:AdapterView.OnItemClickListener,
            AdapterView.OnItemSelectedListener {
            override fun onItemClick(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {

            }
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                basicAlert(imiona[position])
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }

    }

    fun basicAlert(txt:String){
        val okno = AlertDialog.Builder(this)
        okno.apply {
            setTitle("Informacja")
            setMessage(txt)
            setPositiveButton("OK",DialogInterface.OnClickListener { dialog, which ->  })
        }.create().show()
    }
}
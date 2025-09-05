package com.example.dialog_weterynarz

import android.content.DialogInterface
import android.icu.text.Transliterator.Position
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.SeekBar
import android.widget.Spinner
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val gatunki = arrayListOf("Pies","Kot","Świnka morska")

        val gatunek:Spinner = findViewById(R.id.spinner)
        val imie:EditText = findViewById(R.id.editTextText)
        val wiek:SeekBar = findViewById(R.id.seekBar)
        val cel:EditText = findViewById(R.id.editTextText2)
        val godz:EditText = findViewById(R.id.editTextTime)
        val btn:Button = findViewById(R.id.button)



        val adapter = ArrayAdapter(
            applicationContext,
            android.R.layout.simple_list_item_1,
            gatunki)

        gatunek.adapter = adapter



        btn.setOnClickListener {
            val Imie = imie.text.toString()
            val Gatunek = gatunek.selectedItem.toString()
            val Wiek = wiek.progress
            val Cel = cel.text.toString()
            val Godz = godz.text.toString()

            val msg = "Imię właściciela: $Imie\nGatunek: $Gatunek\nWiek: $Wiek\nCel wizyty: $Cel\nGodzina: $Godz"

            basicAlert(msg)
        }


    }


    fun basicAlert(txt: String){
        val okno = AlertDialog.Builder(this)
        okno.apply {
            setTitle("Wizyta")
            setMessage(txt)
            setPositiveButton("OK", DialogInterface.OnClickListener { dialog, which ->  })
        }.create().show()
    }


}
package com.example.db

import android.database.Cursor
import android.database.sqlite.SQLiteStatement
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val db = openOrCreateDatabase("myDB", MODE_PRIVATE,null)
        var sqlDB = "CREATE TABLE IF NOT EXISTS studencix(id INTEGER, imie VARCHAR, nazwisko VARCHAR)"
        db.execSQL(sqlDB)

        sqlDB = "SELECT count(*) FROM studencix"

        val cursor: Cursor = db.rawQuery(sqlDB,null)
        cursor.moveToFirst()
        val ilosc: Int = cursor.getInt(0)
        cursor.close()

        if (ilosc == 0){
            sqlDB = "INSERT INTO studencix VALUES(?, ?, ?)"
            val statement: SQLiteStatement = db.compileStatement(sqlDB)

            statement.bindLong(1,1)
            statement.bindString(2,"Jan")
            statement.bindString(3,"Kowalski")
            statement.executeInsert()

            statement.bindLong(1,2)
            statement.bindString(2,"Adam")
            statement.bindString(3,"Nowak")
            statement.executeInsert()
        }

        val btn: Button = findViewById(R.id.show)
        val btn1: Button = findViewById(R.id.button)
        val imie:TextView = findViewById(R.id.editTextText)
        val nazwisko:TextView = findViewById(R.id.editTextText2)
        val listView: ListView = findViewById(R.id.ListView)

        btn.setOnClickListener{
            val wyniki = arrayListOf<String>()
            val c:Cursor = db.rawQuery("SELECT id,imie,nazwisko" + " FROM studencix", null)

            if (c.moveToFirst()){
                do{
                    val idx = c.getInt(0)
                    val imie = c.getString(1)
                    val nazwisko = c.getString(2)
                    wyniki.add("$idx $imie $nazwisko")
                } while (c.moveToNext())
            }
            val adapter: ArrayAdapter<String> = ArrayAdapter(
                applicationContext,
                android.R.layout.simple_list_item_1,
                wyniki)
            listView.adapter = adapter
            c.close()
        }

        btn1.setOnClickListener {
            val imieText = imie.text.toString()
            val nazwiskoText = nazwisko.text.toString()

            if (imieText.isNotEmpty() && nazwiskoText.isNotEmpty()) {
                val cursor: Cursor = db.rawQuery("SELECT MAX(id) FROM studencix", null)
                cursor.moveToFirst()
                val nextId = cursor.getInt(0) + 1
                cursor.close()

                val sqlInsert = "INSERT INTO studencix VALUES(?, ?, ?)"
                val statement: SQLiteStatement = db.compileStatement(sqlInsert)

                statement.bindLong(1, nextId.toLong())
                statement.bindString(2, imieText)
                statement.bindString(3, nazwiskoText)
                statement.executeInsert()

                imie.text = ""
                nazwisko.text = ""

                val wyniki = arrayListOf<String>()
                val c: Cursor = db.rawQuery("SELECT id, imie, nazwisko FROM studencix", null)

                if (c.moveToFirst()) {
                    do {
                        val idx = c.getInt(0)
                        val imie = c.getString(1)
                        val nazwisko = c.getString(2)
                        wyniki.add("$idx $imie $nazwisko")
                    } while (c.moveToNext())
                }


                val adapter: ArrayAdapter<String> = ArrayAdapter(
                    applicationContext,
                    android.R.layout.simple_list_item_1,
                    wyniki
                )
                listView.adapter = adapter
                c.close()
            } else {
                Toast.makeText(this, "Wypełnij oba pola!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
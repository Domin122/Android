package com.example.aplikacja_wykorzystujaca_baze_danych

import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var db: SQLiteDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        db = openOrCreateDatabase("Uczelnia", MODE_PRIVATE, null)
        val sqlDB = "CREATE TABLE IF NOT EXISTS STUDENCI (Id INTEGER, Imie VARCHAR, Nazwisko VARCHAR)"
        db.execSQL(sqlDB)

        val sqlCount = "SELECT count(*) FROM STUDENCI"
        val cursor = db.rawQuery(sqlCount, null)
        cursor.moveToFirst()
        val ilosc = cursor.getInt(0)
        cursor.close()

        if (ilosc == 0) {
            val sqlStudent = "INSERT INTO STUDENCI VALUES (?, ?, ?)"
            val statement = db.compileStatement(sqlStudent)

            statement.bindLong(1, 1)
            statement.bindString(2, "Jan")
            statement.bindString(3, "Kowalski")
            statement.executeInsert()

            statement.clearBindings()
            statement.bindLong(1, 2)
            statement.bindString(2, "Anna")
            statement.bindString(3, "Nowak")
            statement.executeInsert()
        }
    }

    fun onClick(view: View) {
        val wyniki = ArrayList<String>()
        val cursor = db.rawQuery("SELECT Id, Imie, Nazwisko FROM STUDENCI", null)

        if (cursor.moveToFirst()) {
            do {
                val id = cursor.getInt(cursor.getColumnIndexOrThrow("Id"))
                val imie = cursor.getString(cursor.getColumnIndexOrThrow("Imie"))
                val nazwisko = cursor.getString(cursor.getColumnIndexOrThrow("Nazwisko"))

                wyniki.add("Id: $id, Imię: $imie, Nazwisko: $nazwisko")
            } while (cursor.moveToNext())
        }

        val listView = findViewById<ListView>(R.id.listView)
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, wyniki)
        listView.adapter = adapter

        cursor.close()
    }
}
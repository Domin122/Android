package com.example.listview_z_obrazkiem

import android.icu.text.Transliterator.Position
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.ListView
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val widokiListView:ListView = findViewById(R.id.widoki)
        val img_duzy:ImageView = findViewById(R.id.imageView)
        val title:TextView = findViewById(R.id.textView)
        val desc:TextView = findViewById(R.id.textView2)

        val widoki = mutableListOf<myDataList>()
        widoki.add(myDataList(R.drawable.kw1 ,"Drzewo","Ładnie wygląda"))
        widoki.add(myDataList(R.drawable.kw2 ,"Inne Drzewo","Ładnie wygląda"))
        widoki.add(myDataList(R.drawable.kw3 ,"Kolejne Drzewo","Ładnie wygląda"))
        widoki.add(myDataList(R.drawable.kw4 ,"Domki w Górach","Ładnie wygląda"))
        widoki.add(myDataList(R.drawable.kw5 ,"Krajobraz Jeśień","Ładnie wygląda"))
        widoki.add(myDataList(R.drawable.kw6 ,"Krajobraz zima","Ładnie wygląda"))

        widokiListView.adapter= adapter(this,widoki)

        widokiListView.setOnItemClickListener{ adapter, view, i,l ->
            img_duzy.visibility = ImageView.VISIBLE
            img_duzy.setImageResource(widoki[i].img)
            title.text = widoki[i].title
            desc.text = widoki[i].desc
        }
    }

}
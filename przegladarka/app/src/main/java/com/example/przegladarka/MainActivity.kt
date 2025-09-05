package com.example.przegladarka

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.webkit.WebView
import android.widget.Button
import android.widget.TextView
import java.net.URL

class MainActivity : AppCompatActivity() {
    lateinit var url:TextView
    lateinit var go:Button
    lateinit var weBrowser: WebView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        url = findViewById(R.id.https)
        go = findViewById(R.id.button)
        weBrowser = findViewById(R.id.webView)
    }

    fun goWww(v: View){
        weBrowser.loadUrl(url.text.toString())
    }
}
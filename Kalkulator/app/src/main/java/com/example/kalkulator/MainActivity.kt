package com.example.kalkulator

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    lateinit var wysw:TextView
    lateinit var btn:Button
    var mem: Double? = null
    var dzialanie: String? = null
    var test:Boolean = false

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        wysw = findViewById(R.id.wysw)
    }

    fun czysc(y: View){
        wysw.text = "0"
    }

    fun btn(v: View){
        var press:String=""
        if (wysw.text == "0")
            wysw.text=""
        var pom = wysw.text
        when (v.id){
            R.id.btn9 -> {
                press = "9"
            }
            R.id.btn8 -> {
                press = "8"
            }
            R.id.btn7 -> {
                press = "7"
            }
            R.id.btn6 -> {
                press = "6"
            }
            R.id.btn5 -> {
                press = "5"
            }
            R.id.btn4 -> {
                press = "4"
            }
            R.id.btn3 -> {
                press = "3"
            }
            R.id.btn2 -> {
                press = "2"
            }
            R.id.btn1 -> {
                press = "1"
            }
            R.id.btn0 -> {
                press = "0"
            }
            R.id.minus ->{ if (mem == null) {
                if (wysw.text.toString() != "")
                    mem = wysw.text.toString().toDouble()
                dzialanie = "-"
                test = false
            }
            else {
                pom = wykonaj_dzialanie(dzialanie, wysw.text.toString().toDouble()).toString()
                mem = null
                test = true
            }
            }
            R.id.mnoz -> {          if (mem == null) {
                if (wysw.text.toString() != "")
                    mem = wysw.text.toString().toDouble()
                dzialanie = "*"
                test = false
            }
            else {
                pom = wykonaj_dzialanie(dzialanie, wysw.text.toString().toDouble()).toString()
                mem = null
                test = true
            }
            }
            R.id.Dziel -> {          if (mem == null) {
                if (wysw.text.toString() != "")
                    mem = wysw.text.toString().toDouble()
                dzialanie = "/"
                test = false
            }
            else {
                pom = wykonaj_dzialanie(dzialanie, wysw.text.toString().toDouble()).toString()
                mem = null
                test = true
            }
            }
            R.id.plus -> {
                if (mem == null) {
                    if (wysw.text.toString() != "")
                        mem = wysw.text.toString().toDouble()
                    dzialanie = "+"
                    test = false
                }
                else {
                    pom = wykonaj_dzialanie(dzialanie, wysw.text.toString().toDouble()).toString()
                    mem = null
                    test = true
                }

            }
            R.id.wynik -> {
                    if (mem != null && dzialanie != null) {
                        pom = wykonaj_dzialanie(dzialanie, wysw.text.toString().toDouble()).toString()
                        mem = null
                        dzialanie = null
                        test = true
                    }

            }
        }
        if (mem != null && test == false) {
            wysw.text = ""
            test = true
        }
        else
            wysw.text = pom.toString()+press
    }

    private fun wykonaj_dzialanie(dzialanie: String?, toDouble: Double):Double? {
        when (dzialanie){
            "+" -> return toDouble + mem!!
            "-" -> return mem!! - toDouble
            "*" -> return toDouble * mem!!
            "/" -> return mem!! / toDouble
        }
        return null
    }

}


package com.example.budzik

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.AlarmClock
import android.view.View

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }
    fun onClickAlarm(v: View){
        val intent = Intent(AlarmClock.ACTION_SET_ALARM)
            .putExtra(AlarmClock.EXTRA_MESSAGE, R.string.wake_up)
            .putExtra(AlarmClock.EXTRA_HOUR, 17)
            .putExtra(AlarmClock.EXTRA_MINUTES,54)
        startActivity(intent)
    }

    fun onClickTimer(v: View){
        val intent = Intent(AlarmClock.ACTION_SET_TIMER)
            .putExtra(AlarmClock.EXTRA_MESSAGE, R.string.odliczanie)
            .putExtra(AlarmClock.EXTRA_LENGTH, 15)
            .putExtra(AlarmClock.EXTRA_SKIP_UI,false)
        startActivity(intent)
    }
}
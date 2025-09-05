package com.example.powiadomienia

import androidx.appcompat.app.AppCompatActivity
import android.app.NotificationManager
import android.app.Notification
import android.app.NotificationChannel
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.core.app.NotificationCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btn:Button = findViewById(R.id.button)

        btn.setOnClickListener {
            val groupKey = "Moja Grupa"
            val importance = NotificationManager.IMPORTANCE_DEFAULT
            val mchanel = NotificationChannel("Chanel_id","Kanal_id",importance)

            val notification0 = NotificationCompat.Builder(applicationContext,mchanel.id)
                .setSmallIcon(android.R.drawable.ic_dialog_info)
                .setContentTitle("Powiadomienie grupowe")
                .setContentText("Masz 3 nowe powiadomienia")
                .setGroup(groupKey)
                .setGroupSummary(true)
                .build()

            val notification1 = NotificationCompat.Builder(applicationContext,mchanel.id)
                .setSmallIcon(android.R.drawable.ic_dialog_info)
                .setContentTitle("Nowe powiadomienie")
                .setContentText("To jest 1. powiadomienie")
                .setGroup(groupKey)
                .build()

            val notification2 = NotificationCompat.Builder(applicationContext,mchanel.id)
                .setSmallIcon(android.R.drawable.ic_dialog_info)
                .setContentTitle("Nowe powiadomienie")
                .setContentText("To jest 2. powiadomienie")
                .setGroup(groupKey)
                .build()

            val notification3 = NotificationCompat.Builder(applicationContext,mchanel.id)
                .setSmallIcon(android.R.drawable.ic_dialog_info)
                .setContentTitle("Nowe powiadomienie")
                .setContentText("To jest 3. powiadomienie")
                .setGroup(groupKey)
                .build()

            val notifyMgr = getSystemService(NOTIFICATION_SERVICE) as NotificationManager
            val Id0 = 0
            val Id1 = 1
            val Id2 = 2
            val Id3 = 3
            notifyMgr.notify(Id1, notification1)
            notifyMgr.notify(Id2, notification2)
            notifyMgr.notify(Id3, notification3)
            notifyMgr.notify(Id0, notification0)
        }


    }
}




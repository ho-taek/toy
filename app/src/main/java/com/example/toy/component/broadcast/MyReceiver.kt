package com.example.toy.component.broadcast

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log

class MyReceiver : BroadcastReceiver() {
    override fun onReceive(contenxt : Context?, intent: Intent?) {
        Log.d("broadcast", "receive 받기 ${intent?.action}")
    }
}
package com.example.toy.component.service

import android.app.Service
import android.content.Intent
import android.os.Binder
import android.os.IBinder

class MyBoundService : Service() {


    //바인더 클래스 정의
    inner class LocalBinder : Binder(){
        fun getService() : MyBoundService = this@MyBoundService
    }

    //바인더 인스턴스 생성
    private val binder = LocalBinder()

    //서비스에서 제공할 메서드
    fun getCurrentTime() : String{
        return System.currentTimeMillis().toString()
    }

    override fun onBind(p0: Intent?): IBinder? {
        return binder
    }
}
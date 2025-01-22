package com.example.toy.component.service

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.Service
import android.content.Intent
import android.os.Build
import android.os.IBinder
import androidx.core.app.NotificationCompat
import com.example.toy.R

class MyForegroundService : Service(){

    companion object{
        const val CHANNEL_ID = "ForegroundServiceChannel"
    }

    override fun onCreate() {
        super.onCreate()
        createNotificationChannel()
        val notification : Notification = NotificationCompat.Builder(this, CHANNEL_ID)
            .setContentTitle("포그라운드 서비스 실행 중")
            .setContentText("서비스가 백그라운드에서 실행 중입니다.")
            .setSmallIcon(R.drawable.ic_launcher_foreground)
            .build()

        startForeground(1, notification)
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        // 서비스가 시작될 때 수행할 작업을 여기에 작성합니다.
        // 예: 음악 재생, 위치 추적 등

        // 서비스가 강제 종료되었을 때 다시 시작하도록 설정
        return START_STICKY
    }

    override fun onDestroy() {
        super.onDestroy()
        // 서비스가 종료될 때 정리 작업을 여기에 작성합니다.
    }

    override fun onBind(intent: Intent?): IBinder? {
        // 바인딩을 사용하지 않으므로 null 반환
        return null
    }

    private fun createNotificationChannel() {
        val serviceChannel = NotificationChannel(
            CHANNEL_ID,
            "포그라운드 서비스 채널",
            NotificationManager.IMPORTANCE_DEFAULT
        )
        val manager = getSystemService(NotificationManager::class.java)
        manager.createNotificationChannel(serviceChannel)
    }
}
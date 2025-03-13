package com.example.toy.coroutine

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    val startTime = System.currentTimeMillis()
    val job = launch(Dispatchers.Default) {
        repeat(10) { i ->
            delay(1000) // 네트워크 요청 대기
            println("${getElapsedTimeStart(startTime)} 데이터 다운 ${i*10}%")

        }
    }

    delay(2000) // 2초 후 사용자가 취소
    job.cancel()
    println("취소한 후에 해야할 작업들")
}
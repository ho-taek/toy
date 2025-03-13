package com.example.toy.coroutine

import kotlinx.coroutines.CoroutineStart
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking<Unit> {
    val startTime = System.currentTimeMillis()
    val lazyJob : Job = launch(start = CoroutineStart.LAZY) {
        println("${getElapsedTimeStart(startTime)} 지연 실행")
    }
    delay(1000L) //1초 대기
    lazyJob.start()
}

fun getElapsedTimeStart(startTime : Long) : String {
    return "시간 변화 ${System.currentTimeMillis() - startTime}ms"
}
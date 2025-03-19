package com.example.toy.coroutine

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.cancelAndJoin
import kotlinx.coroutines.delay
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.yield

fun main() = runBlocking {
        val jobs = launch(Dispatchers.Default) {
            var i = 0
            while (this.isActive) {
                println("실행중 ${i++}")
            }
        }
        delay(1000)
        println("취소 시도")
        jobs.cancel()
        println("취소 완료")
}
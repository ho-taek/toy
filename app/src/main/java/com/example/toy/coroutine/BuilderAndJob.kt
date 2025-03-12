package com.example.toy.coroutine

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {

    val getTokenJob = launch(Dispatchers.IO) {
        println("${Thread.currentThread().name} 로그인 클릭")
        delay(100L)
        println("${Thread.currentThread().name} 토큰 저장")
    }

    val independentJob = launch(Dispatchers.IO) {
        println("${Thread.currentThread().name} 독립적인 작업")
    }
    getTokenJob.join()

    val successLogin = launch(Dispatchers.IO) {
        println("${Thread.currentThread().name} 로그인 성공")
    }
}
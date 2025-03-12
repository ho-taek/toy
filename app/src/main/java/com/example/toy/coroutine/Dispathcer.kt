package com.example.toy.coroutine

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking


fun main() = runBlocking<Unit> {
    launch(Dispatchers.Default) {
        println("[${Thread.currentThread().name} 코루틴 실행")
    }
}
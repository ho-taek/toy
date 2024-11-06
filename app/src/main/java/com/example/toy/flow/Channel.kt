package com.example.toy.flow


import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

@OptIn(ExperimentalCoroutinesApi::class)
fun main() = runBlocking {
    val channel = Channel<Int>(Channel.CONFLATED)
    // 생산자 코루틴
    launch {

        for (x in 1..5) {
            delay(20)
            println("생산자 : $x")
            channel.send(x) // 소비자가 준비될 때까지 대기
        }

    }
    // 소비자 코루틴
    launch {
        for (y in 1..5) {
            delay(100)
            val receive = channel.receive()
            println("소비자 : $receive")
        }
    }

    return@runBlocking
}
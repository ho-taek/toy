package com.example.toy.flow


import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    val channel = Channel<Int>()

    // 데이터를 생산하는 코루틴
    launch {
        for (x in 1..5) {
            channel.send(x)
            println("Sent: $x")
        }
        channel.close() // 채널 닫기
    }

    // 데이터를 소비하는 코루틴
        for(i in channel){
            println("Received1 $i")
        }


        for(i in channel){
            println("Received2 $i")
        }



    return@runBlocking
}
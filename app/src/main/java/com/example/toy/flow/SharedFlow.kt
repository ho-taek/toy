package com.example.toy.flow

import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    val sharedFlow = MutableSharedFlow<Int>(0)



    // 여러 구독자가 SharedFlow를 구독
    launch {
        sharedFlow.collect { value ->
            println("Subscriber 1 received: $value")
        }
    }

    launch {
        sharedFlow.collect { value ->
            println("Subscriber 2 received: $value")
        }
    }

    // SharedFlow에 데이터 발행
    launch {
        for (i in 1..5) {
            sharedFlow.emit(i)
            println("Emitted: $i")
        }
    }

    return@runBlocking
}
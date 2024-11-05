package com.example.toy.flow

import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking

import kotlinx.coroutines.flow.*

fun simpleFlow(): Flow<Int> = flow {
    for (i in 1..5) {
        emit(i) // 값을 하나씩 방출
    }
}

fun main() = runBlocking {
    simpleFlow().collect { value ->
        println("첫 번째 $value")
    }

    simpleFlow().collect { value ->
        println("두 번째 $value")
    }
}

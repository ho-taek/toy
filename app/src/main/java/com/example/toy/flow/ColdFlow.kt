package com.example.toy.flow

import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking


fun main() = runBlocking {
    val flow = flow {
        (0..9).forEach {
            emit(it)
        }
    }
    flow.collect {
        println("첫 번째 $it")
    }

    flow.collect {
        println("두 번째 $it")
    }
}

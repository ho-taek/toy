package com.example.toy.coroutine

import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.Dispatchers

import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext

fun main() = runBlocking {
    val result1 = withContext(Dispatchers.IO){
        delay(1000)
        return@withContext "complete task1"
    }
    val result2 = withContext(Dispatchers.IO){
        return@withContext "complete task2"
    }

    println(result1)
    println(result2)

}


package com.example.toy.coroutine

import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.supervisorScope

fun main() = runBlocking {
    // given
    val actual: StringBuilder = StringBuilder()

    // when
    val job = launch {
        try {
            launch {
                delay(150)
                actual.append(1)
            }
            supervisorScope {
                val deferred = async {
                    delay(100)
                    throw RuntimeException("E2")
                }
                launch {
                    delay(200)
                    throw RuntimeException("E3")
                }
                deferred.await()
            }
        } catch (e: Exception) {
            actual.append(e.message)
        }
    }
    job.join()

    println(actual)
}
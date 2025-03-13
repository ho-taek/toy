package com.example.toy.coroutine

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.joinAll
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {

    val convertImageJob1 : Job = launch(Dispatchers.Default) {
        Thread.sleep(1000L)
        println("${Thread.currentThread().name} 이미지 변환 1")
    }

    val convertImageJob2 : Job = launch(Dispatchers.Default) {
        Thread.sleep(1000L)
        println("${Thread.currentThread().name} 이미지 변환 2")
    }

    joinAll(convertImageJob1, convertImageJob2)

    val uploadImageJob = launch(Dispatchers.IO) {
        println("${Thread.currentThread().name} 이미지 1,2 업로드")
    }
}
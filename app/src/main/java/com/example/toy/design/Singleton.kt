package com.example.toy.design

object fruite{
    init{
        println("fruite 초기화")
    }

    fun doSomething(){
        println("배고프다")
    }
}

fun main(){
    println("fruite 초기화 전")
    fruite.doSomething()
}
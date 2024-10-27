package com.example.toy.solid

interface Worker{
    fun work()
    fun eat()
}

class HumanWorker : Worker{
    override fun work() {
        println("사람이 일한다.")
    }

    override fun eat() {
        println("사람이 먹는다.")
    }
}

class RobotWorker : Worker{
    override fun work() {
        println("로봇이 일한다.")
    }

    override fun eat() {
        throw UnsupportedOperationException("로봇은 먹지 않는다.")
    }
}
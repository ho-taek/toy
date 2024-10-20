package com.example.toy.solid

// 직사각형 클래스
open class Rectangle {
    var width: Int = 0
    var height: Int = 0

    open fun changeWidth(width: Int) {
        this.width = width
    }

    open fun changeHeight(height: Int) {
        this.height = height
    }

    fun getArea(): Int {
        return width * height
    }
}

// 정사각형 클래스
class Square : Rectangle() {
    // 가로와 세로가 같아야 하기 때문에 두 값을 동기화함
    override fun changeWidth(width: Int) {
        super.changeWidth(width)
        super.changeHeight(width)
    }

    override fun changeHeight(height: Int) {
        super.changeHeight(height)
        super.changeWidth(height)
    }
}

fun main() {
    val rectangle = Rectangle()
    rectangle.changeWidth(5)
    rectangle.changeHeight(10)
    println("직사각형 -> ${rectangle.getArea()}") // 출력: 직사각형 -> 50

    val square: Rectangle = Square()
    square.changeWidth(5)
    square.changeHeight(10) // 여기서 문제가 발생함. 정사각형은 가로 세로가 같아야 함.
    println("정사각형 -> ${square.getArea()}") // 잘못된 값 출력: 정사각형 -> 100
}

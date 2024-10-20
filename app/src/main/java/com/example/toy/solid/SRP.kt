package com.example.toy.solid

class OrderManager {
    fun processOrder(orderId: String, orderAmount: Double) { //주문 처리

        val discount = calculateDiscount(orderAmount)
        val finalAmount = orderAmount - discount
        println("계산값 : $$finalAmount")
    }

    fun calculateDiscount(orderAmount: Double): Double {
        // 할인 계산 로직 (10% 할인을 적용)
        return if (orderAmount > 100) {
            orderAmount * 0.1
        } else {
            0.0
        }
    }
}

fun main() {
    val orderManager = OrderManager()

    // 주문 처리
    orderManager.processOrder("ORD123", 200.0)
}

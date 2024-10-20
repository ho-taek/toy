package com.example.toy.solid

class PaymentProcessor(val type : String) {
    fun processPayment() {
        when (type) {
            "CreditCard" -> println("신용 카드 결제")
            "PayPal" -> println("페이팔 결제")
            "Naver" -> println("네이버 결제")
            "Kakao" -> println("카카오 결제")
            "Cash" -> println("현금 결제")
            else -> println("알 수 없는 결제")
        }
    }
}

fun main(){
    PaymentProcessor("CreditCard").processPayment()
    PaymentProcessor("PayPal").processPayment()
    PaymentProcessor("Naver").processPayment()
    PaymentProcessor("Kakao").processPayment()
    PaymentProcessor("Cash").processPayment()
}
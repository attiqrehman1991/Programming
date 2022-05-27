package com.test.programming.paypay

fun main() {
    val number = "50552"
    println(maxTwoDigitsValueConsistent(number));
}

fun maxTwoDigitsValueConsistent(number: String): Int {
    var max = 0
    for (i in 1 until number.length) {
        val current = (number[i - 1] - '0') * 10 + (number[i] - '0')
        if (current > max)
            max = current
    }
    return max
}

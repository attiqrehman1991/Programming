package com.test.programming

fun main() {
    val prices = intArrayOf(7, 1, 5, 3, 6, 4)
    println( bestTimeToBuyAndSellStock(prices) )
}

fun bestTimeToBuyAndSellStock(prices: IntArray): Int {
    var min = Int.MAX_VALUE
    var profit = 0

    for(price in prices) {
        if(price < min) {
            min = price
        } else {
            profit = Math.max(profit, price - min)
        }
    }
    return profit
}
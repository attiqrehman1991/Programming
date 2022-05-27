package com.test.programming.faang

import java.util.*

fun main() {
    val array = intArrayOf(1, 2, 5)
    println(coinChange(array, 11))
}

fun coinChange(coins: IntArray, amount: Int) : Int {
    if(amount == 0 || coins.isEmpty()) return -1
    val dp = IntArray(amount + 1)
    Arrays.fill(dp, amount + 1)

    dp[0] = 0
    for (i in 0..amount) {
        for (c in coins.indices) {
            if (i >= coins[c]) {
                dp[i] = Math.min(dp[i], 1 + dp[i - coins[c]])
            }
        }
    }
    if(dp[amount] > amount) return -1
    return dp[amount]
}
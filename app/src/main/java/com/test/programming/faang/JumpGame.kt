package com.test.programming.faang

fun main() {
    println( jumpGame( intArrayOf(2, 3, 1, 1, 4) ) )
    println( jumpGame( intArrayOf(3, 2, 1, 0, 4) ) )
}

fun jumpGame(nums: IntArray): Boolean {
    var lastGoodIndex = nums.size - 1
    for (i in nums.indices.reversed()) {
        if (i + nums[i] >= lastGoodIndex) lastGoodIndex = i
    }
    return lastGoodIndex == 0
}
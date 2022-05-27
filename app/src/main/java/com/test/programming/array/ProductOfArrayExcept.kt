package com.test.programming.array

import java.util.*

fun main() {
    val input = intArrayOf(1, 2, 3, 4)
    val output: IntArray = productExceptSelf(input)

    for (i in output.indices) {
        println(output[i])
    }
}

fun productExceptSelf(nums: IntArray): IntArray {
    if(nums.isEmpty()) return intArrayOf(0)
    val ouput = IntArray(nums.size)
    Arrays.fill(ouput, 1)

    var prefix = 1
    for(i in nums.indices) {
        ouput[i] = prefix
        prefix *= nums[i]
    }

    var postfix = 1
    for(i in nums.size-1 downTo 0) {
        ouput[i] *= postfix
        postfix *= nums[i]
    }
    return ouput
}

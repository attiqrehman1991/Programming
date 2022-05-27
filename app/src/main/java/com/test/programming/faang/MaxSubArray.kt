package com.test.programming.faang

fun main() {
    val nums = intArrayOf(5,4,-1,7,8)
    println( maxSubArray(nums) )
}

fun maxSubArray(nums: IntArray): Int {
    var max = nums[0]
    var sum = 0

    nums.forEach {

        sum += it
        if(sum > max) {
            max = sum
        }
        if (sum < 0) sum = 0
    }
    return max
}
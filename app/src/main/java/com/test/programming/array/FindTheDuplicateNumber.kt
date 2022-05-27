package com.test.programming.array

fun main() {
    val nums = intArrayOf(1,3,4,2,2)
//    val nums = intArrayOf(2, 1, 3, 5, 3, 2)
    println( findDuplicate(nums) )
}

fun findDuplicate(nums: IntArray): Int {
    if(nums.isEmpty()) return 0

    for((index, value) in nums.withIndex()) {
        val va = nums[Math.abs(value)]
        if(va == -1) {
            return value
        } else {
            nums[Math.abs(value)] *=-1
        }
    }
    return -1
}
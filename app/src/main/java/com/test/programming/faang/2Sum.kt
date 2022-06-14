package com.test.programming.faang

import java.util.*

fun main() {
    /**
     *      2 D array
     *      sorting then with two pointers
     *      hashMap
     */

    val ouput = twoSum(intArrayOf(3, 2, 4), 6)
//    val ouput = twoSum(intArrayOf(2,7,11,15), 9)
    println(Arrays.toString(ouput))
}

fun twoSum(nums: IntArray, target: Int): IntArray {
    if (nums.size < 2) return intArrayOf()
    val map = HashMap<Int, Int>()

    for ((index, value) in nums.withIndex()) {
        if (map.containsKey(target - value)) {
            return intArrayOf(map[target - value]!!, index)
        } else {
            map[value] = index
        }
    }
    return intArrayOf()
}
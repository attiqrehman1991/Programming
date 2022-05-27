package com.test.programming.faang

import java.lang.IllegalArgumentException

fun main() {

    val (a, b) = twoSum(arrayOf(2, 7, 11, 15), 9)
    println("$a and $b")

    val (a2, b2) = twoSum(arrayOf(3, 2, 4), 6)
    println("$a2 and $b2")

    val (a3, b3) = twoSum1(arrayOf(3, 3), 6)
    println("$a3 and $b3")


    val array = twoSum(arrayOf(2, 15, 7, 11), 9)
    println(array.contentToString())
}


fun twoSum1(nums: Array<Int>, target: Int): Pair<Int, Int> {
    val hashMap = HashMap<Int, Int>()
    for (i in nums.indices) {
        if (hashMap.containsKey(nums[i])) {
            return Pair(i, hashMap.get(nums[i])!!)
        } else
            hashMap[target - nums[i]] = i
    }
    return Pair(0, 0)
}


fun twoSum(nums: Array<Int>, target: Int): IntArray {
    val ehashMap = HashMap<Int, Int>()
    nums.forEachIndexed { idx, item ->
        val found = ehashMap[target - item]
        found?.let {
            return intArrayOf(found, idx)
        }
        ehashMap[item] = idx
    }
    throw IllegalArgumentException()
}
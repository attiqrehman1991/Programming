package com.test.programming.rakuten

import java.util.*

fun main() {
//    val nums = arrayOf(7, 7, 7, 7, 7, 7, 7)
    val nums = intArrayOf(2, 5, 9)
//    val nums = arrayOf(1, 2, 3, 4, 5)
    println( sumOfFloorPairsBruthForce(nums) )
    println( sumOfFlooredPairs(nums) )
}
fun sumOfFloorPairsBruthForce(nums: IntArray) : Int {
    var sum = 0
    nums.forEach { i ->
        nums.forEach { j ->
            sum += i/j
        }
    }
    return sum
}

fun sumOfFlooredPairs(nums: IntArray): Int {
    val mod: Long = 1000000007
    Arrays.sort(nums)
    val max = nums[nums.size - 1]
    val counts = IntArray(max + 1)
    val qnts = LongArray(max + 1)
    for (k in nums) counts[k]++
    for (i in 1 until max + 1) {
        if (counts[i] == 0) continue
        var j = i
        while (j <= max) {
            qnts[j] = qnts[j] +  counts[i]
            j += i
        }
    }
    for (i in 1 until max + 1) qnts[i] = (qnts[i] + qnts[i - 1]) % mod
    var sum: Long = 0
    for (k in nums)
        sum = (sum + qnts[k]) % mod
    return sum.toInt()
}
//
//fun sumOfFloorPairs(nums:Array<Int>) : Int {
//    val max = nums.maxOrNull() ?: 0
//
//    val dp = IntArray( max + 1)
//    val counts = IntArray( max + 1)
//    for(i in counts.indices)
//        counts[i] = i
//    for (i in 1..max+1) {
//        if(counts[i] == 0)
//            continue
//        var j = i
//        while (j <= max) {
//            dp[j] +=counts[i]
//            j += 1
//        }
//    }
//    val mod = 1000000007
//    for(i in 1..max+ 1) {
//        dp[i] = (dp[i] + dp[i-1]) % mod
//    }
//    var sum = 0
//    for(k in nums.indices) {
//        sum = (sum + dp[k]) % mod
//    }
//    return sum
//}
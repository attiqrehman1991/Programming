package com.test.programming.array

import java.util.*

fun main() {
    val array = intArrayOf(34, 23, 1, 24, 75, 33, 54, 8)
    println(twoSumLessThanK(array, 60))
}

fun twoSumLessThanK(A: IntArray, K: Int): Int {
    Arrays.sort(A)
    var i = 0
    var j = A.size - 1
    var ans = -1
    while (i < j) {
        if (A[i] + A[j] >= K) {
            j--
        } else {
            ans = Math.max(ans, A[i] + A[j])
            i++
        }
    }
    return ans
}
package com.test.programming.rakuten

fun main() {
    val A = intArrayOf(-1, 1, 3, 3, 3, 2, 3, 2, 1, 0)
    println(stableVelocity(A))

    val B = intArrayOf(7, 7, 7, 7)
    println(stableVelocity(B))
}

fun stableVelocity(A: IntArray): Int {
    var totalPeriods = 0
    val size = A.size

    var count = 1
    var diff = A[0] - A[1]
    for (j in 2 until size) {
        val newDiff = A[j - 1] - A[j]
        if (newDiff == diff) {
            count++
        } else {
            if (count != 1) {
                totalPeriods++
            }
            count = 1
            diff = newDiff
        }
    }
    if (count != 1) {
        totalPeriods++
    }
    return totalPeriods
}
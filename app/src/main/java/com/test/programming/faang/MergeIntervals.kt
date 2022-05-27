package com.test.programming.faang

import kotlin.math.max
import kotlin.math.min

fun main() {
    val intervals = arrayOf(
        intArrayOf(1, 3),
        intArrayOf(8, 10),
        intArrayOf(15, 18),
        intArrayOf(2, 6)
    )

    val output = merge(intervals)
    output.forEach {
        print("${it.contentToString()}   ")
    }
    println()

    val output2 = insert(intervals, intArrayOf(12, 14))
    output2.forEach {
        print("${it.contentToString()}   ")
    }

    val arr1 = arrayOf(
        intArrayOf(0, 4),
        intArrayOf(5, 10),
        intArrayOf(13, 20),
        intArrayOf(24, 25))
    val arr2 = arrayOf(
        intArrayOf(1, 5),
        intArrayOf(8, 12),
        intArrayOf(15, 24),
        intArrayOf(25, 26))

    printIntervals(arr1, arr2)
}

fun printIntervals(arr1: Array<IntArray>, arr2: Array<IntArray>) {
    var i = 0
    var j = 0
    val n = arr1.size
    val m = arr2.size

    println(" Print intervals ")

    while ( i <n && j < m) {
        val l = max(arr1[i][0], arr2[j][0])
        val r = min(arr1[i][1], arr2[j][1])

        if(l <= r) {
            println( "{ $l , $r }" )
        }
        if(arr1[i][1] < arr2[j][1])
            i++
        else
            j++
    }
}

fun merge(intervals: Array<IntArray>): Array<IntArray> {
    if (intervals.isEmpty()) return arrayOf()
    intervals.sortWith(compareBy { it[0] })

    val output = mutableListOf<IntArray>()

    for (interval in intervals) {
        if (output.isEmpty() || output.last()[1] < interval[0]) {
            output.add(interval)
        } else {
            output.last()[1] = Math.max(interval[1], output.last()[1])
        }
    }
    return output.toTypedArray()
}

fun insert(oldIntervals: Array<IntArray>, newInterval: IntArray): Array<IntArray> {
    val intervals = oldIntervals + newInterval

    intervals.sortWith(compareBy { it[0] })
    val output = mutableListOf<IntArray>()

    for (interval in intervals) {
        if (output.isEmpty() || output.last()[1] < interval[0]) {
            output.add(interval)
        } else {
            output.last()[1] = Math.max(output.last()[1], interval[1])
        }
    }
    return output.toTypedArray()
}

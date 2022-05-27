package com.test.programming.array

fun main() {
    // 2n

    // take square  then sort onlogn
    // 3rd using start and end parameter

    // 2n
    // take square  then sort onlogn
    // 3rd using start and end parameter
    val array = intArrayOf(-6, -5, 1, 2, 3, 5)
    val output = sortedSquareArray(array)
    for (i in array.indices) {
        println(output[i])
    }
}

private fun sortedSquareArray(array: IntArray): IntArray {
    val output = IntArray(array.size)
    var start = 0
    var end = array.size - 1
    for (i in array.indices.reversed()) {
        if (Math.abs(array[start]) > array[end]) {
            output[i] = array[start] * array[start]
            start++
        } else {
            output[i] = array[end] * array[end]
            end--
        }
    }
    return output
}
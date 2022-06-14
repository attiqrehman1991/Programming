package com.test.programming.array

import kotlin.math.abs

fun main() {

    // N(2) --> brute force
    // hashmap or set --> nlog(n)
    // if given inside the index
    val array = intArrayOf(2, 1, 3, 5, 3, 2)
    println(firstDuplicate(array))
}

fun firstDuplicate(array: IntArray): Int {
    for(i in array.indices) {
        var value = abs(array[i])
        value -= 1

        if(array[value] > 0)
            array[value] *= -1
        else
            return abs(array[value])
    }

    return -1
}
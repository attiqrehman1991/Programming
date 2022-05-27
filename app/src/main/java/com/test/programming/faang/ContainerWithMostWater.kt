package com.test.programming.faang

fun main() {
    val array = intArrayOf(1, 8, 6, 2, 5, 4, 8, 3, 7)

    println(containerWithMostWater(array))
    println(maxArea(array))
}

fun containerWithMostWater(array: IntArray): Int {
    var maxArea = 0
    if (array.isEmpty()) return maxArea

    maxArea = Int.MIN_VALUE
    var start = 0
    var end = array.size - 1

    while (start < end) {
        val min = Math.min(array[start], array[end])
        maxArea = Math.max(maxArea, min * (end - start))
        if (array[start] < array[end])
            start++
        else
            end--
    }
    return maxArea
}

fun maxArea(height: IntArray): Int {
    if(height.isEmpty()) return 0

    var maxArea = 0
    var start = 0
    var end = height.size - 1

    while ( start < end) {
        val min = Math.min( height[start] , height[end] )
        maxArea = Math.max ( maxArea, min * (end - start) )

        if(height[start] < height[end])
            start++
        else
            end--

    }
    return maxArea

}
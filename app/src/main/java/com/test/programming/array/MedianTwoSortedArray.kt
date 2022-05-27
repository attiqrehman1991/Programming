package com.test.programming.array

fun main() {
    val array1 = intArrayOf(1, 3, 8, 9, 15)
    val array2 = intArrayOf(7, 11, 18, 19, 21, 25)
    println(findMedian(array1, array2))
}

private fun findMedian(array1: IntArray, array2: IntArray): Double {
    if (array1.size > array2.size) {
        return findMedian(array2, array1)
    }
    val x = array1.size
    val y = array2.size
    var low = 0
    var high = x
    while (low <= high) {
        val partitionX = (low + high) / 2
        val partitionY = (x + y + 1) / 2 - partitionX
        val maxLeftX = if (partitionX == 0) Int.MIN_VALUE else array1[partitionX - 1]
        val minRightX = if (partitionX == x) Int.MAX_VALUE else array1[partitionX]
        val maxLeftY = if (partitionY == 0) Int.MIN_VALUE else array2[partitionY - 1]
        val minRightY = if (partitionY == y) Int.MAX_VALUE else array2[partitionY]
        if (maxLeftX <= minRightY && maxLeftY <= minRightX) {
            return if ((x + y) % 2 == 0) (Math.max(maxLeftX, maxLeftY) + Math.min(
                minRightX,
                minRightY
            )).toDouble() / 2 else Math.max(maxLeftY, maxLeftY)
                .toDouble()
        } else if (maxLeftX > minRightY) {
            high = partitionX - 1
        } else {
            low = partitionX + 1
        }
    }
    throw IllegalArgumentException()
}
package com.test.programming.amazon


fun main() {
    val array1 = intArrayOf(1, 2)
    val array2 = intArrayOf(3, 4)
    println(findMedianSortedArrays(array1, array2))
    println(medianOfTwoSortedArrays(array1, array2))
}

fun medianOfTwoSortedArrays(array1:IntArray, array2:IntArray) : Double {
    if(array1.size > array2.size)
        return medianOfTwoSortedArrays(array2, array1)

    val x = array1.size
    val y = array2.size

    var low = 0
    var high = x

    while ( low <= high ) {
        val partitionX = (low + high) / 2
        val partitionY = (x + y + 1) / 2 - partitionX

        val maxLeftX = if(partitionX == 0) Int.MIN_VALUE else array1[partitionX - 1]
        val minRightX = if (partitionX == x) Int.MAX_VALUE else array1[partitionX]

        val maxLeftY = if(partitionY == 0) Int.MIN_VALUE else array2[partitionY - 1]
        val minRightY = if (partitionY == y) Int.MAX_VALUE else array2[partitionY]

        if(maxLeftX <= minRightY && maxLeftY <= minRightX) {
            return if ((x + y) % 2==0) (Math.max(maxLeftX, maxLeftY) + Math.min(minRightX , minRightY)).toDouble()/2
            else Math.max(maxLeftX, maxLeftY).toDouble()
        } else if (maxLeftX > minRightY) {
            high = partitionX - 1
        } else {
            low = partitionX + 1
        }
    }
    throw  IllegalArgumentException()
}

private fun findMedianSortedArrays(nums1: IntArray, nums2: IntArray): Double {
    if(nums1.size > nums2.size) {
        return findMedianSortedArrays(nums2, nums1)
    }

    val x = nums1.size
    val y = nums2.size

    var low = 0
    var high = nums1.size

    while(low <= high) {

        val partitionX = (low + high + 1)/ 2
        val partitionY = (x + y + 1)/ 2 - partitionX

        val maxLeftX = if(partitionX == 0) Int.MIN_VALUE else nums1[partitionX-1]
        val minRightX = if (partitionX == x) Int.MAX_VALUE else nums1[partitionX]

        val maxLeftY = if(partitionY == 0) Int.MIN_VALUE else nums2[partitionY-1]
        val minRightY = if(partitionY == y) Int.MAX_VALUE else nums2[partitionY]

        if(maxLeftX <= minRightY && maxLeftY <= minRightX) {
            if((x + y)%2 == 0) {
                return Math.max(maxLeftX, maxLeftY) + Math.min(minRightX, minRightY).toDouble()/2
            } else {
                return Math.max(maxLeftX, maxLeftY).toDouble()
            }
        } else if (maxLeftX > minRightY) {
            high = partitionX - 1
        } else {
            low = partitionX + 1
        }
    }
    return 0.0
}
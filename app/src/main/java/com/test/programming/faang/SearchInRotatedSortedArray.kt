package com.test.programming.faang

fun main() {
    val nums = arrayOf(4,5,6,7,0,1,2)
    val target = 0
    println(searchInRotatedSortedArray(nums, target))
}

fun searchInRotatedSortedArray(nums: Array<Int>?, target: Int) : Int {
    if(nums==null || nums.isEmpty()) return -1
    var left = 0
    var right = nums.size - 1

    while ( left < right) {
        val mid = left + ( right - left ) /2
        if(nums[mid] > nums[right]) {
            left = mid + 1
        } else
            right = mid
    }
    // now junction is left
    val start = left
    left = 0
    right = nums.size - 1

    if( target >= nums[start] && target <= nums[right]) {
        left = start
    } else
        right = start

    while (left <= right) {
        val mid = left + (right - left) / 2
        if(nums[mid] == target)
            return mid
        else if (target > nums[mid])
            left = mid + 1
        else
            right = mid - 1
    }
    return -1
}
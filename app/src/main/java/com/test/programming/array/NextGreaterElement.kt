package com.test.programming.array

import android.annotation.SuppressLint
import java.util.*

fun main() {
    val nums1 = intArrayOf(4, 1, 2)
    val nums2 = intArrayOf(1, 3, 4, 2)

    val expected = intArrayOf(-1, 3, -1)
    val actual: IntArray = nextGreaterElement(nums1, nums2)

    for (i in actual.indices) {
        println(actual[i].toString() + " ")
    }

    println(expected.contentToString())
    println(Arrays.toString(actual))
}

@SuppressLint("NewApi")
private fun nextGreaterElement(nums1: IntArray, nums2: IntArray): IntArray {
    if (nums2.isEmpty() || nums1.isEmpty()) {
        return IntArray(0)
    }
    val numberNGE: MutableMap<Int, Int> = HashMap()
    val numStack: Stack<Int> = Stack()
    numStack.push(nums2[nums2.size - 1])
    numberNGE[nums2[nums2.size - 1]] = -1
    for (i in nums2.size - 2 downTo 0) {
        if (nums2[i] < numStack.peek()) {
            numberNGE[nums2[i]] = numStack.peek()
            numStack.push(nums2[i])
            continue
        }
        while (!numStack.isEmpty() && numStack.peek() < nums2[i]) {
            numStack.pop()
        }
        if (numStack.isEmpty()) {
            numberNGE[nums2[i]] = -1
            numStack.push(nums2[i])
        } else {
            numberNGE[nums2[i]] = numStack.peek()
            numStack.push(nums2[i])
        }
    }
    for (i in nums1.indices) {
        nums1[i] = numberNGE.getOrDefault(nums1[i], -1)
    }
    return nums1
}
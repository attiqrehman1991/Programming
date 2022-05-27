package com.test.programming.array

import android.annotation.SuppressLint
import java.util.*

fun main() {
    val output = findTopKFrequentNumbers(intArrayOf(1, 1, 1, 2, 2, 3, 3, 4, 4), 3)
    for (out in output) {
        println(out)
    }
}

@SuppressLint("NewApi")
fun findTopKFrequentNumbers(nums: IntArray, k: Int): IntArray {
    if (nums.isEmpty()) {
        return IntArray(0)
    }
    // find the frequency of each number
    val numFrequencyMap: MutableMap<Int, Int> = HashMap()
    for (n in nums) {
        numFrequencyMap[n] = numFrequencyMap.getOrDefault(n, 0) + 1
    }

//        Queue<Integer> minHeap = new PriorityQueue<>((a, b) -> numFrequencyMap.get(a) - numFrequencyMap.get(b));
    val minHeap: PriorityQueue<Map.Entry<Int, Int>> = PriorityQueue { e1, e2 ->
        e1.value - e2.value
    }

    // go through all numbers of map & push them in a minHeap which will have top k elements
    // If at any time it has > K elements, then remove the smallest element.
    for (entry in numFrequencyMap.entries) {
//        	System.out.println(entry.getKey() +" " + entry.getValue());
        minHeap.add(entry)
        if (minHeap.size > k) {
            minHeap.poll()
        }
    }

    // Let's create a list of top k elements
    val topNumbers = IntArray(minHeap.size)
    var index = 0
    while (!minHeap.isEmpty()) {
        topNumbers[index++] = minHeap.poll().key
    }
    return topNumbers
}
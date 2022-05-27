package com.test.programming.array

fun main() {
    val array = intArrayOf(100, 4, 200, 1, 3, 2)
    println(longestConsecutiveSequence(array))
}


fun longestConsecutiveSequence(nums: IntArray) : Int{
    if(nums.isEmpty()) return 0
    val setNums = HashSet<Int>()
    for(i in nums)
        setNums.add(i)
    var maxConsecutive = 0

    for(i in nums.indices) {
        var currentNum = nums[i]
        var currentSequenceLength = 1
        if(!setNums.contains(currentNum - 1)) {
            while (setNums.contains(currentNum + 1)) {
                currentNum += 1
                currentSequenceLength +=1
            }
        }
        maxConsecutive = Math.max(maxConsecutive, currentSequenceLength)
    }
    return maxConsecutive
}
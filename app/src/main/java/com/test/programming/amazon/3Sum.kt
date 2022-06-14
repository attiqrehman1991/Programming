package com.test.programming.amazon

fun main() {
    val array = intArrayOf(1, -1, -1, 0)
    val ouput = threeSumA(array)
    println(ouput.joinToString(" "))
}

fun threeSumA(array: IntArray): MutableList<List<Int>> {
    val output = mutableListOf<List<Int>>()
    if (array.isEmpty() || array.size < 3) return output
    array.sort()

    for (i in array.indices) {
        val first = array[i]
        var l = i + 1
        var r = array.size - 1

        while (l < r && (i == 0 || (i > 0 && array[i - 1] != array[i]))) {
            val threeSum = first + array[l] + array[r]
            when {
                threeSum == 0 -> {
                    val innerList = listOf(first, array[l], array[r])
                    output.add(innerList)

                    while (l < r && array[l] == array[l + 1]) {
                        l += 1
                    }
                    while (l < r && array[r] == array[r - 1]) {
                        r -= 1
                    }
                    l += 1
                    r -= 1
                }
                threeSum > 0 -> {
                    r -= 1
                }
                else -> {
                    l += 1
                }
            }
        }
    }
    return output
}
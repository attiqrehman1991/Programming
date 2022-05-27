package com.test.programming.faang

fun main() {
//    val array = intArrayOf(-1,0,1,2,-1,-4)
//    val array = intArrayOf(0, 0, 0, 0)
    val array = intArrayOf(1, -1, -1, 0)
//    val array = intArrayOf(0)
//    val array = intArrayOf(-1,0,1,2,-1,-4)
    val list: List<List<Int>> = threeSum(array)
    println(list.joinToString(" "))


//    val list2:List<List<Int>> = threeSum2(array)
//    println( list2.joinToString(" ") )
}

fun threeSum(array: IntArray): MutableList<List<Int>> {
    val output: MutableList<List<Int>> = mutableListOf()
    if (array.isEmpty() || array.size < 3) {
        return output
    }
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
//                    output.map {
//                        it.toMutableList().addAll(innerList)
//                    }
//                    output.toMutableList().add(innerList)
                    output.add(innerList)

                    while (l < r && array[l] == array[l + 1]) {
                        l += 1
                    }
                    while (l < r && array[r] == array[r - 1]) {
                        r += 1
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
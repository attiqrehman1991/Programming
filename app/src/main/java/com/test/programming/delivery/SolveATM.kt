package com.test.programming.delivery

import java.util.*
import java.util.function.Consumer

private var i = 0

fun main() {
    val reminderVsIndex: HashMap<Int, MutableSet<Int>> = HashMap()
    val arr = intArrayOf(1, 1, 2, 23, 4, 9, 13, 6, 9)
    val k = 10
    val result: MutableList<List<Int>> = ArrayList()
    Arrays.stream(arr).forEach { s ->
        if (reminderVsIndex.containsKey(s)) {
            val indices: Set<Int> = reminderVsIndex[s]!!
            indices.stream().forEach { m: Int ->
                val indexPairs: MutableList<Int> = ArrayList()
                indexPairs.add(m)
                indexPairs.add(i)
                result.add(indexPairs)
            }
        } else {
            val rem: Int = k - s
            val ind =
                reminderVsIndex.getOrDefault(rem, HashSet())
            ind.add(i)
            reminderVsIndex[rem] = ind
        }
        i++
    }
    result.forEach(Consumer { m: List<Int> ->
        println(
            m.toString()
        )
    })
}
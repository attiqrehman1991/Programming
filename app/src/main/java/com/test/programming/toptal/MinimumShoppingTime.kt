package com.test.programming.toptal

import java.util.*

fun main() {
    var A = arrayOf(
        intArrayOf(0, 7),
        intArrayOf(1, 3),
        intArrayOf(1, 4)
    )
    println( minimumShoppingTime(A) )

    A = arrayOf(
        intArrayOf(0, 2),
        intArrayOf(0, 5),
        intArrayOf(1, 3),
        intArrayOf(2, 2)
    )
    println( minimumShoppingTime(A) )

}

fun minimumShoppingTime(times: Array<IntArray>): Int {
    Arrays.sort(times) { a, b -> a.get(0) - b.get(0) } // sort by time
    val q: PriorityQueue<Int> =
        PriorityQueue(3) // 3 cashiers and we need always the one which is least busy
    q.add(0)
    q.add(0)
    q.add(0)
    for (t in times) {
        var top: Int = q.poll()
        top = top + t[1] // add new customer to least busy cashier
        q.add(top)
    }
    q.poll() // we need the most busy one
    q.poll() // we need the most busy one
    return q.poll() //this one is most busy
}
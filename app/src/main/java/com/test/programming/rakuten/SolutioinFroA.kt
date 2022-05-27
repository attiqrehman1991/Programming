package com.test.programming.rakuten

fun main() {
    val idx = 6

    val sequence = mutableListOf<Int>()
    sequence.add(1)
    var pow2Idx = 0
    var pow3Idx = 0
    while (sequence.size < idx + 1) {
        val pow2Next = 2 * sequence[pow2Idx]
        val pow3Next = 3 * sequence[pow3Idx]
        sequence.add(Math.min(pow2Next, pow3Next))
        pow2Idx = pow2Idx+ if (pow2Next <= pow3Next) 1 else 0
        pow3Idx = pow3Idx +if (pow2Next >= pow3Next) 1 else 0
    }
    println( sequence[idx] )
}

fun solutionFroA() {
}
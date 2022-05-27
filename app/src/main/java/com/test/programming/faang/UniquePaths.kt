package com.test.programming.faang

fun main() {
    println( uniquePaths(3, 7) )
}

fun uniquePaths(m: Int, n: Int): Int {
    val matrix = Array(m) { IntArray(n) }

    for(indexR in 0 until m) {
        matrix[indexR][n-1] = 1
    }

    for(indexC in 0 until n-1) {
        matrix[m-1][indexC] = 1
    }

    for(indexR in m-2 downTo 0) {
        for(indexC in n-2 downTo 0) {
            matrix[indexR][indexC] = matrix[indexR + 1][indexC] + matrix[indexR][indexC + 1]
        }
    }

    return matrix[0][0]
}
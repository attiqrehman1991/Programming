package com.test.programming.faang

fun main() {

    var matrix = arrayOf(
        intArrayOf(1, 2, 3),
        intArrayOf(4, 5, 6),
        intArrayOf(7, 8, 9),
    )

    printMatrix(matrix)
    matrix = rotate(matrix)
    printMatrix(matrix)

}

fun printMatrix(matrix: Array<IntArray>) {
    for (ma in matrix.indices) {
        for (ma1 in matrix[0].indices) {
            print(matrix[ma][ma1])
        }
        println()
    }
}


fun rotate(matrix: Array<IntArray>): Array<IntArray> {
    if (matrix.isEmpty()) return matrix

    val N = matrix.size
    for (i in 0 until N) {
        for (j in i until N) {
            val temp = matrix[i][j]
            matrix[i][j] = matrix[j][i]
            matrix[j][i] = temp
        }
    }

    for (i in matrix.indices) {
        for (j in 0 until N / 2) {
            val temp = matrix[i][j]
            matrix[i][j] = matrix[i][N - 1 - j]
            matrix[i][N - 1 - j] = temp
        }
    }
    return matrix
}
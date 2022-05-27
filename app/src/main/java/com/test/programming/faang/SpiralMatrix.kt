package com.test.programming.faang

fun main() {
    val matrix = arrayOf(
        intArrayOf(1, 2, 3, 4),
        intArrayOf(5, 6, 7, 8),
        intArrayOf(9, 10, 11, 12)
    )
    val output = spiralOrder(matrix)
    println(output.toString())
}

fun spiralOrder(matrix: Array<IntArray>): List<Int> {
    val list = mutableListOf<Int>()
    if (matrix.isEmpty()) {
        return list
    }

    var left = 0
    var right = matrix[0].size
    var top = 0
    var bottom = matrix.size

    while (left < right && top < bottom) {
        // get every i in the top row
        for (i in left until right) {
            list.add(matrix[top][i])
        }
        top += 1
        // get every i in the right col
        for (i in top until bottom) {
            list.add(matrix[i][right - 1])
        }
        right -= 1

        if (left >= right || top >= bottom)
            break

        // for bottom row
        for (i in right - 1 downTo left) {
            list.add(matrix[bottom - 1][i])
        }
        bottom -= 1

        // for left row
        for (i in bottom - 1 downTo top) {
            list.add(matrix[i][left])
        }
        left += 1
    }
    return list
}
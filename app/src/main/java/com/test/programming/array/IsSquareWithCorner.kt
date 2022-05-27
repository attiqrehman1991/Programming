package com.test.programming.array

fun main() {
    val mat = arrayOf(
        intArrayOf(1, 0, 0, 1, 0),
        intArrayOf(0, 0, 1, 0, 1),
        intArrayOf(0, 0, 0, 1, 0),
        intArrayOf(1, 0, 1, 0, 1)
    )

    if (isRectablge(mat)) println("Yes") else println("No")
}

private fun isRectablge(mat: Array<IntArray>): Boolean {
    // TODO Auto-generated method stub
    val rows = mat.size
    if (rows == 0) return false
    val col: Int = mat[0].size
    for (y1 in 0 until rows) {
        for (x1 in 0 until col) {
            if (mat[y1][x1] == 1) {
                for (y2 in y1 + 1 until rows) {
                    for (x2 in x1 + 1 until col) {
                        if (mat[y1][x2] == 1 && mat[y2][x1] == 1 && mat[y2][x2] == 1) {
                            return true
                        }
                    }
                }
            }
        }
    }
    return false
}
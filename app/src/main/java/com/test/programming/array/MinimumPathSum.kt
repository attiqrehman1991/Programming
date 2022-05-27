package com.test.programming.array

fun main() {
    val array = arrayOf(intArrayOf(1, 3, 1), intArrayOf(1, 5, 1), intArrayOf(4, 2, 1))
    println(minPathSum(array))
}

fun minPathSum(grid: Array<IntArray>): Int {
    val dp = Array(grid.size) {
        IntArray(
            grid[0].size
        )
    }
//    Arrays.stream(dp).forEach { a -> Arrays.fill(a, 0) }
    for (r in grid.indices) {
        for (c in 0 until grid[0].size) {
            dp[r][c] = grid[r][c]
            if (r > 0 && c > 0) {
                dp[r][c] += Math.min(dp[r][c - 1], dp[r - 1][c])
            } else if (c > 0) {
                dp[r][c] += dp[r][c - 1]
            } else if (r > 0) {
                dp[r][c] += dp[r - 1][c]
            }
        }
    }
    return dp[dp.size - 1][dp[0].size - 1]
}
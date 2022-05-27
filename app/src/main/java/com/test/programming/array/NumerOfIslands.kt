package com.test.programming.array

fun main() {
    val array2 = arrayOf(
        charArrayOf('1', '1', '0', '0', '0'),
        charArrayOf('1', '1', '0', '0', '0'),
        charArrayOf('0', '0', '1', '0', '0'),
        charArrayOf('0', '0', '0', '1', '1')
    )
    println(numIslands(array2))
}

fun numIslands(grid: Array<CharArray>) : Int{
    if(grid.isEmpty()) return  0
    var numOfIslands = 0
    for(i in grid.indices) {
        for(j in grid[0].indices) {
            if(grid[i][j] == '1')
                numOfIslands += dfs(grid, i, j)
        }
    }
    return numOfIslands
}

fun dfs(grid: Array<CharArray>, i:Int, j:Int) : Int{
    if(i < 0 || j< 0 || i>=grid.size || j>=grid.size || grid[i][j] == '0') {
        return 0
    }
    grid[i][j] = '0'
    dfs(grid, i + 1, j)
    dfs(grid, i - 1, j)
    dfs(grid, i, j + 1)
    dfs(grid, i, j - 1)
    return 1
}
package com.test.programming.array

fun main() {
    val board = arrayOf(
        charArrayOf('5', '3', '.', '.', '7', '.', '.', '.', '.'),
        charArrayOf('6', '.', '.', '1', '9', '5', '.', '.', '.'),
        charArrayOf('.', '9', '8', '.', '.', '.', '.', '6', '.'),
        charArrayOf('8', '.', '.', '.', '6', '.', '.', '.', '3'),
        charArrayOf('4', '.', '.', '8', '.', '3', '.', '.', '1'),
        charArrayOf('7', '.', '.', '.', '2', '.', '.', '.', '6'),
        charArrayOf('.', '6', '.', '.', '.', '.', '2', '8', '.'),
        charArrayOf('.', '.', '.', '4', '1', '9', '.', '.', '5'),
        charArrayOf('.', '.', '.', '.', '8', '.', '.', '7', '9')
    )

    println(if (isValidConfig(board, 9)) "YES" else "NO")
}

private fun isValidConfig(board: Array<CharArray>, length: Int): Boolean {
    for (i in 0 until length) {
        for (j in 0 until length) {
            if (!isValid(board, i, j)) return false
        }
    }
    return true
}

private fun isValid(board: Array<CharArray>, row: Int, col: Int): Boolean {
    return (isRowValid(board, row) && isColValid(board, row) && isBoxValid(
        board,
        row - row % 3,
        col - col % 3
    ))
}

private fun isColValid(board: Array<CharArray>, col: Int): Boolean {
    val cols: HashSet<Char> = HashSet()
    for (i in 0..8) {
        if (cols.contains(board[i][col])) return false
        if (board[i][col] != '.') cols.add(board[i][col])
    }
    return true
}

private fun isRowValid(board: Array<CharArray>, row: Int): Boolean {
    val cols: HashSet<Char> = HashSet()
    for (i in 0..8) {
        if (cols.contains(board[row][i])) return false
        if (board[row][i] != '.') cols.add(board[row][i])
    }
    return true
}

private fun isBoxValid(board: Array<CharArray>, startRow: Int, startCol: Int): Boolean {
    val cols: HashSet<Char> = HashSet()
    for (i in 0..2) {
        for (j in 0..2) {
            val curr = board[i + startRow][j + startCol]
            if (cols.contains(curr)) return false
            if (curr != '.') cols.add(curr)
        }
    }
    return true
}
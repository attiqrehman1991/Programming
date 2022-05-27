package com.test.programming.faang

fun main() {
    val board = arrayOf(
        charArrayOf('A', 'B', 'C', 'E'),
        charArrayOf('S', 'F', 'C', 'S'),
        charArrayOf('A', 'D', 'E', 'E')
    )
    val word = "ABCCED"

    if (exist(board, word)) {
        println(" YES ")
    } else
        println(" Not ")
}

fun exist(board: Array<CharArray>, word: String): Boolean {
    val rows = board.size
    val cols = board[0].size

    for(r in 0 until rows) {
        for (c in 0 until cols) {

            if(board[r][c] == word[0] && dfs(board, r, c, 0, word)) {
                return true
            }

        }
    }
    return false
}

fun dfs(board:Array<CharArray>, r:Int, c:Int, count:Int, word:String) : Boolean {
    if(count == word.length) return true
    if(r >= board.size || c >= board[0].size || 0 > c || 0 > r || board[r][c] != word[count]) {
        return false
    }

    val temp = board[r][c]
    board[r][c] = ' '
    val found = dfs (board, r + 1, c, count + 1, word) ||
            dfs (board, r - 1, c, count + 1, word) ||
            dfs (board, r, c + 1, count + 1, word) ||
            dfs (board, r, c - 1, count + 1, word)
    board[r][c] = temp
    return found
}

//
//fun exist(board: Array<CharArray>, word: String): Boolean {
//    val rows = board.size
//    val cols = board[0].size
//
//    for (r in 0 until rows) {
//        for (c in 0 until cols) {
//
//            if (board[r][c] == word[0] && dfs(board, r, c, 0, word)) {
//                return true
//            }
//
//        }
//    }
//    return false
//}
//

package com.test.programming.toptal


fun main() {

//    Given a matrix.
//    For all empty (0) cells, find number of mines (X) in Moore region
//
//    Moore region - eight cells surrounding the cell
//    Return matrix with 0s replaced with number of mines
//
//    This needs to be implemented completely within 15 minutes.

//    [
//        {
//            input: ['XOO', 'OOO', 'XXO'],
//            output: ['X 1 0', '3 3 1', 'X X 1'],
//        },
//        {
//            input: [
//            'XOOXXXOO',
//            'OOOOXOXX',
//            'XXOXXOOO',
//            'OXOOOXXX',
//            'OOXXXXOX',
//            'XOXXXOXO',
//            'OOOXOXOX',
//            'XOXXOXOX',
//            ],
//            output: [
//            'X 1 1 X X X 3 2',
//            '3 3 3 5 X 5 X X',
//            'X X 3 X X 5 5 4',
//            '3 X 5 5 6 X X X',
//            '2 4 X X X X 6 X',
//            'X 3 X X X 5 X 3',
//            '2 4 5 X 6 X 5 X',
//            'X 2 X X 4 X 4 X',
//            ],
//        },
//    ]
}

fun minesweeper(matrix: Array<String>): List<List<Char>> {
    val resultMatrix =
        List(matrix.size) { MutableList(matrix[it].length) { Char.MIN_VALUE } }
    matrix.forEachIndexed { rowIndex, row ->
        row.forEachIndexed rowLoop@{ charIndex, char ->
            if (char == 'X') {
                resultMatrix[rowIndex][charIndex] = 'X'
                return@rowLoop
            }
            var counter = 0
            for (i in -1..1) {
                for (j in -1..1) {
                    val matrixValue =
                        matrix.getOrNull(rowIndex + i)?.getOrNull(charIndex + j)
                    if (matrixValue == 'X') counter++
                }
            }
            resultMatrix[rowIndex][charIndex] = counter.toString().first()
        }
    }
    return resultMatrix
}
package com.test.programming.array

fun main() {
    val array = arrayOf(intArrayOf(1, 0, 3), intArrayOf(0, 2, 1), intArrayOf(1, 2, 0))
    println(ghostRoomDiscarded(array))
}

fun ghostRoomDiscarded(array: Array<IntArray>) : Int{
    var cost = 0

    for(i in array.indices) {
        for(j in array[0].indices) {
            var isDiscord = true

            var k = i
            while (k > 0) {
                if( k> 0 && array[k - 1][j] == 0)
                    isDiscord = false
                k--
            }
            if(isDiscord && array[i][j] != 0)
                cost += array[i][j]
        }
    }
    return cost

}
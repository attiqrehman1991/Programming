package com.test.programming.array

fun main() {
    val internals = arrayOf(
        intArrayOf(1, 3),
        intArrayOf(8, 10),
        intArrayOf(7, 8),
        intArrayOf(9, 15),
        intArrayOf(2, 6)
    )
    println( meetingRooms(internals) )

}

fun meetingRooms(internals: Array<IntArray>) : Int {
    if(internals.isEmpty()) return 0

    val arrayA = IntArray(internals.size)
    val arrayB = IntArray(internals.size)

    for(index in internals.indices) {
        arrayA[index] = internals[index][0]
        arrayB[index] = internals[index][1]
    }
    arrayA.sort()
    arrayB.sort()

    var room =0
    var i = 0
    var j = 0

    while ( i < arrayA.size) {
        if( arrayA[i] < arrayB[j]) {
            room ++
            i++
        } else {
            i++
            j++
        }
    }

    return room
}
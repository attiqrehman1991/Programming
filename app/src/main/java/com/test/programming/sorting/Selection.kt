package sorting

// O(N2)
// repeatedly looking for small element and place it in the front
// maintain two sets of sub arrays (sorted and unsorted)
fun main() {
    val array = intArrayOf(64, 24, 12, 33, 32)
    println(array.toList())

    for (index in array.size - 1 downTo 0) {
        var max = index
        var temp: Int
        for (j in 0 until index)
            if (array[j] > array[max])
                max = j
        if (max != index) {
            temp = array[index]
            array[index] = array[max]
            array[max] = temp
        }
    }
    println(array.toList())
}
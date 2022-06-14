package sorting

// avg O(nlogn)
// Worst case O(n2)

fun main() {
    val array = arrayOf(45, 3, 4, 10, 40)
    println(array.toList())

    quickSort(array, 0, array.size - 1)
    println(array.toList())
}

fun quickSort(array: Array<Int>, start: Int, end: Int) {
    if (start < end) {
        val mid = partition(array, start, end)
        quickSort(array, start, mid - 1)
        quickSort(array, mid + 1, end)
    }
}

fun partition(array: Array<Int>, start: Int, end: Int): Int {
    val pivot = array[end]
    var smallIndex = start - 1

    for (j in start until end) {
        if (array[j] <= pivot) {
            smallIndex++
            // swap
            array[j] = array[smallIndex].also { array[smallIndex] = array[j] }
        }
    }
    // swap
    array[smallIndex + 1] = array[end].also { array[end] = array[smallIndex + 1] }
    return smallIndex + 1
}
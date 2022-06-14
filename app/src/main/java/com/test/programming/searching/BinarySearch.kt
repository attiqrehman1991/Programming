package searching

// The time complexity is O(logN)
// for sorted array

fun main() {
    val array = arrayOf(2, 3, 4, 10, 40)
    val elementToSearch = 40

    val index = binarySearch(array, 0, array.size - 1, elementToSearch)
    if (index != -1)
        println("Element is present at index $index")
    else
        println("Element is not present in the array")
}

fun binarySearch(array: Array<Int>, start: Int, last: Int, elementToSearch: Int): Int {
    if (last >= start) {
        val mid = start + (last - start) / 2

        return when {
            array[mid] == elementToSearch -> mid
            array[mid] > elementToSearch -> binarySearch(array, start, mid - 1, elementToSearch)
            else -> binarySearch(array, mid + 1, last, elementToSearch)
        }
    }
    return -1
}
package sorting

// O(NLogN)
// follow divide and conquer algo
// divides into two halves and so on
// then merges the sorted halves

fun main() {
    val array = arrayOf(45, 3, 4, 10, 40)
    println(array.toList())

    mergeSort(array, 0, array.size - 1)
    println(array.toList())
}

fun mergeSort(array: Array<Int>, start: Int, end: Int) {
    if (start < end) {
        val mid = (start + end) / 2
        mergeSort(array, 0, mid)
        mergeSort(array, mid + 1, end)
        merge(array, start, mid, end)
    }
}

fun merge(array: Array<Int>, start: Int, mid: Int, end: Int) {
    val leftArray = array.copyOfRange(start, mid + 1)
    val rightArray = array.copyOfRange(mid + 1, end + 1)

    var i = 0
    var j = 0

    for (k in start..end) {
        if ((i <= leftArray.size - 1) && ((j >= rightArray.size) || (leftArray[i] <= rightArray[j]))) {
            array[k] = leftArray[i];
            i++
        } else {
            array[k] = rightArray[j];
            j++
        }
    }
}
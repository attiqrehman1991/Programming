package sorting

// O(N2)
// works the way sorting of cards
// choose element from unsorted array and placed it in the sorted sequence of elements
fun main() {
    val array = intArrayOf(64, 24, 12, 33, 32)
    println(array.toList())

    var i: Int
    for (index in 1 until array.size) {
        val key = array[index]
        i = index - 1
        while (i >= 0 && array[i] > key) {
            array[i + 1] = array[i]
            i--
        }
        array[i + 1] = key
    }
    println(array.toList())

}
package searching

// The time complexity is O(n)

fun main() {
    val array= arrayOf(2, 3, 5, 6, 10, 45)
    val elementToSearch = 5

    val index= search(array, elementToSearch)

    if(index!=-1)
        println("Element is present at index $index")
    else
        println("Element is not present in the array")
}

fun search(array: Array<Int>, elementToSearch:Int):Int {
    for ((index, element) in array.withIndex()) {
        if(element == elementToSearch)
            return index
    }
    return -1
}
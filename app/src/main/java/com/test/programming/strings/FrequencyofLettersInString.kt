package strings

/**
 * Frequency of Letters In String
 */
fun main() {
    val givenString = "aaaabbcccccddf"

    val array = Array(26) { 0 }
    for (j in 0 until givenString.length)
        array[givenString[j] - 'a']++

    for (j in 0 until 26) {
        if (array[j] != 0) {
            print(message = array[j])
            print(message = 'a' + j)
        }
    }
}

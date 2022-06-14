package interestings

fun main() {
    val triangleSize = 5
    var number: Int
    var space = triangleSize

    for (i in 0 until triangleSize + 1) {
        for (s in 1 until space + 1)
            print(" ")
        number = 1
        for (j in 0 until i + 1) {
            print(number)
            print(" ")
            number = number * (i - j) / (j + 1)
        }
        space--
        println()
    }
}
package interestings

import kotlin.math.absoluteValue

fun main() {
    val list = listOf<Int>(25626, 25757, 24367, 24267, 16, 100, 2, 7277)

    var result: String = list[0].toString() + " "
    for (j in 1 until list.size) {
        val diff = list.get(j) - list.get(j - 1)
        if (diff.absoluteValue > 127)
            result += "-128 "
        result += "$diff "
    }
    println(result)
}
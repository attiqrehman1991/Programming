package com.test.programming.test

fun main() {

    println( solution("CrCellBax") )
    println( solution("aCaBBCCab") )
    println( solution("aBB") )
}

fun solution(S: String): String {
    // write your code in Kotlin 1.3.11 (Linux)
    if(S.isEmpty()) return S

    val stringBuilder = StringBuilder()
    var pointer = 0
    var isCapsOn = false
    S.forEach {
        if(it == 'C') {
            isCapsOn = !isCapsOn
        } else if (it == 'B') {
            if(stringBuilder.isNotEmpty())
                stringBuilder.setLength(stringBuilder.length-1)
        } else {
                stringBuilder.append(if (isCapsOn) it - 32 else it)
        }
    }
    return stringBuilder.toString()
}
package com.test.programming.amazon


fun main() {
    if (isValidParentheses("[{}]({{()}}()]"))
        println("True")
    else
        println("False")

    if (isValidParentheses("{}[{{()}}()]"))
        println("True")
    else
        println("False")
}

fun isValidParentheses(str: String): Boolean {
    val array = ArrayDeque<Char>()

    str.forEach {
        when (it) {
            '(' -> array.addLast(')')
            '{' -> array.addLast('}')
            '[' -> array.addLast(']')
            else -> {
                if (array.isEmpty()) return false
                if (array.removeLast() != it) return false
            }
        }
    }
    if (array.isNotEmpty()) return false
    return true
}
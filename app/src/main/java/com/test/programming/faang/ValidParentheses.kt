package com.test.programming.faang

import java.util.*

fun main() {
    if (validParentheses("[{}]({{()}}()]"))
        println("True")
    else
        println("False")
    if(validParentheses("{}[{{()}}()]"))
        println("True")
    else
        println("False")
    if(isValid("{}[{{()}}()]"))
        println("True")
    else
        println("False")
}

//private companion object{
//
//
//}

fun isValid(str: String) : Boolean {
    val PAREN_OPEN1 = '('
    val PAREN_OPEN2 = '['
    val PAREN_OPEN3 = '{'
    val PAREN_CLOSED1 = ')'
    val PAREN_CLOSED2 = ']'
    val PAREN_CLOSED3 = '}'

    val stack = ArrayDeque<Char>()

    for(ch in str) {
        when (ch) {
            PAREN_OPEN1 -> stack.addLast(PAREN_CLOSED1)
            PAREN_OPEN2 -> stack.addLast(PAREN_CLOSED2)
            PAREN_OPEN3 -> stack.addLast(PAREN_CLOSED3)
            else -> {
                if(stack.isEmpty())
                    return false
                if(stack.removeLast() != ch)
                    return false
            }
        }
    }
    if(stack.isNotEmpty())
        return false
    return true
}

fun validParentheses(s: String): Boolean {
    val stack = Stack<Char>()

    for(i in s.indices) {
        val c = s[i]
        if(c == '(' || c == '{' || c == '[') {
            stack.push(c)
        }
        var check: Char
        when (c) {
            ')' -> {
                if(stack.isEmpty()) return false
                check = stack.pop()
                if(check == '{' || check == '[')
                    return false
            }
            '}' -> {
                if(stack.isEmpty()) return false
                check = stack.pop()
                if(check == '(' || check == '[')
                    return false
            }
            ']' -> {
                if(stack.isEmpty()) return false
                check = stack.pop()
                if(check == '(' || check == '{')
                    return false
            }
        }
    }
    return stack.isEmpty()
}
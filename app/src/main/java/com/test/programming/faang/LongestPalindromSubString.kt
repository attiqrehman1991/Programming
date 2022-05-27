package com.test.programming.faang

import java.lang.StringBuilder

fun main() {
    val str = "forgeeksskeegfor"
    println("Length is: ${longestPalindromSubString(str)}")
    println("Length is: ${longestPalindrome(str)}")
}

fun longestPalindromSubString(str: String):String {
    var maxLength = 0
    var start = 0

    for(i in str.indices) {
        for (j in i until str.length) {

            var flag = 1
            for (k in 0 until (j - i + 1) / 2) {
                if(str[i + k] != str[j - k]) {
                    flag = 0
                }
            }

            if(flag !=0 && (j - i + 1) > maxLength) {
                start = i
                maxLength = j - i + 1
            }

        }
    }
    val stringBuilder = StringBuilder()
    for(index in start until start + maxLength) {
        stringBuilder.append(str[index].toString())
        print(str[index])
    }

    println(stringBuilder.length)

    return stringBuilder.toString()
}

fun longestPalindrome(s: String): String {
    return if (s.length <= 1) s
    else longestPalindromeDp(s, 0, s.length - 1, Array(s.length) {
        Array(s.length) {
            null
        }
    })

}

private fun longestPalindromeDp(s: String, i: Int, j: Int, map: Array<Array<String?>>): String {
    return map[i][j] ?: run {
        map[i][j] = when {
            i > j -> ""
            i == j -> s[i].toString()
            else -> {
                if ((s[i] == s[j]) && longestPalindromeDp(s, i + 1, j - 1, map).length == j - 1 - i) {
                    s.substring(i, j + 1)
                } else {
                    val s1 = longestPalindromeDp(s, i + 1, j, map)
                    val s2 = longestPalindromeDp(s, i, j - 1, map)
                    if (s1.length > s2.length) s1 else s2
                }
            }
        }
        return map[i][j]!!
    }
}
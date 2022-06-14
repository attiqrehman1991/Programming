package com.test.programming.amazon

import com.test.programming.faang.longestPalindrome

fun main() {
    val str = "forgeeksskeegfor"
    println("Length is: ${longestPalindromicSubString(str)}")
}

fun longestPalindromicSubString(s: String): String {
    if(s.length < 2) return s

    var resultLength = 0
    var result = ""

    for(i in s.indices) {

        // Odd length
        var l = i
        var r = i
        while(l >= 0 && r < s.length && s[l] == s[r]) {
            if(r - l + 1 > resultLength) {
                result = s.substring(l , r + 1)
                resultLength = r - l + 1
            }
            l -= 1
            r += 1
        }

        // Even length
        l = i
        r = i + 1
        while(l >= 0 && r < s.length && s[l] == s[r]) {
            if(r - l + 1 > resultLength) {
                result = s.substring(l , r + 1)
                resultLength = r - l + 1
            }
            l -= 1
            r += 1
        }

    }
    return result
}
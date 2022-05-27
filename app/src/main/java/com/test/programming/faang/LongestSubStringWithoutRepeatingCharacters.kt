package com.test.programming.faang

fun main() {
    println(longestSubStringWithoutRepeatingCharacters("abcabcbb"))
    println(longestSubStringWithoutRepeatingCharacters("bbbbb"))
    println(longestSubStringWithoutRepeatingCharacters("pwwkew"))
}

fun longestSubStringWithoutRepeatingCharacters(string: String): Int {
    var max = 0
    var first = 0
    var second = 0

    val hashSet = HashSet<Char>()
    while (second < string.length) {
        if (!hashSet.contains(string[second])) {
            hashSet.add(string[second])
            max = Math.max(max, hashSet.size)
            second++
        } else {
            hashSet.remove(string[first])
            first++
        }
    }

    return max
}
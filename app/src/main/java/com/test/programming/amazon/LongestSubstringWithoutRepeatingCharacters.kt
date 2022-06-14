package com.test.programming.amazon

fun main() {
    println(lengthOfLongestSubstring("abcabcbb"))
    println(lengthOfLongestSubstring("bbbbb"))
    println(lengthOfLongestSubstring("pwwkew"))
}

fun lengthOfLongestSubstring(s: String): Int {
    if(s.isEmpty()) return 0

    var count = 0
    val set = HashSet<Char>()
    var i = 0
    var j = 0

    while(j < s.length) {
        if(!set.contains(s[j])) {
            set.add(s[j++])
            count = Math.max(count, set.size)
        } else {
            set.remove(s[i++])
        }
    }
    return count
}
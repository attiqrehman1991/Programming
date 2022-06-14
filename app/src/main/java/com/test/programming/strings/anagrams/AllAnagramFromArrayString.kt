package com.test.programming.strings.anagrams

fun main() {
    val array = arrayOf("geeksquiz", "geeksforgeeks", "abcd", "forgeeksgeeks", "zuiqkeegs", "forgeekgseeks")

    for (i in 0 until array.size)
        for (j in i + 1 until array.size) {
            if (isAnagramFun(array[i], array[j]))
                println(array[i] + " is anagram of " + array[j])
        }
}

private fun isAnagramFun(string1: String, string2: String): Boolean {
    if (string1.length != string2.length)
        return false

    val array1 = Array(26) { 0 }
    val array2 = Array(26) { 0 }

    for (j in 0 until string1.length) {
        array1[string1[j] - 'a']++
        array2[string2[j] - 'a']++
    }
    for (j in 0 until 26) {
        if (array1[j] != array2[j])
            return false
    }
    return true
}
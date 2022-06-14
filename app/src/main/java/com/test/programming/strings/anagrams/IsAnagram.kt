package com.test.programming.strings.anagrams

/**
 * Anagram functions
 */
fun main() {
    val stringOne = "includehelp"
    val stringTwo = "includehepl"

//    val isAnagram = isAnagramDirect(stringOne.toLowerCase(), stringTwo.toLowerCase())
    val isAnagram = isAnagramFun(stringOne.toLowerCase(), stringTwo.toLowerCase())

    if (isAnagram) println("They are anagram") else println("They are not anagram")
}

fun isAnagramDirect(string1: String, string2: String): Boolean {
    val one = string1.toCharArray().sorted().toString()
    val two = string2.toCharArray().sorted().toString()
    return one == two
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
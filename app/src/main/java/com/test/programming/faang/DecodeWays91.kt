package com.test.programming.faang


fun main() {
    println(decodeWays91DP("12"))

    println(decodeWays91("12"))
}

// withdp

fun decodeWays91(string: String): Int {
    val array = IntArray(string.length + 1)
    val ans = numDecoding(string, 0, array)
    return ans
}

fun numDecoding(s: String, i: Int, array: IntArray): Int {
    if (i == s.length)
        return 1;
    if (s[i] == '0')
        return 0;
    if (i == s.length - 1)
        return 1;

    if(array[i] > 0)
        return array[i]

    val way1 = numDecoding(s, i + 1, array)
    var way2 = 0
    if (s.substring(i, i + 2).toInt() < 27) {
        way2 = numDecoding(s, i + 2, array)
    }
    array[i] = way1 + way2
    return way1 + way2
}


// without dp
fun decodeWays91DP(string: String): Int {
    val ans = numDecodingDP(string, 0)
    return ans
}

fun numDecodingDP(s: String, i: Int): Int {
    if (i == s.length)
        return 1;
    if (s[i] == '0')
        return 0;
    if (i == s.length - 1)
        return 1;

    val way1 = numDecodingDP(s, i + 1)
    var way2 = 0
    if (s.substring(i, i + 2).toInt() < 27) {
        way2 = numDecodingDP(s, i + 2)
    }
    return way1 + way2
}

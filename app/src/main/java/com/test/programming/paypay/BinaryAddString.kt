package com.test.programming.paypay

fun main() {
    val str1 = "11"
    val str2 = "1"

    println(addBinary(str1, str2))

    val s21 = "1010"
    val s22 = "1011"

    println(addBinary(s21, s22))
}

fun addBinary(str1: String, str2: String): String {
    val stringBuilder = StringBuilder()
    var sum = 0

    var i = str1.length - 1
    var j = str2.length - 1

    var carry = 0
    while (i >= 0 || j >= 0) {
        sum = carry
        val pair = addToBinary(i, sum, str1)
        i = pair.first
        sum = pair.second
        val pair1 = addToBinary(j, sum, str2)
        j = pair1.first
        sum = pair1.second
        carry = sumToAdd(stringBuilder, sum, carry)
    }
    if (carry > 0)
        stringBuilder.insert(0, carry)

    return stringBuilder.toString()
}

private fun sumToAdd(
    stringBuilder: StringBuilder,
    sum: Int,
    carry: Int
): Int {
    var carry1 = carry
    stringBuilder.insert(0, sum % 2)
    carry1 = sum / 2
    return carry1
}

private fun addToBinary(
    i: Int,
    sum: Int,
    str1: String
): Pair<Int, Int> {
    var i1 = i
    var sum1 = sum
    if (i1 >= 0)
        sum1 += str1[i1--] - '0'
    return Pair(i1, sum1)
}

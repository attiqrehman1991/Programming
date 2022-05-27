package com.test.programming.test

import java.util.regex.Pattern

fun main() {
//    println( two("FooBar123!"))
//    println( two("foobar123!"))
//    println( two("FooBar123"))
    println(two("F0bar!F0bar!"))
//    println( two("Fo0"))
}

fun two(S: String): Boolean {
    if (S.isEmpty()) return false

    val isLengthVerified = verifyLength(S, 6)
    val isContainAtleastOneDigit = verifyIfItContainDigit(S)
    val isContainAtleastOneLowerCaseLetter = verifyIfItContainLowerCaseLetter(S)
    val isContainAtleastOneUpperCaseLetter = verifyIfItContainUpperCaseLetter(S)
    val doesItNotContainSpace = verifyIfItContainSpace(S)
    val isContainAtleastSpecialCharacter = verifyIfItContainSpecialCharacter(S)

//    val a= all(S)
    return isLengthVerified && isContainAtleastOneDigit && isContainAtleastOneLowerCaseLetter && isContainAtleastOneUpperCaseLetter &&
            isContainAtleastSpecialCharacter && doesItNotContainSpace
}

private fun verifyLength(S: String, length: Int): Boolean = S.length >= length

private fun verifyIfItContainDigit(S: String): Boolean = Pattern.compile("[0-9]").matcher(S).find()

private fun verifyIfItContainLowerCaseLetter(S: String): Boolean =
    Pattern.compile("[a-z]").matcher(S).find()

private fun verifyIfItContainUpperCaseLetter(S: String): Boolean =
    Pattern.compile("[A-Z]").matcher(S).find()
private fun verifyIfItContainSpace(S:String) : Boolean = !S.contains(" ")

private fun verifyIfItContainSpecialCharacter(S: String): Boolean {
    if(Pattern.compile("[!@#$%^&*()]").matcher(S).find()) {
        val res = S.replace("[^<[{\\-\\\\=|]}?\\+.>]".toRegex(), "") // - and * need to be escaped
        return res.isEmpty()
    }
    return false
}


//private fun all(S:String) : Boolean = Pattern.compile("^[a-zA-Z0-9!@#\$%^&*()]*\$").matcher(S).find()

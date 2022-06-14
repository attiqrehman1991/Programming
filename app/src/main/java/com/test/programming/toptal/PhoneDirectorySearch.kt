package com.test.programming.toptal

fun main() {
    var A = arrayOf("pim", "pom")
    var B = arrayOf("999999999", "777888999")
    var P = "88999"

    println( phoneDirectorySearch(A, B, P) )

    A = arrayOf("sander", "amy", "ann", "michael")
    B = arrayOf("123456789", "234567890", "789123456", "123123123")
    P = "1"

    println( phoneDirectorySearch(A, B, P) )

    A = arrayOf("adam", "eva", "leo")
    B = arrayOf("121212121", "111111111", "444555666")
    P = "112"

    println( phoneDirectorySearch(A, B, P) )
}
// A - > list of names
// b -> list of phone numbers
// c -> phone number to search

fun phoneDirectorySearch(A:Array<String>, B:Array<String>, P:String ) : String{
    val N = B.size
    var result = ""
    var resultB = false

    for(i in 0 until N) {
        val phoneNo = B[i]
        if(phoneNo.contains(P)) {
            if(!resultB) {
                result = A[i]
                resultB = true
            }
            if(resultB && A[i] < result) {
                result = A[i]
            }
        }
    }
    if(resultB) return result
    return "No Contact"
}
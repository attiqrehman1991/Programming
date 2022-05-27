package com.test.programming.paypay

fun main() {
    println(returnCash(230.0, 500.0))
}


val notes = arrayOf<Pair<Double, String>>(
    Pair(.01, "PENNY"),
    Pair(.05, "NICKEL"),
    Pair(.1, "DIME"),
    Pair(.25, "QUARTER"),
    Pair(.5, "HALF DOLLAR"),
    Pair(1.0, "ONE"),
    Pair(2.0, "TWO"),
    Pair(5.0, "FIVE"),
    Pair(10.0, "TEN"),
    Pair(20.0, "TWENTY"),
    Pair(50.0, "FIFTY"),
    Pair(100.0, "ONE Hundred")
)

fun returnCash(product: Double, cash: Double) {
    val remainingAmount = cash - product
    val list = mutableListOf<String>()

    loopFunction(remainingAmount, list)
    sortFunction(list)
    println(list.joinToString(" "))
}

private fun sortFunction(list: MutableList<String>) {
    list.sort()
}

private fun loopFunction(
    remainingAmount: Double,
    list: MutableList<String>
) {
    var remainingAmount1 = remainingAmount
    for (i in notes.reversed()) {
        while (remainingAmount1 >= i.first) {
            list.add(i.second)
            remainingAmount1 -= i.first
        }
    }
}
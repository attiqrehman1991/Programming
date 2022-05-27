package com.test.programming.faang

fun main() {

    // exponential time
    //		int[] ar = { 2, 3, 6, 7 };
//		int target = 7;
    //		int[] ar = { 2, 3, 6, 7 };
//		int target = 7;
    val array = intArrayOf(2, 3, 5)
    val target = 8

    val output = combinationSum(array, target)
    for(out in output) {
        println(out.toString())
    }
}


fun combinationSum(array: IntArray, target: Int): ArrayList<ArrayList<Int>> {
    val output = arrayListOf<ArrayList<Int>>()
    if(array.isEmpty()) return output

    val current = arrayListOf<Int>()
    val index = 0
    getAllPossibleAgainstIndex(array, target, index, output, current)
    return output
}

fun getAllPossibleAgainstIndex(array: IntArray, target: Int, index:Int, output: ArrayList<ArrayList<Int>>, current: MutableList<Int>) {
    if(target == 0) {
        output.add(ArrayList(current))
        return
    } else if (target < 0 || index == array.size) {
        return
    } else {
        current.add(array[index])
        getAllPossibleAgainstIndex(array, target - array[index], index, output, current)
        current.removeAt(current.size - 1)
        getAllPossibleAgainstIndex(array, target, index + 1, output, current)
    }
}

fun getAllCombinationsUtil(
    a: IntArray, sum: Int, currIndex: Int, result: MutableList<MutableList<Int>>,
    curr: MutableList<Int>
) {
    if (sum == 0) {
        result.add(ArrayList(curr))
        return
    } else if (sum < 0 || currIndex == a.size) {
        return
    } else {
        curr.add(a[currIndex])
        getAllCombinationsUtil(a, sum - a[currIndex], currIndex, result, curr)
        curr.removeAt(curr.size - 1)
        getAllCombinationsUtil(a, sum, currIndex + 1, result, curr)
    }
}

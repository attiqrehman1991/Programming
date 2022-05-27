package com.test.programming.faang

fun main() {
    val strs = arrayOf("eat","tea","tan","ate","nat","bat")
    val output = groupAnagrams(strs)

    for(out in output) {
        println( out.toString() )
    }
}

fun groupAnagrams(strs: Array<String>): List<List<String>> {
    val output = ArrayList<MutableList<String>>()
    if(strs.isEmpty()) {
        return output
    }

    val hashMap = HashMap<String, MutableList<String>>()

    strs.forEach {

        val sorted = it.toCharArray().sorted().joinToString("")
        if(!hashMap.containsKey(sorted))
            hashMap[sorted] = mutableListOf()
        val existingListWithDefault = hashMap[sorted]
        existingListWithDefault!!.add(it)
        hashMap[sorted] = existingListWithDefault
    }

    hashMap.forEach { (_, value) ->
        output.add(value)
    }
    return output
}
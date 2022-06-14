package strings.anagrams

fun main() {
    val list = mutableListOf<String>()
    list.add("eat")
    list.add("tea")
    list.add("tan")
    list.add("ate")
    list.add("nat")
    list.add("bat")

    println(findAnagrams(list))
}

fun findAnagrams(words: MutableList<String>?): Map<String, MutableList<String>>? {
    val anagrams: Map<String, MutableList<String>>

    if (words == null)
        return null

    anagrams = mutableMapOf()
    for (word in words) {
        val sorted = word.toCharArray().sorted().toString()
        if (anagrams.containsKey(sorted)) {
            val newList = anagrams.get(sorted)
            newList!!.add(word)
            anagrams.put(sorted, newList)
        } else {
            val list = mutableListOf<String>()
            list.add(word)
            anagrams.put(sorted, list)
        }
    }
    return anagrams
}
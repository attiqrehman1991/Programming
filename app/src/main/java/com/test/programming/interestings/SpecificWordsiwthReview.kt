package interestings

fun main() {
    val keywords = readLine()!!.split(" ").toSet()
    val numberOfCases = readLine()!!.toInt()

    // read review
    val hotelCount: MutableMap<Int, Int> = mutableMapOf()

    for (i in 0 until numberOfCases) {
        val id = readLine()!!.toInt()
        if (!hotelCount.containsKey(id)) {
            hotelCount.put(id, 0)
        }
        val reviews = readLine()!!.split(" ").toMutableList()
        for (index in 0 until reviews.size) {
            reviews[index] = reviews[index].replace("[$!,.]", "").toLowerCase()
            if (keywords.contains(reviews[index])) {
                hotelCount.put(id, hotelCount.getValue(id) + 1)
            }
        }
        
    }


    val sorted = hotelCount.toList().sortedBy { (_, value) -> value }.toMap()
//    val sorted= hotelCount.toList().sortedBy{ it.second }.toMap()

    for (entry in sorted) {
        print("key: " + entry.key)
        println(" Value: " + entry.value)
    }


//    val sorted:MutableList<MutableSet<MutableMap.MutableEntry<Number, Number>>> = mutableListOf(hotelCount.entries)
//    var entry:MutableMap.MutableEntry<Int, Int>?
//    sorted.add(entry)

//    for(hotelEntry in sorted) {
//        print(hotelEntry.)
//    }

}
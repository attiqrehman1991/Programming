package com.test.programming.faang

fun main() {
    val node1: ListNode? = ListNode(1)
    node1?.next = ListNode(4)
    node1?.next?.next = ListNode(5)

    val node2: ListNode = ListNode(1)
    node2.next = ListNode(3)
    node2.next?.next = ListNode(4)

    val node3: ListNode = ListNode(2)
    node3.next = ListNode(6)

    val input = arrayOf(node1, node2, node3)
    var ouput = mergeKLists(input, 2)
    while (ouput != null) {
        println(ouput.`val`)
        ouput = ouput.next
    }
}

fun mergeKLists(input: Array<ListNode?>?, k: Int): ListNode? {
    if (input == null || input.isEmpty()) return null
    var last = k
    while (last != 0) {
        var i = 0
        var j = last

        while (i < j) {
            input[i] = sortedMerge(input[i], input[j])
            i++
            j--
            if (i >= j)
                last = j
        }
    }

    return input[0]
}

fun sortedMerge(listNode1: ListNode?, listNode2: ListNode?): ListNode? {
    if (listNode1 == null && listNode2 == null) return null
    if (listNode1 == null) return listNode2
    if (listNode2 == null) return listNode1
    var result: ListNode? = null
    if (listNode1.`val` <= listNode2.`val`) {
        result = ListNode(listNode1.`val`)
        result.next = sortedMerge(listNode1.next, listNode2)
    } else {
        result = ListNode(listNode2.`val`)
        result.next = sortedMerge(listNode1, listNode2.next)
    }
    return result
}

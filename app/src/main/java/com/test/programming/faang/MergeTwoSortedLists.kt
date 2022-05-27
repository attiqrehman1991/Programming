package com.test.programming.faang

fun main() {

//    val list1 = ListNode(1)
//    list1.next = ListNode(2)
//    list1.next?.next = ListNode(4)
//
//    val list2 = ListNode(1)
//    list2.next = ListNode(3)
//    list2.next?.next = ListNode(4)

    val list1 = ListNode(-9)
    list1.next = ListNode(3)
//    list1.next?.next = ListNode(4)

    val list2 = ListNode(5)
    list2.next = ListNode(7)
//    list2.next?.next = ListNode(4)

//    var combined = mergeTwoLists(list1, list2)
    var combined = mergeTwoLists(list1, list2)

    while(combined!=null) {
        println( combined.`val` )
        combined = combined.next
    }
}

fun mergeTwoLists(list1: ListNode?, list2: ListNode?): ListNode? {
    if(list1 == null && list2 == null)
        return null
    if(list1==null) return list2
    if(list2==null) return list1

    val head = ListNode(0)
    var combinedList = head

    var list11 = list1
    var list22 = list2

    while(list11 !=null && list22 != null) {
        if (list11.`val` > list22.`val`) {
            combinedList.next = ListNode(list22.`val`)
            combinedList = combinedList.next!!
            list22 = list22.next
        } else {
            combinedList.next = ListNode(list11.`val`)
            combinedList = combinedList.next!!
            list11 = list11.next
        }
    }

    while(list11!=null) {
        combinedList.next = ListNode(list11.`val`)
        combinedList = combinedList.next!!
        list11 = list11.next
    }

    while(list22!=null) {
        combinedList.next = ListNode(list22.`val`)
        combinedList = combinedList.next!!
        list22 = list22.next
    }

    return head.next
}
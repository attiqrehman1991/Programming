package com.test.programming.faang

fun main() {
    val node = ListNode(1)
//    node.next = ListNode(2)
//    node.next!!.next =ListNode(3)
//    node.next!!.next!!.next=ListNode(4)
//    node.next!!.next!!.next!!.next=ListNode(5)

//    node.print(node)
    removeTheNthNodeFromTheEndOftheList(node, 1)
    removeNthFromEnd(node, 1)
}

fun removeTheNthNodeFromTheEndOftheList(head: ListNode?, n:Int) : ListNode? {
    if(head == null) {
        return null
    }
    val newHead = ListNode(0)
    newHead.next = head
    var fastNode = newHead
    var slowNode = newHead
    var waitForSlowIndex = n
    while(fastNode.next !=null) {
        fastNode = fastNode.next!!
        if(waitForSlowIndex > 0) {
            waitForSlowIndex --
        } else
            slowNode = slowNode.next!!
    }

    slowNode.next = slowNode.next!!.next

//    node.print(node)
    return newHead.next
}

fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
    var n = n
    val newHead = ListNode(0)
    newHead.next = head
    var a: ListNode? = newHead
    var b: ListNode? = newHead
    while (n > 0) {
        b = b!!.next
        n--
    }
    while (b!!.next != null) {
        b = b.next
        a = a!!.next
    }
    a!!.next = a.next!!.next
    return newHead.next
}
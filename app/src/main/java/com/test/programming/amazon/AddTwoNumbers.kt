package com.test.programming.amazon

import com.test.programming.faang.ListNode

fun main() {

    val l1 = ListNode(2)
    l1.next = ListNode(4)
    l1.next?.next = ListNode(3)

    val l2 = ListNode(5)
    l2.next = ListNode(6)
    l2.next?.next = ListNode(7)

    var l3 = addTwoNumbers(l1, l2)

    while (l3!=null) {
        println(l3.`val`)
        l3 = l3.next
    }

    println( multiply(3,2) )
}

fun addTwoNumbers(l11: ListNode?, l22: ListNode?): ListNode? {
    var l1 = l11
    var l2 = l22
    val sumNode:ListNode?= ListNode(0)
    var newNode = sumNode

    var carry = 0
    while(l1 != null || l2 != null) {
        var sum = carry
        if(l1 != null) {
            sum += l1.`val`
            l1 = l1.next
        }
        if(l2 != null) {
            sum += l2.`val`
            l2 = l2.next
        }
        carry = sum/10
        newNode?.next = ListNode(sum %10)
        newNode = newNode?.next
    }
    if(carry > 0) {
        newNode?.next = ListNode(carry)
    }

    return sumNode?.next
}

fun multiply(x: Int, y: Int): Int {
    /* 0 multiplied with anything gives 0 */
    if (y == 0) return 0
    /* Add x one by one */
    if (y > 0) return x + multiply(x, y - 1)
    /* the case where y is negative */
    return if (y < 0) -multiply(x, -y) else -1
}

//for(int i=1;i<=x;i++)
//{
////calculates the sum
//    sum=sum+y;
//}
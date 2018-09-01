package com.algorithm.datastructure

import org.junit.Test

class ReverseLinkedListTest {
    @Test
    fun test() {
        val reverseLinkedList = ReverseLinkedList()
        reverseLinkedList.printDescription()
        val dummy = ReverseLinkedList.ListNode(0)
        var curt: ReverseLinkedList.ListNode? = dummy
        curt!!.next = ReverseLinkedList.ListNode(1)
        curt = curt.next
        curt!!.next = ReverseLinkedList.ListNode(2)
        curt = curt.next
        curt!!.next = ReverseLinkedList.ListNode(3)
        curt = curt.next
        curt!!.next = ReverseLinkedList.ListNode(4)
        curt = curt.next
        curt!!.next = ReverseLinkedList.ListNode(5)

        var head = reverseLinkedList.reverseList(dummy.next)

        while (head != null) {
            System.out.println("${head.`val`}->")
            head = head.next
        }
    }
}
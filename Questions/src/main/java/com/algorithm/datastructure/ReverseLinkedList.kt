package com.algorithm.datastructure

import com.algorithm.AlgorithmQuestion

class ReverseLinkedList : AlgorithmQuestion {
    override fun printDescription() {
        System.out.println("Reverse a singly linked list.\n" +
                "\n" +
                "Example:\n" +
                "\n" +
                "Input: 1->2->3->4->5->NULL\n" +
                "Output: 5->4->3->2->1->NULL\n" +
                "Follow up:\n" +
                "\n" +
                "A linked list can be reversed either iteratively or recursively. Could you implement both?\n" +
                "\n")
    }

    class ListNode(var `val`: Int, var next: ListNode? = null)

    fun reverseList(head: ListNode?): ListNode? {
        if (head == null) {
            return null
        }
        val dummy = ListNode(0)
        dummy.next = head
        val curt = dummy.next
        while (curt!!.next != null) {
            val temp = curt.next
            curt.next = temp!!.next
            temp.next = dummy.next
            dummy.next = temp
        }
        return dummy.next
    }
}
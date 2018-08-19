package com.algorithm.datastructure

import com.algorithm.AlgorithmQuestion

class ReverseKGroup : AlgorithmQuestion {
    override fun printDescription() {
        System.out.println("Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.\n" +
                "\n" +
                "k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.\n" +
                "\n" +
                "Example:\n" +
                "\n" +
                "Given this linked list: 1->2->3->4->5\n" +
                "\n" +
                "For k = 2, you should return: 2->1->4->3->5\n" +
                "\n" +
                "For k = 3, you should return: 3->2->1->4->5\n" +
                "\n" +
                "Note:\n" +
                "\n" +
                "Only constant extra memory is allowed.\n" +
                "You may not alter the values in the list's nodes, only nodes itself may be changed.")
    }

    inner class ListNode(var value: Int, var next: ListNode? = null)

    fun reverseKGroup(head: ListNode, k: Int): ListNode {
        val dummy = ListNode(-1)
        dummy.next = head

        var prev: ListNode? = dummy

        while (prev != null) {
            if (!checkLength(prev, k)) {
                break
            }
            val curt = prev.next!!
            for (i in 0 until k - 1) {
                val temp = curt.next
                curt.next = temp!!.next
                temp.next = prev.next
                prev.next = temp
            }
            prev = curt
        }
        return dummy.next!!
    }

    private fun checkLength(prev: ListNode, k: Int): Boolean {
        var len = 0
        var curt: ListNode? = prev
        while (len < k) {
            curt = curt!!.next
            if (curt == null) {
                break
            }
            len++
        }
        return len == k
    }
}
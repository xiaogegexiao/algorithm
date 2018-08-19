package com.algorithm.datastructure

import com.algorithm.AlgorithmQuestion

class SwapNodeInPairs : AlgorithmQuestion {
    override fun printDescription() {
        System.out.println("Given a linked list, swap every two adjacent nodes and return its head.\n" +
                "\n" +
                "Example:\n" +
                "\n" +
                "Given 1->2->3->4, you should return the list as 2->1->4->3.\n" +
                "Note:\n" +
                "\n" +
                "Your algorithm should use only constant extra space.\n" +
                "You may not modify the values in the list's nodes, only nodes itself may be changed.")
    }

    inner class ListNode(var value: Int, var next: ListNode? = null)

    fun swapPairs(node: ListNode): ListNode {
        val dummy = ListNode(-1)
        dummy.next = node

        val reverseCount = 2
        var prev: ListNode? = dummy
        while (prev != null) {
            if (!checkLength(prev, reverseCount)) {
                break
            }
            val curt = prev.next
            for (i in 0 until reverseCount - 1) {
                val temp = curt!!.next
                curt.next = temp!!.next
                temp.next = prev.next
                prev.next = temp
            }
            prev = curt
        }
        return dummy.next!!
    }

    private fun checkLength(node: ListNode, k: Int): Boolean {
        var len = 0
        var curt: ListNode? = node
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
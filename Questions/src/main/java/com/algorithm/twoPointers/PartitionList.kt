package com.algorithm.twoPointers

import com.algorithm.AlgorithmQuestion

class PartitionList : AlgorithmQuestion {
    override fun printDescription() {
        System.out.println("Description\n" +
                "Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.\n" +
                "\n" +
                "You should preserve the original relative order of the nodes in each of the two partitions.\n" +
                "\n" +
                "Have you met this question in a real interview?  \n" +
                "Example\n" +
                "Given 1->4->3->2->5->2->null and x = 3,\n" +
                "return 1->2->2->4->3->5->null.")
    }

    class ListNode internal constructor(internal var `val`: Int) {
        var next: ListNode? = null
    }

    /**
     * @param head: The first node of linked list
     * @param x: An integer
     * @return: A ListNode
     */
    fun partition(head: ListNode?, x: Int): ListNode? {
        var head = head
        val dummyLess = ListNode(0)
        var currentLess: ListNode? = dummyLess
        val dummyLE = ListNode(0)
        var currentLE: ListNode? = dummyLE
        while (head != null) {
            if (head.`val` < x) {
                currentLess!!.next = head
                currentLess = currentLess.next
            } else {
                currentLE!!.next = head
                currentLE = currentLE.next
            }
            head = head.next
        }
        currentLess!!.next = dummyLE.next
        currentLE!!.next = null
        return dummyLess.next
    }
}
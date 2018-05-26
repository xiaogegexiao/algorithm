package com.algorithm.twoPointers

import junit.framework.Assert.assertEquals
import org.junit.Test

class PartitionListTest {
    @Test
fun test() {
        var partitionList = PartitionList()
        partitionList.printDescription()

        var dummy = PartitionList.ListNode(0)
        var curt: PartitionList.ListNode? = dummy
        curt!!.next = PartitionList.ListNode(1)
        curt = curt.next
        curt!!.next = PartitionList.ListNode(4)
        curt = curt.next
        curt!!.next = PartitionList.ListNode(3)
        curt = curt.next
        curt!!.next = PartitionList.ListNode(2)
        curt = curt.next
        curt!!.next = PartitionList.ListNode(5)
        curt = curt.next
        curt!!.next = PartitionList.ListNode(2)

        var result: PartitionList.ListNode? = partitionList.partition(dummy.next, 3)
        assertEquals(1, result!!.`val`)
        result = result.next
        assertEquals(2, result!!.`val`)
        result = result.next
        assertEquals(2, result!!.`val`)
        result = result.next
        assertEquals(4, result!!.`val`)
        result = result.next
        assertEquals(3, result!!.`val`)
        result = result.next
        assertEquals(5, result!!.`val`)
        result = result.next
    }
}
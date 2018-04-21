package com.algorithm.binary_tree

import junit.framework.Assert.assertEquals
import org.junit.Test

class DeliverMessageTest {
    @Test
    fun test() {
        var deliverMessage = DeliverMessage()
        deliverMessage.printDescription()
        assertEquals(1, deliverMessage.deliverMessage(intArrayOf(1, 2, 3), arrayOf(intArrayOf(1, 2), intArrayOf(-1), intArrayOf(-1))))
        assertEquals(3, deliverMessage.deliverMessage(intArrayOf(1, 2, 1, 4, 5), arrayOf(intArrayOf(1, 2), intArrayOf(3, 4), intArrayOf(-1), intArrayOf(-1), intArrayOf(-1))))
    }
}
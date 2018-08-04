package com.algorithm.datastructure

import junit.framework.Assert.assertEquals
import org.junit.Test

class DeviceCapacityPairTest {
    @Test
    fun test() {
        val deviceCapacityPair = DeviceCapacityPair()
        deviceCapacityPair.printDescription()
        assertEquals(listOf(listOf(1, 5), listOf(1, 4), listOf(3, 4)), deviceCapacityPair.getAllPairs(listOf(listOf(1, 2), listOf(3, 4)), listOf(listOf(4, 1), listOf(5, 6)), 8))
    }
}
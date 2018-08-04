package com.algorithm.datastructure

import junit.framework.Assert.assertEquals
import org.junit.Test

class KClosestLocationsTest {
    @Test
    fun test() {
        val kClosestLocations = KClosestLocations()
        kClosestLocations.printDescription()
        assertEquals(listOf(listOf(1, 2), listOf(2, 2), listOf(3, 2), listOf(2, 4)),
                kClosestLocations.kClosestLocations(listOf(listOf(3, 9), listOf(1, 2), listOf(2, 2), listOf(3, 2), listOf(2, 4)), 4))
    }
}
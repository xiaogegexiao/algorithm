package com.algorithm.binary_search

import junit.framework.Assert.assertEquals
import org.junit.Test

class HeatersTest {
    @Test
    fun test() {
        var heaters = Heaters()
        heaters.printDescription()
        assertEquals(1, heaters.findRadius(intArrayOf(1, 2, 3), intArrayOf(2)))
        assertEquals(1, heaters.findRadius(intArrayOf(1, 2, 3, 4), intArrayOf(1, 4)))
    }
}
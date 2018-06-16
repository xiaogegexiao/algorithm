package com.algorithm.dynamic_programming

import junit.framework.Assert.assertEquals
import org.junit.Test

class PaintFenceDPTest {
    @Test
    fun test() {
        val paintFenceDP = PaintFenceDP()
        paintFenceDP.printDescription()
        assertEquals(66, paintFenceDP.numWays(4, 3))
        assertEquals(6, paintFenceDP.numWays(3, 2))
    }
}
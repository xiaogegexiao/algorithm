package com.algorithm.dynamic_programming

import junit.framework.Assert.assertEquals
import org.junit.Test

class MinimumWindowStringTest {
    @Test
    fun test() {
        val minimumWindowString = MinimumWindowString()
        minimumWindowString.printDescription()
        assertEquals("BANC", minimumWindowString.minWindow("ADOBECODEBANC", "ABC"))
    }
}
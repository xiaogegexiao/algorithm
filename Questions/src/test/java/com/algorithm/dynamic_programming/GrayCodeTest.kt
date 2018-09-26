package com.algorithm.dynamic_programming

import junit.framework.Assert.assertEquals
import org.junit.Test

class GrayCodeTest {
    @Test
    fun test() {
        val grayCode = GrayCode()
        grayCode.printDescription()
        assertEquals(listOf(0, 1, 3, 2), grayCode.grayCode(2))
        assertEquals(listOf(0), grayCode.grayCode(0))
    }
}
package com.algorithm.dynamic_programming

import junit.framework.Assert.assertEquals
import org.junit.Test

class UglyNumberIITest {
    @Test
    fun test() {
        val uglyNumberII = UglyNumberII()
        uglyNumberII.printDescription()
        assertEquals(12, uglyNumberII.nthUglyNumber(10))
    }
}
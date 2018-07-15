package com.algorithm.dynamic_programming

import junit.framework.Assert.assertEquals
import org.junit.Test

class ArithmeticSliceTest {
    @Test
    fun test() {
        val arithmeticSlice = ArithmeticSlice()
        arithmeticSlice.printDescription()
        assertEquals(3, arithmeticSlice.numberOfArithmeticSlices(intArrayOf(1, 2, 3, 4)))
        assertEquals(0, arithmeticSlice.numberOfArithmeticSlices(intArrayOf(1, 1, 2, 5, 7)))
    }
}
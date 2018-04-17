package com.algorithm.datastructure

import junit.framework.Assert.assertEquals
import org.junit.Test

class FourSumIITest {
    @Test
    fun test() {
        var fourSumII = FourSumII()
        fourSumII.printDescription()
        assertEquals(2, fourSumII.fourSumCount(intArrayOf(1, 2), intArrayOf(-2, -1), intArrayOf(-1, 2), intArrayOf(0, 2)))
    }
}
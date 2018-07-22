package com.algorithm.dynamic_programming

import junit.framework.Assert.assertEquals
import org.junit.Test

class RangeSumQuery2DImmutableTest {
    @Test
    fun test() {
        val rangeSumQuery2DImmutable = RangeSumQuery2DImmutable()
        rangeSumQuery2DImmutable.printDescription()
        rangeSumQuery2DImmutable.NumMatrix(arrayOf(intArrayOf(3, 0, 1, 4, 2), intArrayOf(5, 6, 3, 2, 1), intArrayOf(1, 2, 0, 1, 5), intArrayOf(4, 1, 0, 1, 7), intArrayOf(1, 0, 3, 0, 5)))
        assertEquals(8, rangeSumQuery2DImmutable.sumRegion(2, 1, 4, 3))
        assertEquals(11, rangeSumQuery2DImmutable.sumRegion(1, 1, 2, 2))
        assertEquals(12, rangeSumQuery2DImmutable.sumRegion(1, 2, 2, 4))
    }
}
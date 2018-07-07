package com.algorithm.dynamic_programming

import junit.framework.Assert.assertEquals
import org.junit.Test

class MinimumPathSumTest {

    @Test
    fun test() {
        val minimumPathSum = MinimumPathSum()
        minimumPathSum.printDescription()
        assertEquals(7, minimumPathSum.minPathSum(arrayOf(intArrayOf(1, 3, 1), intArrayOf(1, 5, 1), intArrayOf(4, 2, 1))))
    }
}
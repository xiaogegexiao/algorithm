package com.algorithm.dynamic_programming

import junit.framework.Assert.assertEquals
import org.junit.Test

class UniquePathIITest {
    @Test
    fun test() {
        val uniquePathII = UniquePathII()
        uniquePathII.printDescription()
        assertEquals(2, uniquePathII.uniquePathsWithObstacles(arrayOf(intArrayOf(0, 0, 0), intArrayOf(0, 1, 0), intArrayOf(0, 0, 0))))
    }
}
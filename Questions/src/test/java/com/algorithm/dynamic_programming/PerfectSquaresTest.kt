package com.algorithm.dynamic_programming

import junit.framework.Assert.assertEquals
import org.junit.Test

class PerfectSquaresTest {
    @Test
    fun test() {
        var perfectSquares = PerfectSquares()
        perfectSquares.printDescription()
        assertEquals(3, perfectSquares.numSquares(12))
        assertEquals(2, perfectSquares.numSquares(13))
    }
}
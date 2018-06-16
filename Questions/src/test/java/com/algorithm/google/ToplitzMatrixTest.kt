package com.algorithm.google

import junit.framework.Assert.assertEquals
import org.junit.Test

class ToplitzMatrixTest {
    @Test
    fun test() {
        val toplitzMatrix = ToplitzMatrix()
        toplitzMatrix.printDescription()
        assertEquals(true, toplitzMatrix.isToeplitzMatrix(arrayOf(intArrayOf(1, 2, 3, 4), intArrayOf(5, 1, 2, 3), intArrayOf(9, 5, 1, 2))))
        assertEquals(false, toplitzMatrix.isToeplitzMatrix(arrayOf(intArrayOf(1, 2), intArrayOf(2, 2))))
    }
}
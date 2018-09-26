package com.algorithm.array

import junit.framework.Assert.assertEquals
import org.junit.Test

class PascalTriangleIITest {
    @Test
    fun test() {
        val pascalTriangleII = PascalTriangleII()
        pascalTriangleII.printDescription()

        assertEquals(listOf(1, 3, 3, 1), pascalTriangleII.getRow(3))
    }
}
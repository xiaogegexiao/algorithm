package com.algorithm.twoPointers

import junit.framework.Assert.assertEquals
import org.junit.Test

class ThreeSumTest {
    @Test
    fun test() {
        var threeSum = ThreeSum()
        threeSum.printDescription()

        assertEquals(listOf(listOf(-1, -1, 2), listOf(-1, 0, 1)), threeSum.threeSum(intArrayOf(-1, 0, 1, 2, -1, -4)))
    }
}
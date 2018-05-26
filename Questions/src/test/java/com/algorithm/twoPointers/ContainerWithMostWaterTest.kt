package com.algorithm.twoPointers

import junit.framework.Assert.assertEquals
import org.junit.Test

class ContainerWithMostWaterTest {
    @Test
    fun test() {
        var containerWithMostWater = ContainerWithMostWater()
        containerWithMostWater.printDescription()
        assertEquals(24, containerWithMostWater.maxArea(intArrayOf(1, 3, 2, 5, 25, 24, 5)))
    }
}
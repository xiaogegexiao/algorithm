package com.algorithm.dynamic_programming

import junit.framework.Assert.assertEquals
import org.junit.Test

class MaxLenRepeatedSubarrayTest {
    @Test
    fun test() {
        var maxLenRepeatedSubarray = MaxLenRepeatedSubarray()
        maxLenRepeatedSubarray.printDescription()
        assertEquals(3, maxLenRepeatedSubarray.findLength(intArrayOf(1, 2, 3, 2, 1), intArrayOf(3, 2, 1, 4, 7)))
        assertEquals(5, maxLenRepeatedSubarray.findLength(intArrayOf(1, 4, 6, 78, 98, 0, 0, 0), intArrayOf(0, 0, 0, 1, 4, 6, 78, 98)))
    }
}
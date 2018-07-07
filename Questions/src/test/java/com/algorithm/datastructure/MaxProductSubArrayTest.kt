package com.algorithm.datastructure

import com.algorithm.dynamic_programming.MaxProductSubArray
import junit.framework.Assert.assertEquals
import org.junit.Test

class MaxProductSubArrayTest {
    @Test
    fun test() {
        val maxProductSubarray = MaxProductSubArray()
        maxProductSubarray.printDescription()
        assertEquals(6, maxProductSubarray.maxProduct(intArrayOf(2, 3, -2, 4)))
        assertEquals(0, maxProductSubarray.maxProduct(intArrayOf(-2, 0, -1)))
    }
}
package com.algorithm.twoPointers

import org.junit.Assert
import org.junit.Test

class TwoSumIITest {
    @Test
    fun test() {
        val twoSumII = TwoSumII()
        twoSumII.printDescription()
        Assert.assertArrayEquals(intArrayOf(1, 2), twoSumII.twoSum(intArrayOf(2, 7, 11, 15), 9))
    }
}
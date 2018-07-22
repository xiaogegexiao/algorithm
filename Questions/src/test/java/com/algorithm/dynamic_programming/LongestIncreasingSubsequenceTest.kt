package com.algorithm.dynamic_programming

import junit.framework.Assert.assertEquals
import org.junit.Test

class LongestIncreasingSubsequenceTest {
    @Test
    fun test() {
        val longestIncreasingSubsequence = LongestIncreasingSubsequence()
        longestIncreasingSubsequence.printDescription()
        assertEquals(4, longestIncreasingSubsequence.lengthOfLIS(intArrayOf(10, 9, 2, 5, 3, 7, 101, 18)))
    }
}
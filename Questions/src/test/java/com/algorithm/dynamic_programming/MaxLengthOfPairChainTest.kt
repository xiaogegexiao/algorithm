package com.algorithm.dynamic_programming

import junit.framework.Assert.assertEquals
import org.junit.Test

class MaxLengthOfPairChainTest {
    @Test
    fun test() {
        val maxLenPairChain = MaxLengthOfPairChain()
        maxLenPairChain.printDescription()
        assertEquals(2, maxLenPairChain.findLongestChain(arrayOf(intArrayOf(1, 2), intArrayOf(2, 3), intArrayOf(3, 4))))
    }
}
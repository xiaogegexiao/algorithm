package com.algorithm.datastructure

import junit.framework.Assert.assertEquals
import org.junit.Test

class KDiffPairInArrayTest {
    @Test
    fun test() {
        val kDiffPairInArray = KDiffPairInArray()
        kDiffPairInArray.printDescription()
        assertEquals(2, kDiffPairInArray.findPairs(intArrayOf(3, 1, 4, 1, 5), 2))
        assertEquals(4, kDiffPairInArray.findPairs(intArrayOf(1, 2, 3, 4, 5), 1))
        assertEquals(1, kDiffPairInArray.findPairs(intArrayOf(1, 3, 1, 5, 4), 0))
    }
}
package com.algorithm.twoPointers

import junit.framework.Assert.assertEquals
import org.junit.Test

class MostProfitAssigningWorkTest {
    @Test
    fun test() {
        var mostProfitAssigningWork = MostProfitAssigningWork()
        mostProfitAssigningWork.printDescription()
        assertEquals(100, mostProfitAssigningWork.maxProfitAssignment(intArrayOf(2, 4, 6, 8, 10), intArrayOf(10, 20, 30, 40, 50), intArrayOf(4, 5, 6, 7)))
    }
}
package com.algorithm.datastructure

import junit.framework.Assert.assertEquals
import org.junit.Test

class RangeSumQueryTest {
    @Test
    fun test() {
        val rangeSumQuery = RangeSumQuery()
        rangeSumQuery.printDescription()
        rangeSumQuery.numArray(intArrayOf(0, 9, 5, 7, 3))
        assertEquals(3, rangeSumQuery.sumRange(4, 4))
        assertEquals(15, rangeSumQuery.sumRange(2, 4))
        assertEquals(7, rangeSumQuery.sumRange(3, 3))
        rangeSumQuery.update(4, 5)
        rangeSumQuery.update(1, 7)
        rangeSumQuery.update(0, 8)
        assertEquals(12, rangeSumQuery.sumRange(1, 2))
        rangeSumQuery.update(1, 9)
        assertEquals(5, rangeSumQuery.sumRange(4, 4))
        rangeSumQuery.update(3, 4)

    }
}
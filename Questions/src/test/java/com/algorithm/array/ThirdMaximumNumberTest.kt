package com.algorithm.array

import junit.framework.Assert.assertEquals
import org.junit.Test

class ThirdMaximumNumberTest {
    @Test
    fun test() {
        val thirdMaximumNumber = ThirdMaximumNumber()
        thirdMaximumNumber.printDescription()
        assertEquals(1, thirdMaximumNumber.thirdMax(intArrayOf(3, 2, 1)))
        assertEquals(2, thirdMaximumNumber.thirdMax(intArrayOf(1, 2)))
        assertEquals(1, thirdMaximumNumber.thirdMax(intArrayOf(2, 2, 3, 1)))
    }
}
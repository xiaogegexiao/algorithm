package com.algorithm.array

import junit.framework.Assert.assertEquals
import org.junit.Test

class MajorityElementTest {
    @Test
    fun test() {
        var majorityElement = MajorityElement()
        majorityElement.printDescription()
        assertEquals(1, majorityElement.majorityElement(intArrayOf(1)))

        assertEquals(3, majorityElement.majorityElement(intArrayOf(3, 2, 3, 4, 2, 3, 3)))
    }
}
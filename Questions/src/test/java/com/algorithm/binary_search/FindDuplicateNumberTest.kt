package com.algorithm.binary_search

import junit.framework.Assert.assertEquals
import org.junit.Test

class FindDuplicateNumberTest {
    @Test
    fun test() {
        var findDuplicateNumber = FindDuplicateNumber()
        findDuplicateNumber.printDescription()
        assertEquals(5, findDuplicateNumber.findDuplicate(intArrayOf(5, 5, 4, 3, 2, 1)))
        assertEquals(4, findDuplicateNumber.findDuplicate(intArrayOf(5, 4, 4, 3, 2, 1)))
    }
}
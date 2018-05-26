package com.algorithm.twoPointers

import junit.framework.Assert.assertEquals
import org.junit.Test

class RemoveDuplicateFromSortedArrayTest {
    @Test
    fun test() {
        var removeDuplicateFromSortedArray = RemoveDuplicateFromSortedArray()
        removeDuplicateFromSortedArray.printDescription()

        assertEquals(5, removeDuplicateFromSortedArray.removeDuplicates(intArrayOf(1, 1, 1, 2, 2, 3)))
    }
}
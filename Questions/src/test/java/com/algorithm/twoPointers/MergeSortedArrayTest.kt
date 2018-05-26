package com.algorithm.twoPointers

import org.junit.Assert.assertArrayEquals
import org.junit.Test

class MergeSortedArrayTest {
    @Test
    fun test() {
        var mergeSortedArray = MergeSortedArray()
        mergeSortedArray.printDescription()
        val nums1 = intArrayOf(1, 2, 3, 0, 0, 0)
        mergeSortedArray.merge(nums1, 3, intArrayOf(2, 5, 6), 3)
        assertArrayEquals(intArrayOf(1, 2, 2, 3, 5, 6), nums1)
    }
}
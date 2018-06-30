package com.algorithm.datastructure

import junit.framework.Assert.assertEquals
import org.junit.Test

class MedianOfKSortedArrayByBinarySearchTest {
    @Test
    fun test() {
        val medianOfKSortedArrayByBinarySearch = MedianOfKSortedArrayByBinarySearch()
        medianOfKSortedArrayByBinarySearch.printDescription()
        assertEquals(5.5, medianOfKSortedArrayByBinarySearch.findMedian(arrayOf(intArrayOf(1), intArrayOf(3), intArrayOf(8), intArrayOf(9))))
    }
}
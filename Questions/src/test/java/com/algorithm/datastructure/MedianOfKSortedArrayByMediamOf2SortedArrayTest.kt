package com.algorithm.datastructure

import junit.framework.Assert.assertEquals
import org.junit.Test

class MedianOfKSortedArrayByMediamOf2SortedArrayTest {
    @Test
    fun test() {
        val medianOfKSortedArrayByMediamOf2SortedArray = MedianOfKSortedArrayByMediamOf2SortedArray()
        medianOfKSortedArrayByMediamOf2SortedArray.printDescription()
        assertEquals(5.5, medianOfKSortedArrayByMediamOf2SortedArray.findMedian(arrayOf(intArrayOf(1), intArrayOf(3), intArrayOf(8), intArrayOf(9))))
    }
}
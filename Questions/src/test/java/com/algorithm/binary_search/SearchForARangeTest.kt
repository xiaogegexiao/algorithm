package com.algorithm.binary_search

import org.junit.Assert.assertArrayEquals
import org.junit.Test

class SearchForARangeTest {
    @Test
    fun test() {
        var searchForARange = SearchForARange()
        searchForARange.printDescription()
        assertArrayEquals(intArrayOf(3, 4), searchForARange.searchRange(intArrayOf(5, 7, 7, 8, 8, 10), 8))
        assertArrayEquals(intArrayOf(-1, -1), searchForARange.searchRange(intArrayOf(5, 7, 7, 8, 8, 10), 6))
    }
}
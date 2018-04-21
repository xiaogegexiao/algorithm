package com.algorithm.binary_search

import junit.framework.Assert.assertEquals
import org.junit.Test

class SearchIn2DMatrixTest {
    @Test
    fun test() {
        var searchIn2DMatrix = SearchIn2DMatrix()
        searchIn2DMatrix.printDescription()

        var twoDMatrix = arrayOf(
                intArrayOf(1, 4, 7, 11, 15),
                intArrayOf(2, 5, 8, 12, 19),
                intArrayOf(3, 6, 9, 16, 22),
                intArrayOf(10, 13, 14, 17, 24),
                intArrayOf(18, 21, 23, 26, 30)
        )
        assertEquals(true, searchIn2DMatrix.searchMatrix(twoDMatrix, 5))
        assertEquals(false, searchIn2DMatrix.searchMatrix(twoDMatrix, 20))
    }
}
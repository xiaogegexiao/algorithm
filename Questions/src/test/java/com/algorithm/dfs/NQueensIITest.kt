package com.algorithm.dfs

import junit.framework.Assert.assertEquals
import org.junit.Test

class NQueensIITest {
    @Test
    fun test() {
        var nQueensII = NQueensII()
        nQueensII.printDescription()
        assertEquals(2, nQueensII.totalNQueens(4))
    }
}
package com.algorithm.dfs

import junit.framework.Assert.assertEquals
import org.junit.Test

class PaintFenceDFSTest {
    @Test
    fun test() {
        val paintFenceDFS = PaintFenceDFS()
        paintFenceDFS.printDescription()
        assertEquals(66, paintFenceDFS.numWays(4, 3))
        assertEquals(6, paintFenceDFS.numWays(3, 2))
    }
}
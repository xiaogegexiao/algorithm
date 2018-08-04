package com.algorithm.datastructure

import junit.framework.Assert.assertEquals
import org.junit.Test

class KDistinceStringTest {
    @Test
    fun test() {
        val kDistinctString = KDistinctString()
        kDistinctString.printDescription()
        assertEquals(4, kDistinctString.countKdistinctStrings("abcdebba", 3))
        assertEquals(1, kDistinctString.countKdistinctStrings("abcbba", 3))
        assertEquals(9, kDistinctString.countKdistinctStrings("abcdefgehijkl", 4))
    }
}
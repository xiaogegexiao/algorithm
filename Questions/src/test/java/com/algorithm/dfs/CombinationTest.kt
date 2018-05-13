package com.algorithm.dfs

import org.junit.Assert.assertEquals
import org.junit.Test

class CombinationTest {
    @Test
    fun test() {
        var combinations = Combinations()
        combinations.printDescription()
        assertEquals(setOf(listOf(2, 4), listOf(3, 4), listOf(2, 3), listOf(1, 2), listOf(1, 3), listOf(1, 4)), combinations.combine(4, 2))
    }
}
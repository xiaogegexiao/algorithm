package com.algorithm.dfs

import junit.framework.Assert.assertEquals
import org.junit.Test

class SplitStringTest {
    @Test
    fun test() {
        var splitString = SplitString()
        splitString.printDescription()
        assertEquals(setOf(listOf("1", "2", "3"), listOf("12", "3"), listOf("1", "23")), splitString.splitString("123"))
    }
}
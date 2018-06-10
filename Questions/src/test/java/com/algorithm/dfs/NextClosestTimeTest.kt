package com.algorithm.dfs

import junit.framework.Assert.assertEquals
import org.junit.Test

class NextClosestTimeTest {
    @Test
    fun test() {
        var nextClosestTime = NextClosestTime()
        nextClosestTime.printDescription()
        assertEquals("19:39", nextClosestTime.nextClosestTime("19:34"))
        assertEquals("22:22", nextClosestTime.nextClosestTime("23:59"))
    }
}
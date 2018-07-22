package com.algorithm.dynamic_programming

import junit.framework.Assert.assertEquals
import org.junit.Test

class HouseRobberIITest {
    @Test
    fun test() {
        val houseRobberII = HouseRobberII()
        houseRobberII.printDescription()
        assertEquals(3, houseRobberII.rob(intArrayOf(2, 3, 2)))
        assertEquals(4, houseRobberII.rob(intArrayOf(1, 2, 3, 1)))
    }
}
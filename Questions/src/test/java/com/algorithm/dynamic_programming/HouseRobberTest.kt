package com.algorithm.dynamic_programming

import junit.framework.Assert.assertEquals
import org.junit.Test

class HouseRobberTest {
    @Test
    fun test() {
        val houseRobber = HouseRobber()
        houseRobber.printDescription()
        assertEquals(4, houseRobber.rob(intArrayOf(1, 2, 3, 1)))
        assertEquals(12, houseRobber.rob(intArrayOf(2, 7, 9, 3, 1)))
    }
}
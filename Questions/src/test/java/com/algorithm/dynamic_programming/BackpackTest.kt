package com.algorithm.dynamic_programming

import org.junit.Test

import junit.framework.TestCase.assertEquals

class BackpackTest {
    @Test
    fun test() {
        val backpack = Backpack()
        backpack.printDescription()
        assertEquals(10, backpack.backPack(11, intArrayOf(2, 3, 5, 7)))
    }
}

package com.algorithm.binary_search

import junit.framework.Assert.assertEquals
import org.junit.Test

class ArrangeCoinsTest {
    @Test
    fun test() {
        var arrangeCoins = ArrangeCoins()
        arrangeCoins.printDescription()
        assertEquals(2, arrangeCoins.arrangeCoins(5))
        assertEquals(3, arrangeCoins.arrangeCoins(8))
    }
}
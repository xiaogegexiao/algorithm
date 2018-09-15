package com.algorithm.dynamic_programming

import junit.framework.Assert.assertEquals
import org.junit.Test

class CountPrimesTest {
    @Test
    fun test() {
        val countPrimes = CountPrimes()
        countPrimes.printDescription()
        assertEquals(4, countPrimes.countPrimes(10))
    }
}
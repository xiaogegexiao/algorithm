package com.algorithm.binary_search

import junit.framework.Assert.assertEquals
import org.junit.Test

class SqrtTest {
    @Test
    fun test() {
        var sqrt = Sqrt()
        sqrt.printDescription()
        assertEquals(2, sqrt.mySqrt(4))
        assertEquals(2, sqrt.mySqrt(8))
    }
}
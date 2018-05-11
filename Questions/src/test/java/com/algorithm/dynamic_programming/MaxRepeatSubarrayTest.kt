package com.algorithm.dynamic_programming

import junit.framework.Assert.assertEquals
import org.junit.Test

class MaxRepeatSubarrayTest {
    @Test
    fun test() {
        var maxRepeatSubarray  = MaxRepeatSubarray()
        maxRepeatSubarray.printDescription()
        assertEquals(15, maxRepeatSubarray.maxRepeatSubarrayLen("ababababababababa"))
    }
}
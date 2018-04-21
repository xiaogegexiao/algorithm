package com.algorithm.sort

import junit.framework.Assert.assertEquals
import org.junit.Test

class BigBusinessTest {
    @Test
    fun test() {
        var bigBusiness = BigBusiness()
        bigBusiness.printDescription()
        assertEquals(4, bigBusiness.bigBusiness(intArrayOf(3, 1, 5), intArrayOf(4, 3, 100), 1))
        assertEquals(108, bigBusiness.bigBusiness(intArrayOf(3, 1, 5), intArrayOf(4, 3, 100), 10))
    }
}
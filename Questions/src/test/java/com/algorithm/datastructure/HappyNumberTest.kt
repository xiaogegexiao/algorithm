package com.algorithm.datastructure

import junit.framework.Assert.assertEquals
import org.junit.Test

class HappyNumberTest {
    @Test
    fun test() {
        val happyNumber = HappyNumber()
        happyNumber.printDescription()
        assertEquals(true, happyNumber.isHappy(19))
    }
}
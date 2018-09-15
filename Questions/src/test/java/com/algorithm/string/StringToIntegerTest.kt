package com.algorithm.string

import junit.framework.Assert.assertEquals
import org.junit.Test

class StringToIntegerTest {
    @Test
    fun test() {
        val stringToInteger = StringToInteger()
        stringToInteger.printDescription()
        assertEquals(42, stringToInteger.myAtoi("42"))
        assertEquals(-42, stringToInteger.myAtoi("   -42"))
        assertEquals(4193, stringToInteger.myAtoi("4193 with words"))
        assertEquals(0, stringToInteger.myAtoi("words and 987"))
        assertEquals(-2147483648, stringToInteger.myAtoi("-91283472332"))
    }
}
package com.algorithm.dynamic_programming

import junit.framework.Assert.assertEquals
import org.junit.Test

class MinASCIIDeleteSumFor2StringsTest {
    @Test
    fun test() {
        val minASCIIDeleteSumFor2Strings = MinASCIIDeleteSumFor2Strings()
        minASCIIDeleteSumFor2Strings.printDescription()
        assertEquals(231, minASCIIDeleteSumFor2Strings.minimumDeleteSum("sea", "eat"))
        assertEquals(403, minASCIIDeleteSumFor2Strings.minimumDeleteSum("delete", "leet"))
    }
}
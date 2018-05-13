package com.algorithm.dfs

import junit.framework.Assert.assertEquals
import org.junit.Test

class FindMissingNumberTest {
    @Test
    fun test() {
        val findRightTermsNumber = FindMissingNumber()
        findRightTermsNumber.printDescription()
        assertEquals(17, findRightTermsNumber.findMissing2(20, "19201234567891011121314151618"))
    }
}
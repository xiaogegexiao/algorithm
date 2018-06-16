package com.algorithm.google

import junit.framework.Assert.assertEquals
import org.junit.Test

class AddStringsTest {
    @Test
    fun test() {
        val addSrings = AddStrings()
        addSrings.printDescription()
        assertEquals("168", addSrings.addStrings("123", "45"))

        assertEquals("12316723663245283607488656823601", addSrings.addStrings("12316723658712635786123784687123", "4532647821364872136478"))
    }
}
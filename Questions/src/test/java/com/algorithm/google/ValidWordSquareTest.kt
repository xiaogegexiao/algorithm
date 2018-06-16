package com.algorithm.google

import junit.framework.Assert.assertEquals
import org.junit.Test

class ValidWordSquareTest {
    @Test
    fun test() {
        val validWordSquare = ValidWordSquare()
        validWordSquare.printDescription()
        assertEquals(true, validWordSquare.validWordSquare(arrayOf("abcd",
                "bnrt",
                "crmy",
                "dtye")))

        assertEquals(true, validWordSquare.validWordSquare(arrayOf("abcd",
                "bnrt",
                "crm",
                "dt")))

        assertEquals(false, validWordSquare.validWordSquare(arrayOf("ball",
                "area",
                "read",
                "lady")))
    }
}
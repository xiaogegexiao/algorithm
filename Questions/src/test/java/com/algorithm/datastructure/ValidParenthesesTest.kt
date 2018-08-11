package com.algorithm.datastructure

import junit.framework.Assert.assertEquals
import org.junit.Test

class ValidParenthesesTest {
    @Test
    fun test() {
        val validateParentheses = ValidateParentheses()
        validateParentheses.printDescription()
        assertEquals(true, validateParentheses.isValid("()"))
        assertEquals(true, validateParentheses.isValid("()[]{}"))
        assertEquals(false, validateParentheses.isValid("(]"))
        assertEquals(false, validateParentheses.isValid("([)]"))
        assertEquals(true, validateParentheses.isValid("{[]}"))
    }
}
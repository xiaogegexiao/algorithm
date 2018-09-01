package com.algorithm.twoPointers

import junit.framework.Assert.assertEquals
import org.junit.Test

class ValidPalindromeTest {
    @Test
    fun test() {
        val validPalindrome = ValidPalindrome()
        validPalindrome.printDescription()
        assertEquals(true, validPalindrome.isPalindrome("A man, a plan, a canal: Panama"))
        assertEquals(false, validPalindrome.isPalindrome("race a car"))
    }
}
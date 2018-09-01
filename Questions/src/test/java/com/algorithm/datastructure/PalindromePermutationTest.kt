package com.algorithm.datastructure

import junit.framework.Assert.assertEquals
import org.junit.Test

class PalindromePermutationTest {
    @Test
    fun test() {
        val palindromePermutation = PalindromePermutation()
        palindromePermutation.printDescription()
        assertEquals(false, palindromePermutation.canPermutePalindrome("code"))
        assertEquals(true, palindromePermutation.canPermutePalindrome("aab"))
        assertEquals(true, palindromePermutation.canPermutePalindrome("carerac"))
    }
}
package com.algorithm.datastructure

import com.algorithm.dynamic_programming.LongestPalindromicSubsequence
import junit.framework.Assert.assertEquals
import org.junit.Test

class LongestPalindromicSubsequenceTest {
    @Test
    fun test() {
        val longestPalindromicSubsequence = LongestPalindromicSubsequence()
        longestPalindromicSubsequence.printDescription()
        assertEquals(4, longestPalindromicSubsequence.longestPalindromeSubseq("bbbab"))
        assertEquals(2, longestPalindromicSubsequence.longestPalindromeSubseq("cbbd"))
    }
}
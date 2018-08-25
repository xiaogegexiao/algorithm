package com.algorithm.dynamic_programming

import junit.framework.Assert.assertEquals
import org.junit.Test

class WordBreakTest {
    @Test
    fun test() {
        val wordBreak = WordBreak()
        wordBreak.printDescription()
        assertEquals(true, wordBreak.wordBreak("leetcode", listOf("leet", "code")))
        assertEquals(true, wordBreak.wordBreak("applepenapple", listOf("apple", "pen")))
        assertEquals(false, wordBreak.wordBreak("catsandog", listOf("cats", "dog", "sand", "and", "cat")))
    }
}
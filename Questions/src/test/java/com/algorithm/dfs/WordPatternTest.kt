package com.algorithm.dfs

import junit.framework.Assert.assertEquals
import org.junit.Test

class WordPatternTest {
    @Test
    fun test() {
        val wordPattern = WordPattern()
        wordPattern.printDescription()
        assertEquals(true, wordPattern.wordPattern("abba", "dog cat cat dog"))
        assertEquals(false, wordPattern.wordPattern("abba", "dog cat cat fish"))
        assertEquals(false, wordPattern.wordPattern("aaaa", "dog cat cat dog"))
        assertEquals(false, wordPattern.wordPattern("abba", "dog dog dog dog"))
    }
}
package com.algorithm.datastructure

import junit.framework.Assert.assertEquals
import org.junit.Test

class ReplaceWordsTest {
    @Test
    fun test() {
        val replaceWords = ReplaceWords()
        replaceWords.printDescription()
        assertEquals("the cat was rat by the bat", replaceWords.replaceWords(listOf("cat", "bat", "rat"), "the cattle was rattled by the battery"))
    }
}
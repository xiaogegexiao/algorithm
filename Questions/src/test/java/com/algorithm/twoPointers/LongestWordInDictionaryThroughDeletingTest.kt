package com.algorithm.twoPointers

import junit.framework.Assert.assertEquals
import org.junit.Test

class LongestWordInDictionaryThroughDeletingTest {
    @Test
    fun test() {
        var longestWordInDictionaryThroughDeleting = LongestWordInDictionaryThroughDeleting()
        longestWordInDictionaryThroughDeleting.printDescription()
        assertEquals("apple", longestWordInDictionaryThroughDeleting.findLongestWord("abpcplea", listOf("ale", "apple", "monkey", "plea")))
        assertEquals("a", longestWordInDictionaryThroughDeleting.findLongestWord("abpcplea", listOf("a", "b", "c")))
    }
}
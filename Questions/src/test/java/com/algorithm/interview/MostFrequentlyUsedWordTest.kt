package com.algorithm.interview

import junit.framework.Assert.assertEquals
import org.junit.Test

class MostFrequentlyUsedWordTest {
    @Test
fun test() {
        var mostFrequentlyUsedWord = MostFrequentlyUsedWord()
        assertEquals(setOf("cheese", "s"), mostFrequentlyUsedWord.mostFrequentlyUsedWord("Jack and Jill went to the market to buy bread and cheese. Cheese is Jack's and Jill's favorite food", arrayOf("and", "he", "the", "to", "is", "Jack", "Jill")))
    }
}
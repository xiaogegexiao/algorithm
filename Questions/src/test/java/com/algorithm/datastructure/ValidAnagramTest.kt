package com.algorithm.datastructure

import junit.framework.Assert.assertEquals
import org.junit.Test

class ValidAnagramTest {
    @Test
    fun test() {
        val validAnagram = ValidAnagram()
        validAnagram.printDescription()
        assertEquals(true, validAnagram.isAnagram("anagram", "nagaram"))
        assertEquals(false, validAnagram.isAnagram("rat", "car"))
    }
}
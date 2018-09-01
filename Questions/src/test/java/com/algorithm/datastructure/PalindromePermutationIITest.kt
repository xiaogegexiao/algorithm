package com.algorithm.datastructure

import org.junit.Assert.assertArrayEquals
import org.junit.Test

class PalindromePermutationIITest {
    @Test
    fun test() {
        val palindromePermutationII = PalindromePermutationII()
        palindromePermutationII.printDescription()
        assertArrayEquals(arrayOf("abba", "baab"), palindromePermutationII.generatePalindromes("aabb").toTypedArray())
        assertArrayEquals(emptyArray<String>(), palindromePermutationII.generatePalindromes("abc").toTypedArray())
    }
}
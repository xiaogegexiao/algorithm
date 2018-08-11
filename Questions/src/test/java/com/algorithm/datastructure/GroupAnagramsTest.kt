package com.algorithm.datastructure

import org.junit.Assert.assertEquals
import org.junit.Test

class GroupAnagramsTest {
    @Test
    fun test() {
        val groupAnagrams = GroupAnagrams()
        groupAnagrams.printDescription()
        assertEquals(listOf(listOf("ate", "eat", "tea"),
                listOf("nat", "tan"),
                listOf("bat")), groupAnagrams.groupAnagrams(arrayOf("eat", "tea", "tan", "ate", "nat", "bat"
        )))
    }
}
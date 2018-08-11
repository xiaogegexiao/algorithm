package com.algorithm.datastructure

import junit.framework.Assert.assertEquals
import org.junit.Test

class SortCharactersByFrequencyTest {
    @Test
    fun test() {

        val sortCharactersByFrequency = SortCharactersByFrequency()
        sortCharactersByFrequency.printDescription()
        assertEquals("eert", sortCharactersByFrequency.frequencySort("tree"))
        assertEquals("aaaccc", sortCharactersByFrequency.frequencySort("cccaaa"))
        assertEquals("bbAa", sortCharactersByFrequency.frequencySort("Aabb"))
    }
}
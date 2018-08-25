package com.algorithm.datastructure

import junit.framework.Assert.assertEquals
import org.junit.Test

class RandomSetTest {
    @Test
    fun test() {
        val randomSet = RandomSet()
        randomSet.printDescription()
        assertEquals(true, randomSet.insert(0))
        assertEquals(true, randomSet.remove(0))
        assertEquals(true, randomSet.insert(-1))
        assertEquals(false, randomSet.remove(0))
        assertEquals(-1, randomSet.getRandom())
        assertEquals(-1, randomSet.getRandom())
        assertEquals(-1, randomSet.getRandom())
        assertEquals(-1, randomSet.getRandom())
        assertEquals(-1, randomSet.getRandom())
        assertEquals(-1, randomSet.getRandom())
        assertEquals(-1, randomSet.getRandom())
    }
}
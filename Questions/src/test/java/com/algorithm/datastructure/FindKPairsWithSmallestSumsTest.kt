package com.algorithm.datastructure

import junit.framework.Assert.assertEquals
import org.junit.Test

class FindKPairsWithSmallestSumsTest {
    @Test
    fun test() {
        val findKPairsWithSmallestSums = FindKPairsWithSmallestSums()
        findKPairsWithSmallestSums.printDescription()
        assertEquals(
                listOf(
                        intArrayOf(1, 2),
                        intArrayOf(1, 4),
                        intArrayOf(1, 6)
                ),
                findKPairsWithSmallestSums.kSmallestPairs(
                        intArrayOf(1, 7, 11),
                        intArrayOf(2, 4, 6),
                        3)
        )

        assertEquals(
                listOf(
                        intArrayOf(1, 1),
                        intArrayOf(1, 1)
                ),
                findKPairsWithSmallestSums.kSmallestPairs(
                        intArrayOf(1, 1, 2),
                        intArrayOf(1, 2, 3),
                        2)
        )
    }
}
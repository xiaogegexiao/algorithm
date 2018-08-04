package com.algorithm.binary_tree

import junit.framework.Assert.assertEquals
import org.junit.Test

class BSTandLCATest {
    @Test
    fun test() {
        val bsTandLCA = BSTandLCA()
        bsTandLCA.printDescription()
        val ints = intArrayOf(2, 3, 4, 1, 5, 6, 7, 8)

        // for complete tree
        assertEquals(3, bsTandLCA.bstDistance(ints, 4, 5, BSTandLCA.TreeType.CBT))
        assertEquals(1, bsTandLCA.bstDistance(ints, 4, 6, BSTandLCA.TreeType.CBT))
        assertEquals(2, bsTandLCA.bstDistance(ints, 3, 4, BSTandLCA.TreeType.CBT))
        assertEquals(1, bsTandLCA.bstDistance(ints, 2, 4, BSTandLCA.TreeType.CBT))
        assertEquals(3, bsTandLCA.bstDistance(ints, 8, 5, BSTandLCA.TreeType.CBT))

        // for bst tree
        assertEquals(1, bsTandLCA.bstDistance(ints, 4, 5, BSTandLCA.TreeType.BST))
        assertEquals(2, bsTandLCA.bstDistance(ints, 4, 6, BSTandLCA.TreeType.BST))
        assertEquals(1, bsTandLCA.bstDistance(ints, 3, 4, BSTandLCA.TreeType.BST))
        assertEquals(2, bsTandLCA.bstDistance(ints, 2, 4, BSTandLCA.TreeType.BST))
        assertEquals(3, bsTandLCA.bstDistance(ints, 8, 5, BSTandLCA.TreeType.BST))
    }
}
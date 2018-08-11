package com.algorithm.dynamic_programming

import org.junit.Assert.assertArrayEquals
import org.junit.Test

class ProductOfArrayExceptSelfTest {
    @Test
    fun test() {
        val productOfArrayExceptSelf = ProductOfArrayExceptSelf()
        productOfArrayExceptSelf.printDescription()
        assertArrayEquals(intArrayOf(24, 12, 8, 6), productOfArrayExceptSelf.productExceptSelf(intArrayOf(1, 2, 3, 4)))
    }
}
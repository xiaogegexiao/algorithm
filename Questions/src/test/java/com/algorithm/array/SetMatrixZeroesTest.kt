package com.algorithm.array

import org.junit.Assert
import org.junit.Test

class SetMatrixZeroesTest {
    @Test
    fun test() {
        val setMatrixZeroes = SetMatrixZeroes()
        setMatrixZeroes.printDescription()

        val mat1 = arrayOf(
                intArrayOf(1, 1, 1),
                intArrayOf(1, 0, 1),
                intArrayOf(1, 1, 1))
        setMatrixZeroes.setZeroes(mat1)
        Assert.assertArrayEquals(arrayOf(
                intArrayOf(1, 0, 1),
                intArrayOf(0, 0, 0),
                intArrayOf(1, 0, 1)
        ), mat1)

        val mat2 = arrayOf(
                intArrayOf(0, 1, 2, 0),
                intArrayOf(3, 4, 5, 2),
                intArrayOf(1, 3, 1, 5))
        setMatrixZeroes.setZeroes(mat2)
        Assert.assertArrayEquals(arrayOf(
                intArrayOf(0, 0, 0, 0),
                intArrayOf(0, 4, 5, 0),
                intArrayOf(0, 3, 1, 0)
        ), mat2)
    }
}
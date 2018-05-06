package com.algorithm.bfs

import org.junit.Assert.assertArrayEquals
import org.junit.Test

class Matrix01Test {
    @Test
fun test() {
        var matrix01 = Matrix01()
        matrix01.printDescription()
        assertArrayEquals(arrayOf(
                intArrayOf(0, 0, 0),
                intArrayOf(0, 1, 0),
                intArrayOf(0, 0, 0)),
                matrix01.updateMatrix(arrayOf(
                        intArrayOf(0, 0, 0),
                        intArrayOf(0, 1, 0),
                        intArrayOf(0, 0, 0))))

        assertArrayEquals(arrayOf(
                intArrayOf(0, 0, 0),
                intArrayOf(0, 1, 0),
                intArrayOf(1, 2, 1)),
                matrix01.updateMatrix(arrayOf(
                        intArrayOf(0, 0, 0),
                        intArrayOf(0, 1, 0),
                        intArrayOf(1, 1, 1))))
    }
}
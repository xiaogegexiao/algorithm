package com.algorithm.bfs

import org.junit.Assert
import org.junit.Test

class MineSweeperTest {
    @Test
    fun test() {
        val mineSweeper = MineSweeper()
        mineSweeper.printDescription()
        Assert.assertArrayEquals(arrayOf(
                charArrayOf('B', '1', 'E', '1', 'B'),
                charArrayOf('B', '1', 'M', '1', 'B'),
                charArrayOf('B', '1', '1', '1', 'B'),
                charArrayOf('B', 'B', 'B', 'B', 'B')
        ), mineSweeper.updateBoard(arrayOf(
                charArrayOf('E', 'E', 'E', 'E', 'E'),
                charArrayOf('E', 'E', 'M', 'E', 'E'),
                charArrayOf('E', 'E', 'E', 'E', 'E'),
                charArrayOf('E', 'E', 'E', 'E', 'E')
        ), intArrayOf(3, 0)))

        Assert.assertArrayEquals(arrayOf(
                charArrayOf('B', '1', 'E', '1', 'B'),
                charArrayOf('B', '1', 'X', '1', 'B'),
                charArrayOf('B', '1', '1', '1', 'B'),
                charArrayOf('B', 'B', 'B', 'B', 'B')
        ), mineSweeper.updateBoard(arrayOf(
                charArrayOf('B', '1', 'E', '1', 'B'),
                charArrayOf('B', '1', 'M', '1', 'B'),
                charArrayOf('B', '1', '1', '1', 'B'),
                charArrayOf('B', 'B', 'B', 'B', 'B')
        ), intArrayOf(1, 2)))
    }
}
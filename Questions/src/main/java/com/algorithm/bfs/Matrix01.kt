package com.algorithm.bfs

import com.algorithm.AlgorithmQuestion
import java.util.*


class Matrix01 : AlgorithmQuestion {
    override fun printDescription() {
        System.out.println("Given a matrix consists of 0 and 1, find the distance of the nearest 0 for each cell.\n" +
                "\n" +
                "The distance between two adjacent cells is 1.\n" +
                "Example 1: \n" +
                "Input:\n" +
                "\n" +
                "0 0 0\n" +
                "0 1 0\n" +
                "0 0 0\n" +
                "Output:\n" +
                "0 0 0\n" +
                "0 1 0\n" +
                "0 0 0\n" +
                "Example 2: \n" +
                "Input:\n" +
                "\n" +
                "0 0 0\n" +
                "0 1 0\n" +
                "1 1 1\n" +
                "Output:\n" +
                "0 0 0\n" +
                "0 1 0\n" +
                "1 2 1\n" +
                "Note:\n" +
                "The number of elements of the given matrix will not exceed 10,000.\n" +
                "There are at least one 0 in the given matrix.\n" +
                "The cells are adjacent in only four directions: up, down, left and right.\n")
    }

    var xDelta = intArrayOf(1, -1, 0, 0)
    var yDelta = intArrayOf(0, 0, 1, -1)
    fun updateMatrix(matrix: Array<IntArray>?): Array<IntArray>? {
        if (matrix == null || matrix.isEmpty() || matrix[0].isEmpty()) {
            return null
        }
        val height = matrix.size
        val width = matrix[0].size
        val visited = Array(height) { BooleanArray(width) }
        val result = Array(height) { IntArray(width) }
        val queue = LinkedList<Coord>()
        for (i in 0 until height) {
            for (j in 0 until width) {
                if (matrix[i][j] == 0) {
                    visited[i][j] = true
                    queue.offer(Coord(i, j))
                }
            }
        }

        var step = 0
        while (!queue.isEmpty()) {
            val qSize = queue.size
            for (i in 0 until qSize) {
                val c = queue.poll()
                result[c!!.x][c.y] = step
                for (j in xDelta.indices) {
                    val newX = c.x + xDelta[j]
                    val newY = c.y + yDelta[j]
                    if (newX in 0..(height - 1) && newY in 0..(width - 1) && !visited[newX][newY]) {
                        visited[newX][newY] = true
                        queue.offer(Coord(newX, newY))
                    }
                }
            }

            step++
        }
        return result
    }

    internal inner class Coord(var x: Int, var y: Int)
}
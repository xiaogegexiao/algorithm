package com.algorithm.dynamic_programming

import com.algorithm.AlgorithmQuestion

class MinimumPathSum : AlgorithmQuestion {
    override fun printDescription() {
        System.out.println("Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.\n" +
                "\n" +
                "Note: You can only move either down or right at any point in time.\n" +
                "\n" +
                "Example:\n" +
                "\n" +
                "Input:\n" +
                "[\n" +
                "  [1,3,1],\n" +
                "  [1,5,1],\n" +
                "  [4,2,1]\n" +
                "]\n" +
                "Output: 7\n" +
                "Explanation: Because the path 1→3→1→1→1 minimizes the sum.")
    }

    fun minPathSum(grid: Array<IntArray>?): Int {
        if (grid == null || grid.isEmpty() || grid[0].isEmpty()) {
            return 0
        }

        val height = grid.size
        val width = grid[0].size
        val sums = Array(height) { IntArray(width) }
        for (i in 0 until height) {
            for (j in 0 until width) {
                if (i == 0 && j == 0) {
                    sums[i][j] = grid[i][j]
                } else {
                    sums[i][j] = grid[i][j] + Math.min(if (i > 0) sums[i - 1][j] else Integer.MAX_VALUE, if (j > 0) sums[i][j - 1] else Integer.MAX_VALUE)
                }
            }
        }
        return sums[height - 1][width - 1]
    }
}
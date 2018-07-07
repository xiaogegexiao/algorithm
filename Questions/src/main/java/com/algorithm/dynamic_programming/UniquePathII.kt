package com.algorithm.dynamic_programming

import com.algorithm.AlgorithmQuestion

class UniquePathII : AlgorithmQuestion {
    override fun printDescription() {
        System.out.println("A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).\n" +
                "\n" +
                "The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).\n" +
                "\n" +
                "Now consider if some obstacles are added to the grids. How many unique paths would there be?\n" +
                "\n" +
                "\n" +
                "\n" +
                "An obstacle and empty space is marked as 1 and 0 respectively in the grid.\n" +
                "\n" +
                "Note: m and n will be at most 100.\n" +
                "\n" +
                "Example 1:\n" +
                "\n" +
                "Input:\n" +
                "[\n" +
                "  [0,0,0],\n" +
                "  [0,1,0],\n" +
                "  [0,0,0]\n" +
                "]\n" +
                "Output: 2\n" +
                "Explanation:\n" +
                "There is one obstacle in the middle of the 3x3 grid above.\n" +
                "There are two ways to reach the bottom-right corner:\n" +
                "1. Right -> Right -> Down -> Down\n" +
                "2. Down -> Down -> Right -> Right")
    }

    fun uniquePathsWithObstacles(grid: Array<IntArray>?): Int {
        if (grid == null || grid.isEmpty() || grid[0].isEmpty()) {
            return 0
        }

        val height = grid.size
        val width = grid[0].size
        if (grid[0][0] == 1 || grid[height - 1][width - 1] == 1) {
            return 0
        }

        val count = Array(height) { IntArray(width) }
        for (i in 0 until height) {
            for (j in 0 until width) {
                if (i == 0 && j == 0) {
                    count[i][j] = 1
                } else if (grid[i][j] == 1) {
                    count[i][j] = 0
                } else {
                    count[i][j] = (if (i > 0) count[i - 1][j] else 0) + if (j > 0) count[i][j - 1] else 0
                }
            }
        }
        return count[height - 1][width - 1]
    }

}
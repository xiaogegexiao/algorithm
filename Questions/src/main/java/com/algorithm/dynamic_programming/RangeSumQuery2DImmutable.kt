package com.algorithm.dynamic_programming

import com.algorithm.AlgorithmQuestion

class RangeSumQuery2DImmutable : AlgorithmQuestion {
    override fun printDescription() {
        System.out.println("Given a 2D matrix matrix, find the sum of the elements inside the rectangle defined by its upper left corner (row1, col1) and lower right corner (row2, col2).\n" +
                "\n" +
                "Range Sum Query 2D\n" +
                "The above rectangle (with the red border) is defined by (row1, col1) = (2, 1) and (row2, col2) = (4, 3), which contains sum = 8.\n" +
                "\n" +
                "Example:\n" +
                "Given matrix = [\n" +
                "  [3, 0, 1, 4, 2],\n" +
                "  [5, 6, 3, 2, 1],\n" +
                "  [1, 2, 0, 1, 5],\n" +
                "  [4, 1, 0, 1, 7],\n" +
                "  [1, 0, 3, 0, 5]\n" +
                "]\n" +
                "\n" +
                "sumRegion(2, 1, 4, 3) -> 8\n" +
                "sumRegion(1, 1, 2, 2) -> 11\n" +
                "sumRegion(1, 2, 2, 4) -> 12\n" +
                "Note:\n" +
                "You may assume that the matrix does not change.\n" +
                "There are many calls to sumRegion function.\n" +
                "You may assume that row1 ≤ row2 and col1 ≤ col2.\n")
    }

    var colSum: Array<IntArray>? = null
    fun NumMatrix(matrix: Array<IntArray>?) {
        if (matrix != null && matrix.isNotEmpty() && matrix[0].isNotEmpty()) {
            val h = matrix.size
            val w = matrix[0].size
            colSum = Array(h + 1) { IntArray(w) }
            for (i in 0 until w) {
                for (j in 1..h) {
                    colSum!![j][i] = colSum!![j - 1][i] + matrix[j - 1][i]
                }
            }

        } else {
            colSum = null
        }
    }

    fun sumRegion(row1: Int, col1: Int, row2: Int, col2: Int): Int {
        if (colSum == null) {
            return 0
        } else {
            var res = 0
            for (i in col1..col2) {
                res += colSum!![row2 + 1][i] - colSum!![row1][i]
            }
            return res
        }
    }
}
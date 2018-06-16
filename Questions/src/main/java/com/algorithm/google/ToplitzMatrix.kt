package com.algorithm.google

import com.algorithm.AlgorithmQuestion

class ToplitzMatrix : AlgorithmQuestion {
    override fun printDescription() {
        System.out.println("1042. Toeplitz Matrix\n" +
                "A matrix is Toeplitz if every diagonal from top-left to bottom-right has the same element.\n" +
                "\n" +
                "Now given an M x N matrix, return True if and only if the matrix is Toeplitz.\n" +
                "\n" +
                "Example\n" +
                "Example 1:\n" +
                "\n" +
                "Input: matrix = [[1,2,3,4],[5,1,2,3],[9,5,1,2]]\n" +
                "Output: True\n" +
                "Explanation:\n" +
                "1234\n" +
                "5123\n" +
                "9512\n" +
                "\n" +
                "In the above grid, the diagonals are \"[9]\", \"[5, 5]\", \"[1, 1, 1]\", \"[2, 2, 2]\", \"[3, 3]\", \"[4]\", and in each diagonal all elements are the same, so the answer is True.\n" +
                "\n" +
                "\n" +
                "Example 2:\n" +
                "\n" +
                "Input: matrix = [[1,2],[2,2]]\n" +
                "Output: False\n" +
                "Explanation:\n" +
                "The diagonal \"[1, 2]\" has different elements.")
    }

    /**
     * @param matrix: the given matrix
     * @return: True if and only if the matrix is Toeplitz
     */
    fun isToeplitzMatrix(matrix: Array<IntArray>?): Boolean {
        if (matrix == null || matrix.isEmpty() || matrix[0].isEmpty()) {
            return true
        }

        val h = matrix.size
        val w = matrix[0].size

        for (i in h - 1 downTo 0) {
            if (!checkDiagonal(i, 0, w, h, matrix)) {
                return false
            }
        }

        for (i in 1 until w) {
            if (!checkDiagonal(0, i, w, h, matrix)) {
                return false
            }
        }
        return true
    }

    private fun checkDiagonal(x: Int, y: Int, w: Int, h: Int, matrix: Array<IntArray>): Boolean {
        var x = x
        var y = y
        var res = true
        while (++x < h && ++y < w) {
            if (matrix[x - 1][y - 1] != matrix[x][y]) {
                res = false
                break
            }
        }
        return res
    }
}
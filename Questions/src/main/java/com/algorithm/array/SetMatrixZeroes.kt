package com.algorithm.array

import com.algorithm.AlgorithmQuestion

class SetMatrixZeroes : AlgorithmQuestion {
    override fun printDescription() {
        System.out.println("Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in-place.\n" +
                "\n" +
                "Example 1:\n" +
                "\n" +
                "Input: \n" +
                "[\n" +
                "  [1,1,1],\n" +
                "  [1,0,1],\n" +
                "  [1,1,1]\n" +
                "]\n" +
                "Output: \n" +
                "[\n" +
                "  [1,0,1],\n" +
                "  [0,0,0],\n" +
                "  [1,0,1]\n" +
                "]\n" +
                "Example 2:\n" +
                "\n" +
                "Input: \n" +
                "[\n" +
                "  [0,1,2,0],\n" +
                "  [3,4,5,2],\n" +
                "  [1,3,1,5]\n" +
                "]\n" +
                "Output: \n" +
                "[\n" +
                "  [0,0,0,0],\n" +
                "  [0,4,5,0],\n" +
                "  [0,3,1,0]\n" +
                "]\n" +
                "Follow up:\n" +
                "\n" +
                "A straight forward solution using O(mn) space is probably a bad idea.\n" +
                "A simple improvement uses O(m + n) space, but still not the best solution.\n" +
                "Could you devise a constant space solution?\n")
    }

    fun setZeroes(matrix: Array<IntArray>?) {
        if (matrix == null || matrix.isEmpty() || matrix[0].isEmpty()) {
            return
        }
        val h = matrix.size
        val w = matrix[0].size
        var row0 = 1
        for (i in 0 until w) {
            if (matrix[0][i] == 0) {
                row0 = 0
            }
            for (j in 1 until h) {
                if (matrix[j][i] == 0) {
                    matrix[j][0] = 0
                    matrix[0][i] = 0
                }
            }
        }
        for (i in w - 1 downTo 0) {
            for (j in h - 1 downTo 1) {
                if (matrix[0][i] == 0 || matrix[j][0] == 0) {
                    matrix[j][i] = 0
                }
            }
            if (row0 == 0) {
                matrix[0][i] = 0
            }
        }
    }
}
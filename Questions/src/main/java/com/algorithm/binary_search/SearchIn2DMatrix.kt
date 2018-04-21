package com.algorithm.binary_search

import com.algorithm.AlgorithmQuestion

class SearchIn2DMatrix : AlgorithmQuestion {
    override fun printDescription() {
        System.out.println("Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:\n" +
                "\n" +
                "Integers in each row are sorted in ascending from left to right.\n" +
                "Integers in each column are sorted in ascending from top to bottom.\n" +
                "For example,\n" +
                "\n" +
                "Consider the following matrix:\n" +
                "\n" +
                "[\n" +
                "  [1,   4,  7, 11, 15],\n" +
                "  [2,   5,  8, 12, 19],\n" +
                "  [3,   6,  9, 16, 22],\n" +
                "  [10, 13, 14, 17, 24],\n" +
                "  [18, 21, 23, 26, 30]\n" +
                "]\n" +
                "Given target = 5, return true.\n" +
                "\n" +
                "Given target = 20, return false.")
    }

    fun searchMatrix(matrix: Array<IntArray>?, target: Int): Boolean {
        if (matrix == null || matrix.isEmpty() || matrix[0] == null || matrix[0].isEmpty()) {
            return false
        }

        val height = matrix.size
        val width = matrix[0].size
        var startRow = height - 1
        var startCol = 0
        var result = false
        while (startRow >= 0 && startCol < width) {
            if (matrix[startRow][startCol] == target) {
                result = true
                println("=")
                break
            } else if (matrix[startRow][startCol] < target) {
                startCol++
            } else {
                startRow--
            }
        }
        return result
    }
}
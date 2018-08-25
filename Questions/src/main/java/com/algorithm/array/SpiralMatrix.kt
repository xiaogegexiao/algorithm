package com.algorithm.array

import com.algorithm.AlgorithmQuestion
import java.util.Collections.addAll
import java.util.ArrayList



class SpiralMatrix : AlgorithmQuestion {
    override fun printDescription() {
        System.out.println("Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.\n" +
                "\n" +
                "Example 1:\n" +
                "\n" +
                "Input:\n" +
                "[\n" +
                " [ 1, 2, 3 ],\n" +
                " [ 4, 5, 6 ],\n" +
                " [ 7, 8, 9 ]\n" +
                "]\n" +
                "Output: [1,2,3,6,9,8,7,4,5]\n" +
                "Example 2:\n" +
                "\n" +
                "Input:\n" +
                "[\n" +
                "  [1, 2, 3, 4],\n" +
                "  [5, 6, 7, 8],\n" +
                "  [9,10,11,12]\n" +
                "]\n" +
                "Output: [1,2,3,4,8,12,11,10,9,5,6,7]")
    }

    fun spiralOrder(matrix: Array<IntArray>?): List<Int> {
        return if (matrix == null || matrix.isEmpty() || matrix[0].isEmpty()) {
            ArrayList()
        } else spiralOrderWithBounds(matrix, 0, matrix[0].size - 1, 0, matrix.size - 1)

    }

    fun spiralOrderWithBounds(matrix: Array<IntArray>, left: Int, right: Int, top: Int, bottom: Int): List<Int> {
        val res = ArrayList<Int>()
        if (left > right || top > bottom) {
            return res
        }
        for (i in left..right) {
            res.add(matrix[top][i])
        }
        for (j in top + 1..bottom) {
            res.add(matrix[j][right])
        }
        if (bottom > top) {
            for (i in right - 1 downTo left) {
                res.add(matrix[bottom][i])
            }
        }
        if (right > left) {
            for (i in bottom - 1 downTo top + 1) {
                res.add(matrix[i][left])
            }
        }
        res.addAll(spiralOrderWithBounds(matrix, left + 1, right - 1, top + 1, bottom - 1))
        return res
    }
}
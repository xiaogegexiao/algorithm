package com.algorithm.dynamic_programming

import com.algorithm.AlgorithmQuestion

class MaxLenRepeatedSubarray : AlgorithmQuestion {
    override fun printDescription() {
        System.out.println("Given two integer arrays A and B, return the maximum length of an subarray that appears in both arrays.\n" +
                "\n" +
                "Example 1:\n" +
                "Input:\n" +
                "A: [1,2,3,2,1]\n" +
                "B: [3,2,1,4,7]\n" +
                "Output: 3\n" +
                "Explanation: \n" +
                "The repeated subarray with maximum length is [3, 2, 1].\n" +
                "Note:\n" +
                "1 <= len(A), len(B) <= 1000\n" +
                "0 <= A[i], B[i] < 100")
    }

    fun findLength(A: IntArray?, B: IntArray?): Int {
        if (A == null || A.isEmpty() || B == null || B.isEmpty()) {
            return 0
        }
        val aLen = A.size
        val bLen = B.size
        val mat = Array(aLen) { IntArray(bLen) }
        var result = 0
        for (i in aLen - 1 downTo 0) {
            for (j in bLen - 1 downTo 0) {
                if (i == aLen - 1 || j == bLen - 1) {
                    if (A[i] == B[j]) {
                        mat[i][j] = 1
                        result = Math.max(result, 1)
                    }
                } else {
                    if (A[i] == B[j]) {
                        mat[i][j] = 1 + mat[i + 1][j + 1]
                        result = Math.max(result, mat[i][j])
                    }
                }
            }
        }
        return result
    }
}
package com.algorithm.datastructure

import com.algorithm.AlgorithmQuestion
import java.util.HashMap



class FourSumII : AlgorithmQuestion{
    override fun printDescription() {
        System.out.println("Given four lists A, B, C, D of integer values, compute how many tuples (i, j, k, l) there are such that A[i] + B[j] + C[k] + D[l] is zero.\n" +
                "\n" +
                "To make problem a bit easier, all A, B, C, D have same length of N where 0 ≤ N ≤ 500. All integers are in the range of -228 to 228 - 1 and the result is guaranteed to be at most 231 - 1.\n" +
                "\n" +
                "Example:\n" +
                "\n" +
                "Input:\n" +
                "A = [ 1, 2]\n" +
                "B = [-2,-1]\n" +
                "C = [-1, 2]\n" +
                "D = [ 0, 2]\n" +
                "\n" +
                "Output:\n" +
                "2\n" +
                "\n" +
                "Explanation:\n" +
                "The two tuples are:\n" +
                "1. (0, 0, 0, 1) -> A[0] + B[0] + C[0] + D[1] = 1 + (-2) + (-1) + 2 = 0\n" +
                "2. (1, 1, 0, 0) -> A[1] + B[1] + C[0] + D[0] = 2 + (-1) + (-1) + 0 = 0")
    }

    fun fourSumCount(A: IntArray?, B: IntArray, C: IntArray, D: IntArray): Int {
        if (A == null || A.isEmpty()) {
            return 0
        }
        val len = A.size
        val map = HashMap<Int, Int>()
        for (i in 0 until len) {
            for (j in 0 until len) {
                val abSum = A[i] + B[j]
                map[abSum] = map.getOrDefault(abSum, 0) + 1
            }
        }

        var result = 0
        for (i in 0 until len) {
            for (j in 0 until len) {
                val cdSum = C[i] + D[j]
                result += map.getOrDefault(-cdSum, 0)
            }
        }
        return result
    }
}
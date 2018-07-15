package com.algorithm.dynamic_programming

import com.algorithm.AlgorithmQuestion

class ArithmeticSlice : AlgorithmQuestion {
    override fun printDescription() {
        System.out.println("A sequence of number is called arithmetic if it consists of at least three elements and if the difference between any two consecutive elements is the same.\n" +
                "\n" +
                "For example, these are arithmetic sequence:\n" +
                "\n" +
                "1, 3, 5, 7, 9\n" +
                "7, 7, 7, 7\n" +
                "3, -1, -5, -9\n" +
                "The following sequence is not arithmetic.\n" +
                "\n" +
                "1, 1, 2, 5, 7\n" +
                "\n" +
                "A zero-indexed array A consisting of N numbers is given. A slice of that array is any pair of integers (P, Q) such that 0 <= P < Q < N.\n" +
                "\n" +
                "A slice (P, Q) of array A is called arithmetic if the sequence:\n" +
                "A[P], A[p + 1], ..., A[Q - 1], A[Q] is arithmetic. In particular, this means that P + 1 < Q.\n" +
                "\n" +
                "The function should return the number of arithmetic slices in the array A.\n" +
                "\n" +
                "\n" +
                "Example:\n" +
                "\n" +
                "A = [1, 2, 3, 4]\n" +
                "\n" +
                "return: 3, for 3 arithmetic slices in A: [1, 2, 3], [2, 3, 4] and [1, 2, 3, 4] itself.\n")
    }

    fun numberOfArithmeticSlices(A: IntArray?): Int {
        if (A == null || A.size < 3) {
            return 0
        }
        var res = 0
        var prev = 0
        for (i in 1 until A.size - 1) {
            if (2 * A[i] == A[i - 1] + A[i + 1]) {
                prev += 1
                res += prev
            } else {
                prev = 0
            }
        }
        return res
    }

}
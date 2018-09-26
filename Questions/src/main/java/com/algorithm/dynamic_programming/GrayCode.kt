package com.algorithm.dynamic_programming

import com.algorithm.AlgorithmQuestion
import java.util.Collections.addAll
import java.util.ArrayList
import java.util.Arrays



class GrayCode : AlgorithmQuestion {
    override fun printDescription() {
        System.out.println("The gray code is a binary numeral system where two successive values differ in only one bit.\n" +
                "\n" +
                "Given a non-negative integer n representing the total number of bits in the code, print the sequence of gray code. A gray code sequence must begin with 0.\n" +
                "\n" +
                "Example 1:\n" +
                "\n" +
                "Input: 2\n" +
                "Output: [0,1,3,2]\n" +
                "Explanation:\n" +
                "00 - 0\n" +
                "01 - 1\n" +
                "11 - 3\n" +
                "10 - 2\n" +
                "\n" +
                "For a given n, a gray code sequence may not be uniquely defined.\n" +
                "For example, [0,2,3,1] is also a valid gray code sequence.\n" +
                "\n" +
                "00 - 0\n" +
                "10 - 2\n" +
                "11 - 3\n" +
                "01 - 1\n" +
                "Example 2:\n" +
                "\n" +
                "Input: 0\n" +
                "Output: [0]\n" +
                "Explanation: We define the gray code sequence to begin with 0.\n" +
                "             A gray code sequence of n has size = 2n, which for n = 0 the size is 20 = 1.\n" +
                "             Therefore, for n = 0 the gray code sequence is [0].")
    }

    fun grayCode(n: Int): List<Int> {
        if (n == 0) {
            return Arrays.asList(0)
        }
        if (n == 1) {
            return Arrays.asList(0, 1)
        }

        val res = ArrayList<Int>()
        val prev = grayCode(n - 1)
        res.addAll(prev)
        for (i in prev.indices.reversed()) {
            res.add(prev[i] + (1 shl n - 1))
        }
        return res
    }
}
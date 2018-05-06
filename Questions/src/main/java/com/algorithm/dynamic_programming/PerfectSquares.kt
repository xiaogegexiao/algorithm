package com.algorithm.dynamic_programming

import com.algorithm.AlgorithmQuestion

class PerfectSquares : AlgorithmQuestion{
    override fun printDescription() {
        System.out.println("" +
                "Given a positive integer n, find the least number of perfect square numbers (for example, 1, 4, 9, 16, ...) which sum to n.\n" +
                "\n" +
                "For example, given n = 12, return 3 because 12 = 4 + 4 + 4; given n = 13, return 2 because 13 = 4 + 9.\n" +
                "\n" +
                "Credits:\n" +
                "Special thanks to @jianchao.li.fighter for adding this problem and creating all test cases.")
    }

    fun numSquares(n: Int): Int {
        val perfectSNum = IntArray(n)
        perfectSNum[0] = 1
        for (i in 1 until n) {
            val sqrt = Math.sqrt((i + 1).toDouble()).toInt()
            if (sqrt * sqrt == i + 1) {
                perfectSNum[i] = 1
            } else {
                perfectSNum[i] = 1 + perfectSNum[i - 1]
                for (j in 1..sqrt) {
                    perfectSNum[i] = Math.min(perfectSNum[i], perfectSNum[i - j * j] + 1)
                }
            }
        }
        return perfectSNum[n - 1]
    }
}
package com.algorithm.dynamic_programming

import com.algorithm.AlgorithmQuestion

class UglyNumberII : AlgorithmQuestion {
    override fun printDescription() {
        System.out.println("" +
                "Write a program to find the n-th ugly number.\n" +
                "\n" +
                "Ugly numbers are positive numbers whose prime factors only include 2, 3, 5. \n" +
                "\n" +
                "Example:\n" +
                "\n" +
                "Input: n = 10\n" +
                "Output: 12\n" +
                "Explanation: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 is the sequence of the first 10 ugly numbers.\n" +
                "Note:  \n" +
                "\n" +
                "1 is typically treated as an ugly number.\n" +
                "n does not exceed 1690.\n")
    }

    fun nthUglyNumber(n: Int): Int {
        if (n == 1) {
            return 1
        }
        val dp = IntArray(n)
        dp[0] = 1
        var i = 0
        var j = 0
        var k = 0
        var m = 1
        while (m < n) {
            val temp = Math.min(dp[i] * 2, Math.min(dp[j] * 3, dp[k] * 5))
            if (temp == dp[i] * 2) i++
            else if (temp == dp[j] * 3) j++
            else if (temp == dp[k] * 5) k++
            if (dp[m - 1] != temp)
                dp[m++] = temp
        }
        return dp[n - 1]
    }
}
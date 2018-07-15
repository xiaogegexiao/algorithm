package com.algorithm.dynamic_programming

import com.algorithm.AlgorithmQuestion
import java.util.*


class MaxLengthOfPairChain : AlgorithmQuestion {
    override fun printDescription() {
        System.out.println("" +
                "You are given n pairs of numbers. In every pair, the first number is always smaller than the second number.\n" +
                "\n" +
                "Now, we define a pair (c, d) can follow another pair (a, b) if and only if b < c. Chain of pairs can be formed in this fashion.\n" +
                "\n" +
                "Given a set of pairs, find the length longest chain which can be formed. You needn't use up all the given pairs. You can select pairs in any order.\n" +
                "\n" +
                "Example 1:\n" +
                "Input: [[1,2], [2,3], [3,4]]\n" +
                "Output: 2\n" +
                "Explanation: The longest chain is [1,2] -> [3,4]\n" +
                "Note:\n" +
                "The number of given pairs will be in the range [1, 1000].")
    }

    fun findLongestChain(pairs: Array<IntArray>): Int {
        Arrays.sort(pairs) { pair1, pair2 -> pair1[0] - pair2[0] }

        val dp = IntArray(pairs.size)
        dp[0] = 1
        for (i in 1 until pairs.size) {
            dp[i] = 1
            for (j in i - 1 downTo 0) {
                if (pairs[i][0] > pairs[j][1]) {
                    dp[i] = Math.max(dp[i], 1 + dp[j])
                }
            }
        }
        return dp[pairs.size - 1]
    }
}
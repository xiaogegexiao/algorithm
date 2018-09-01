package com.algorithm.dynamic_programming

import com.algorithm.AlgorithmQuestion

class LongestPalindromicSubsequence : AlgorithmQuestion {
    override fun printDescription() {
        System.out.println("Given a string s, find the longest palindromic subsequence's length in s. You may assume that the maximum length of s is 1000.\n" +
                "\n" +
                "Example 1:\n" +
                "Input:\n" +
                "\n" +
                "\"bbbab\"\n" +
                "Output:\n" +
                "4\n" +
                "One possible longest palindromic subsequence is \"bbbb\".\n" +
                "Example 2:\n" +
                "Input:\n" +
                "\n" +
                "\"cbbd\"\n" +
                "Output:\n" +
                "2\n" +
                "One possible longest palindromic subsequence is \"bb\".")
    }

    fun longestPalindromeSubseq(s: String?): Int {
        if (s == null || s.isEmpty()) {
            return 0
        }
        val sLen = s.length
        val table = Array(sLen) { IntArray(sLen) }
        for (i in 0 until sLen) {
            table[i][i] = 1
        }
        for (width in 2..sLen) {
            for (i in 0 until sLen - width + 1) {
                val j = i + width - 1
                table[i][j] = Math.max(table[i + 1][j], table[i][j - 1])
                if (s[i] == s[j]) {
                    table[i][j] = Math.max(table[i + 1][j - 1] + 2, table[i][j])
                }
                // System.out.println(i + " to " + j + " len = " + table[i][j]);
            }
        }

        return table[0][sLen - 1]
    }
}
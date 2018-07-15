package com.algorithm.dynamic_programming

import com.algorithm.AlgorithmQuestion

class MinASCIIDeleteSumFor2Strings : AlgorithmQuestion {
    override fun printDescription() {
        System.out.println("Given two strings s1, s2, find the lowest ASCII sum of deleted characters to make two strings equal.\n" +
                "\n" +
                "Example 1:\n" +
                "Input: s1 = \"sea\", s2 = \"eat\"\n" +
                "Output: 231\n" +
                "Explanation: Deleting \"s\" from \"sea\" adds the ASCII value of \"s\" (115) to the sum.\n" +
                "Deleting \"t\" from \"eat\" adds 116 to the sum.\n" +
                "At the end, both strings are equal, and 115 + 116 = 231 is the minimum sum possible to achieve this.\n" +
                "Example 2:\n" +
                "Input: s1 = \"delete\", s2 = \"leet\"\n" +
                "Output: 403\n" +
                "Explanation: Deleting \"dee\" from \"delete\" to turn the string into \"let\",\n" +
                "adds 100[d]+101[e]+101[e] to the sum.  Deleting \"e\" from \"leet\" adds 101[e] to the sum.\n" +
                "At the end, both strings are equal to \"let\", and the answer is 100+101+101+101 = 403.\n" +
                "If instead we turned both strings into \"lee\" or \"eet\", we would get answers of 433 or 417, which are higher.\n" +
                "Note:\n" +
                "\n" +
                "0 < s1.length, s2.length <= 1000.\n" +
                "All elements of each string will have an ASCII value in [97, 122].\n")
    }

    fun minimumDeleteSum(s1: String?, s2: String?): Int {
        if (s1 == null || s2 == null || s1.isEmpty() || s2.isEmpty()) {
            return 0
        }
        val len1 = s1.length
        val len2 = s2.length
        val sum = Array(len1) { IntArray(len2) }
        for (i in 0 until len1) {
            for (j in 0 until len2) {
                if (i == 0 && j == 0) {
                    if (s1[i] == s2[j]) {
                        sum[i][j] = 0
                    } else {
                        sum[i][j] = s1[i].toInt() + s2[j].toInt()
                    }
                } else if (i == 0) {
                    if (s1[i] == s2[j]) {
                        sum[i][j] = Math.min(culcSum(s2.substring(0, j)), s2[j].toInt() + sum[i][j - 1])
                    } else {
                        sum[i][j] = s2[j].toInt() + sum[i][j - 1]
                    }
                } else if (j == 0) {
                    if (s1[i] == s2[j]) {
                        sum[i][j] = Math.min(culcSum(s1.substring(0, i)), s1[i].toInt() + sum[i - 1][j])
                    } else {
                        sum[i][j] = s1[i].toInt() + sum[i - 1][j]
                    }
                } else {
                    if (s1[i] == s2[j]) {
                        sum[i][j] = sum[i - 1][j - 1]
                    } else {
                        sum[i][j] = Math.min(s1[i].toInt() + sum[i - 1][j], s2[j].toInt() + sum[i][j - 1])
                    }
                }
            }
        }

        return sum[len1 - 1][len2 - 1]
    }

    private fun culcSum(str: String): Int {
        var res = 0
        for (i in 0 until str.length) {
            res += str[i].toInt()
        }
        return res
    }
}
package com.algorithm.dynamic_programming

import com.algorithm.AlgorithmQuestion
import java.util.HashSet



class WordBreak : AlgorithmQuestion {
    override fun printDescription() {
        System.out.println("Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, determine if s can be segmented into a space-separated sequence of one or more dictionary words.\n" +
                "\n" +
                "Note:\n" +
                "\n" +
                "The same word in the dictionary may be reused multiple times in the segmentation.\n" +
                "You may assume the dictionary does not contain duplicate words.\n" +
                "Example 1:\n" +
                "\n" +
                "Input: s = \"leetcode\", wordDict = [\"leet\", \"code\"]\n" +
                "Output: true\n" +
                "Explanation: Return true because \"leetcode\" can be segmented as \"leet code\".\n" +
                "Example 2:\n" +
                "\n" +
                "Input: s = \"applepenapple\", wordDict = [\"apple\", \"pen\"]\n" +
                "Output: true\n" +
                "Explanation: Return true because \"applepenapple\" can be segmented as \"apple pen apple\".\n" +
                "             Note that you are allowed to reuse a dictionary word.\n" +
                "Example 3:\n" +
                "\n" +
                "Input: s = \"catsandog\", wordDict = [\"cats\", \"dog\", \"sand\", \"and\", \"cat\"]\n" +
                "Output: false")
    }

    fun wordBreak(s: String?, wordDict: List<String>): Boolean {
        if (s == null || s.isEmpty()) {
            return false
        }
        val sLen = s.length

        val set = HashSet<String>()
        for (str in wordDict) {
            set.add(str)
        }

        val valid = BooleanArray(sLen + 1)
        valid[0] = true

        for (i in 1..sLen) {
            for (j in i downTo 1) {
                if (valid[j - 1] && set.contains(s.substring(j - 1, i))) {
                    valid[i] = true
                    break
                }
            }
        }
        return valid[sLen]
    }
}
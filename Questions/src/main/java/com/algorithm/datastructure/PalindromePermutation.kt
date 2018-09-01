package com.algorithm.datastructure

import com.algorithm.AlgorithmQuestion
import java.util.HashMap



class PalindromePermutation : AlgorithmQuestion {
    override fun printDescription() {
        System.out.println("Description\n" +
                "Given a string, determine if a permutation of the string could form a palindrome.\n" +
                "\n" +
                "Have you met this question in a real interview?  \n" +
                "Example\n" +
                "Given s = \"code\", return False.\n" +
                "Given s = \"aab\", return True.\n" +
                "Given s = \"carerac\", return True.")
    }

    fun canPermutePalindrome(s: String?): Boolean {
        val map = HashMap<Char, Int>()
        if (s == null || s.isEmpty()) {
            return true
        }
        var counter = 0
        for (i in 0 until s.length) {
            val c = s[i]
            map[c] = map.getOrDefault(c, 0) + 1
            if (map[c]!! % 2 == 0) {
                counter--
            } else {
                counter++
            }
        }
        return counter < 2
    }
}
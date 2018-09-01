package com.algorithm.twoPointers

import com.algorithm.AlgorithmQuestion

class ValidPalindrome : AlgorithmQuestion {
    override fun printDescription() {
        System.out.println("Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.\n" +
                "\n" +
                "Note: For the purpose of this problem, we define empty string as valid palindrome.\n" +
                "\n" +
                "Example 1:\n" +
                "\n" +
                "Input: \"A man, a plan, a canal: Panama\"\n" +
                "Output: true\n" +
                "Example 2:\n" +
                "\n" +
                "Input: \"race a car\"\n" +
                "Output: false\n")
    }

    fun isPalindrome(s: String?): Boolean {
        if (s == null || s.isEmpty()) {
            return true
        }

        var l = 0
        var r = s.length - 1
        var res = true
        while (l < r) {
            val lc = s[l]
            val rc = s[r]
            if (!validate(lc)) {
                l++
                continue
            }
            if (!validate(rc)) {
                r--
                continue
            }
            if (low(lc) != low(rc)) {
                res = false
                break
            }
            l++
            r--
        }
        return res
    }

    private fun low(c: Char): Char {
        var c = c
        if (c in 'A'..'Z') {
            c = (c - 'A' + 'a'.toInt()).toChar()
        }
        return c
    }

    private fun validate(c: Char): Boolean {
        return c in 'a'..'z' || c in 'A'..'Z' || c in '0'..'9'
    }
}
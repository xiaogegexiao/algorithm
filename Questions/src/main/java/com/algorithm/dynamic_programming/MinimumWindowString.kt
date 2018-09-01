package com.algorithm.dynamic_programming

import com.algorithm.AlgorithmQuestion

class MinimumWindowString : AlgorithmQuestion {
    override fun printDescription() {
        System.out.println("Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).\n" +
                "\n" +
                "Example:\n" +
                "\n" +
                "Input: S = \"ADOBECODEBANC\", T = \"ABC\"\n" +
                "Output: \"BANC\"\n" +
                "Note:\n" +
                "\n" +
                "If there is no such window in S that covers all characters in T, return the empty string \"\".\n" +
                "If there is such window, you are guaranteed that there will always be only one unique minimum window in S.")
    }

    fun minWindow(s: String, t: String): String {
        val table = IntArray(128)

        for (i in 0 until t.length) {
            table[t[i].toInt()]++
        }
        var counter = t.length

        var res: String? = null
        var r = 0
        var l = 0
        while (r < s.length) {
            val c = s[r]
            table[c.toInt()]--
            if (table[c.toInt()] >= 0) {
                counter--
            }
            if (counter == 0) {
                while (l <= r) {
                    val lc = s[l]
                    if (table[lc.toInt()] == 0) {
                        break
                    }
                    table[lc.toInt()]++
                    l++
                }
                if (res == null || res.length > r - l + 1) {
                    res = s.substring(l, r + 1)
                }
            }
            r++
        }
        res = if (res == null) "" else res
        return res
    }
}
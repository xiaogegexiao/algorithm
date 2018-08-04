package com.algorithm.datastructure

import com.algorithm.AlgorithmQuestion

class KDistinctString : AlgorithmQuestion {
    override fun printDescription() {
        System.out.println("Given a very long String, find how many substrings with K distinct characters are contained in this long string.\n" +
                "\n" +
                "return # of all K-length substrings with distinct characters\n" +
                "\n" +
                "//            \"abcdebba\", k=3 -> \"abc\" -> answer: 1\n" +
                "\n" +
                "Int countKdistinctStrings (string s, int k)    ")
    }

    fun countKdistinctStrings(s: String, k: Int): Int {
        if (s.length < k) {
            return 0
        }
        var map = HashMap<Char, Int>()
        for (i in 0..(k - 2)) {
            map[s[i]] = map.getOrDefault(s[i], 0) + 1
        }
        var res = 0
        for (i in 0..(s.length - k)) {
            if (i != 0) {
                map[s[i - 1]] = map[s[i - 1]]!! - 1
                if (map[s[i - 1]] == 0) {
                    map.remove(s[i - 1])
                }
            }
            map[s[i + k - 1]] = map.getOrDefault(s[i + k - 1], 0) + 1
            res += if (map.size == k) 1 else 0
        }
        return res
    }
}
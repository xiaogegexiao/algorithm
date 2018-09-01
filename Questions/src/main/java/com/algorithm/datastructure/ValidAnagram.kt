package com.algorithm.datastructure

import com.algorithm.AlgorithmQuestion
import java.util.HashMap



class ValidAnagram : AlgorithmQuestion {
    override fun printDescription() {
        System.out.println("Given two strings s and t , write a function to determine if t is an anagram of s.\n" +
                "\n" +
                "Example 1:\n" +
                "\n" +
                "Input: s = \"anagram\", t = \"nagaram\"\n" +
                "Output: true\n" +
                "Example 2:\n" +
                "\n" +
                "Input: s = \"rat\", t = \"car\"\n" +
                "Output: false\n" +
                "Note:\n" +
                "You may assume the string contains only lowercase alphabets.\n" +
                "\n" +
                "Follow up:\n" +
                "What if the inputs contain unicode characters? How would you adapt your solution to such case?")
    }

    fun isAnagram(s: String?, t: String?): Boolean {
        if (s == null || t == null || s.length != t.length) {
            return false
        }

        val map = HashMap<Char, Int>()
        for (i in 0 until s.length) {
            val sc = s[i]
            val tc = t[i]
            if (sc == tc) {
                continue
            }
            map[sc] = map.getOrDefault(sc, 0) + 1
            if (map[sc] == 0) {
                map.remove(sc)
            }
            map[tc] = map.getOrDefault(tc, 0) - 1
            if (map[tc] == 0) {
                map.remove(tc)
            }
        }

        return map.size == 0
    }
}
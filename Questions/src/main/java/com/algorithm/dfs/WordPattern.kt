package com.algorithm.dfs

import com.algorithm.AlgorithmQuestion
import java.util.HashMap



class WordPattern : AlgorithmQuestion {
    override fun printDescription() {
        System.out.println("Given a pattern and a string str, find if str follows the same pattern.\n" +
                "\n" +
                "Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in str.\n" +
                "\n" +
                "Example\n" +
                "Given pattern = \"abba\", str = \"dog cat cat dog\", return true.\n" +
                "Given pattern = \"abba\", str = \"dog cat cat fish\", return false.\n" +
                "Given pattern = \"aaaa\", str = \"dog cat cat dog\", return false.\n" +
                "Given pattern = \"abba\", str = \"dog dog dog dog\", return false.")
    }

    /**
     * @param pattern: a string, denote pattern string
     * @param str: a string, denote matching string
     * @return: an boolean, denote whether the pattern string and the matching string match or not
     */
    fun wordPattern(pattern: String?, str: String?): Boolean {
        if (pattern == null || str == null) {
            return false
        }
        val letters = str.split(" ".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
        if (pattern.length != letters.size) {
            return false
        }

        val map = HashMap<Char, String>()
        val map2 = HashMap<String, Char>()
        var res = true
        for (i in 0 until pattern.length) {

            if (letters[i] != (map as java.util.Map<Char, String>).getOrDefault(pattern[i], letters[i]) || pattern[i] != (map2 as java.util.Map<String, Char>).getOrDefault(letters[i], pattern[i])) {
                res = false
                break
            } else {
                map[pattern[i]] = letters[i]
                map2[letters[i]] = pattern[i]
            }
        }

        return res
    }
}
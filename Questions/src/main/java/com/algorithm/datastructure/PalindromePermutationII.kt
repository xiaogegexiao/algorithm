package com.algorithm.datastructure

import com.algorithm.AlgorithmQuestion
import java.util.*


class PalindromePermutationII : AlgorithmQuestion {
    override fun printDescription() {
        System.out.println("917. Palindrome Permutation II\n" +
                "Given a string s, return all the palindromic permutations (without duplicates) of it. Return an empty list if no palindromic permutation could be form.\n" +
                "\n" +
                "Example\n" +
                "Given s = \"aabb\", return [\"abba\",\"baab\"].\n" +
                "Given s = \"abc\", return [].")
    }

    /**
     * @param s: the given string
     * @return: all the palindromic permutations (without duplicates) of it
     */
    fun generatePalindromes(s: String): List<String> {
        val map = HashMap<Char, Int>()
        val res = ArrayList<String>()
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
        if (counter > 1) {
            return res
        }
        dfs(res, "", "", map)
        return res
    }

    fun dfs(res: MutableList<String>, start: String, end: String, map: MutableMap<Char, Int>) {
        if (map.isEmpty()) {
            res.add(start + end)
            return
        }
        val list = ArrayList(map.keys)
        if (list.size == 1 && map[list[0]] == 1) {
            res.add(start + list[0] + end)
        }

        for (c in list) {
            if (map[c] == 1) {
                continue
            }

            map[c] = map[c]!! - 2
            if (map[c] == 0) {
                map.remove(c)
            }
            dfs(res, start + c, c + end, map)
            map[c] = map.getOrDefault(c, 0) + 2

        }
    }
}
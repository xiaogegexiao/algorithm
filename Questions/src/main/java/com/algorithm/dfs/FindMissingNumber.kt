package com.algorithm.dfs

import com.algorithm.AlgorithmQuestion
import java.util.HashSet



class FindMissingNumber : AlgorithmQuestion {
    override fun printDescription() {
        System.out.println("Description\n" +
                "Giving a string with number from 1-n in random order, but miss 1 number.Find that number.\n" +
                "\n" +
                "n <= 30\n" +
                "\n" +
                "Have you met this question in a real interview?  \n" +
                "Example\n" +
                "Given n = 20, str = 19201234567891011121314151618\n" +
                "\n" +
                "return 17")
    }

    /**
     * @param n: An integer
     * @param str: a string with number from 1-n in random order and miss one number
     * @return: An integer
     */
    fun findMissing2(n: Int, str: String): Int {
        val set = HashSet<Int>()
        for (i in 1..n) {
            set.add(i)
        }
        return dfs(set, n, 0, str)
    }

    private fun dfs(set: MutableSet<Int>, n: Int, index: Int, s: String): Int {
        if (index == s.length) {
            return if (set.size == 1) {
                set.toTypedArray()[0]
            } else {
                -1
            }
        }
        if (index < s.length) {
            val subInt = parseInt(s.substring(index, index + 1))
            if (set.contains(subInt)) {
                set.remove(subInt)
                val res = dfs(set, n, index + 1, s)
                if (res != -1) {
                    return res
                }
                set.add(subInt)
            }
        }

        if (index + 1 < s.length) {
            val subInt = parseInt(s.substring(index, index + 2))
            if (set.contains(subInt)) {
                set.remove(subInt)
                val res = dfs(set, n, index + 2, s)
                if (res != -1) {
                    return res
                }
                set.add(subInt)
            }
        }
        return -1
    }

    private fun parseInt(str: String): Int {
        var aInt = -1
        try {
            aInt = Integer.parseInt(str)
        } catch (e: Exception) {

        }

        return if (aInt > 9) {
            if (str.length == 2) aInt else -1
        } else {
            if (str.length == 1) aInt else -1
        }
    }
}
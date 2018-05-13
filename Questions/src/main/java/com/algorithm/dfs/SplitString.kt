package com.algorithm.dfs

import com.algorithm.AlgorithmQuestion
import java.util.ArrayList



class SplitString : AlgorithmQuestion {
    override fun printDescription() {
        System.out.println("Description\n" +
                "Give a string, you can choose to split the string after one character or two adjacent characters, and make the string to be composed of only one character or two characters. Output all possible results.\n" +
                "\n" +
                "Have you met this question in a real interview?  \n" +
                "Example\n" +
                "Given the string \"123\"\n" +
                "return [[\"1\",\"2\",\"3\"],[\"12\",\"3\"],[\"1\",\"23\"]]")
    }

    /*
     * @param : a string to be split
     * @return: all possible split string array
     */
    fun splitString(s: String): Set<List<String>> {
        val result = HashSet<List<String>>()
        dfs(result, ArrayList(), 0, s)
        return result
    }

    private fun dfs(result: MutableSet<List<String>>, prefix: MutableList<String>, index: Int, s: String) {
        if (index == s.length) {
            result.add(ArrayList(prefix))
            return
        }
        if (index < s.length) {
            prefix.add(s.substring(index, index + 1))
            dfs(result, prefix, index + 1, s)
            prefix.removeAt(prefix.size - 1)
        }
        if (index + 1 < s.length) {
            prefix.add(s.substring(index, index + 2))
            dfs(result, prefix, index + 2, s)
            prefix.removeAt(prefix.size - 1)
        }
    }
}
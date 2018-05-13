package com.algorithm.dfs

import com.algorithm.AlgorithmQuestion
import java.util.ArrayList
import java.util.HashSet



class Combinations : AlgorithmQuestion {
    override fun printDescription() {
        System.out.println("Description\n" +
                "Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.\n" +
                "\n" +
                "You don't need to care the order of combinations, but you should make sure the numbers in a combination are sorted.\n" +
                "\n" +
                "Have you met this question in a real interview?  \n" +
                "Example\n" +
                "Given n = 4 and k = 2, a solution is:\n" +
                "\n" +
                "[\n" +
                "  [2,4],\n" +
                "  [3,4],\n" +
                "  [2,3],\n" +
                "  [1,2],\n" +
                "  [1,3],\n" +
                "  [1,4]\n" +
                "]")
    }

    /**
     * @param n: Given the range of numbers
     * @param k: Given the numbers of combinations
     * @return: All the combinations of k numbers out of 1..n
     */
    fun combine(n: Int, k: Int): Set<List<Int>> {
        val result = HashSet<List<Int>>()
        if (k > n) {
            return result
        }
        dfs(result, HashSet(), n, 1, k)
        return result
    }

    private fun dfs(result: MutableSet<List<Int>>, prefix: MutableSet<Int>, n: Int, index: Int, k: Int) {
        if (prefix.size == k) {
            result.add(ArrayList(prefix))
            return
        }
        for (i in index..n) {
            prefix.add(i)
            dfs(result, prefix, n, i + 1, k)
            prefix.remove(i)
        }
    }
}
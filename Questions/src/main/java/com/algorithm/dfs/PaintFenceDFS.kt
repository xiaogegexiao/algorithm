package com.algorithm.dfs

import com.algorithm.AlgorithmQuestion
import java.util.Arrays



class PaintFenceDFS : AlgorithmQuestion {
    override fun printDescription() {
        System.out.println("" +
                "Description\n" +
                "There is a fence with n posts, each post can be painted with one of the k colors.\n" +
                "You have to paint all the posts such that no more than two adjacent fence posts have the same color.\n" +
                "Return the total number of ways you can paint the fence.\n" +
                "\n" +
                "n and k are non-negative integers.\n" +
                "\n" +
                "Have you met this question in a real interview?  \n" +
                "Example\n" +
                "Given n=3, k=2 return 6\n" +
                "\n" +
                "      post 1,   post 2, post 3\n" +
                "way1    0         0       1 \n" +
                "way2    0         1       0\n" +
                "way3    0         1       1\n" +
                "way4    1         0       0\n" +
                "way5    1         0       1\n" +
                "way6    1         1       0")
    }

    fun numWays(n: Int, k: Int): Int {
        if (n == 1) {
            return k
        }
        if (n == 2) {
            return k * k
        }
        if (k < 2) {
            return 0
        }
        val fence = IntArray(n)
        Arrays.fill(fence, -1)
        val result = IntArray(1)
        dfs(result, fence, 0, n, k)
        return result[0]
    }

    private fun dfs(result: IntArray, fence: IntArray, index: Int, n: Int, k: Int) {
        if (index == n) {
            result[0]++
            return
        }
        for (i in 0 until k) {
            if (index >= 2 && fence[index - 1] == fence[index - 2] && i == fence[index - 1]) {
                continue
            }
            fence[index] = i
            dfs(result, fence, index + 1, n, k)
            fence[index] = -1
        }
    }
}
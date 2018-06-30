package com.algorithm.dynamic_programming

import com.algorithm.AlgorithmQuestion

class PaintFenceDP : AlgorithmQuestion{
    override fun printDescription() {
        System.out.println("514. Paint Fence\n" +
                "There is a fence with n posts, each post can be painted with one of the k colors.\n" +
                "You have to paint all the posts such that no more than two adjacent fence posts have the same color.\n" +
                "Return the total number of ways you can paint the fence.\n" +
                "\n" +
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

    /**
     * @param n: non-negative integer, n posts
     * @param k: non-negative integer, k colors
     * @return: an integer, the total number of ways
     */
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
        return if (n == 3) {
            k * (k - 1 + (k - 1) * k)
        } else {
            k * numWays(n - 1, k) - numWays(n - 3, k) * (k - 1)
        }
    }
}
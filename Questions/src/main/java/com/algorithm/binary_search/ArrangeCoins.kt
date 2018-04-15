package com.algorithm.binary_search

import com.algorithm.AlgorithmQuestion

class ArrangeCoins : AlgorithmQuestion {
    override fun printDescription() {
        System.out.println("You have a total of n coins that you want to form in a staircase shape, where every k-th row must have exactly k coins.\n" +
                "\n" +
                "Given n, find the total number of full staircase rows that can be formed.\n" +
                "\n" +
                "n is a non-negative integer and fits within the range of a 32-bit signed integer.\n" +
                "\n" +
                "Example 1:\n" +
                "\n" +
                "n = 5\n" +
                "\n" +
                "The coins can form the following rows:\n" +
                "¤\n" +
                "¤ ¤\n" +
                "¤ ¤\n" +
                "\n" +
                "Because the 3rd row is incomplete, we return 2.\n" +
                "Example 2:\n" +
                "\n" +
                "n = 8\n" +
                "\n" +
                "The coins can form the following rows:\n" +
                "¤\n" +
                "¤ ¤\n" +
                "¤ ¤ ¤\n" +
                "¤ ¤\n" +
                "\n" +
                "Because the 4th row is incomplete, we return 3.")
    }

    fun arrangeCoins(n: Int): Int {
        if (n < 2) {
            return n
        }
        var l: Long = 1
        var r = n.toLong()
        val lN = n.toLong() * 2L
        while (l + 1 < r) {
            val mid = (r - l) / 2 + l
            if (mid * (mid + 1) > lN) {
                r = mid
            } else {
                l = mid
            }
        }

        return if (r * (r + 1) <= lN) {
            r.toInt()
        } else l.toInt()
    }
}
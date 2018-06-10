package com.algorithm.dfs

import com.algorithm.AlgorithmQuestion
import java.util.ArrayList



class NQueensII : AlgorithmQuestion {
    override fun printDescription() {
        System.out.println("Follow up for N-Queens problem.\n" +
                "\n" +
                "Now, instead outputting board configurations, return the total number of distinct solutions.\n" +
                "\n" +
                "Example\n" +
                "For n=4, there are 2 distinct solutions.")
    }

    /**
     * @param n: The number of queens.
     * @return: The total number of distinct solutions.
     */
    fun totalNQueens(n: Int): Int {
        val result = IntArray(1)
        if (n <= 0) {
            return 0
        }

        val possible = Array(n) { IntArray(n) }
        dfs(result, ArrayList(), possible, n)
        return result[0]
    }

    private fun dfs(result: IntArray, prefix: MutableList<Int>, possible: Array<IntArray>, n: Int) {
        if (prefix.size == n) {
            result[0]++
            return
        }
        val index = prefix.size
        for (i in 0 until n) {
            val b = possible[index][i]
            if (b == 0) {
                // System.out.println("can go for position index " + index+ ", i " + i);
                prefix.add(i)
                fillPossible(possible, index, i, n, 1)
                dfs(result, prefix, possible, n)
                fillPossible(possible, index, i, n, -1)
                prefix.removeAt(prefix.size - 1)
            }
        }
    }

    private fun fillPossible(possible: Array<IntArray>, x: Int, y: Int, n: Int, fill: Int) {
        for (i in 0 until n) {
            for (j in 0 until n) {
                if (i == x || j == y || Math.abs(x - i) == Math.abs(y - j)) {
                    possible[i][j] += fill
                    // System.out.println("for x:" + x + ", y:" + y + " set " + i + "," + j + " to " + possible[i][j]);
                }
            }
        }
    }
}
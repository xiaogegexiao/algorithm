package com.algorithm.dfs

import com.algorithm.AlgorithmQuestion
import java.util.ArrayList



class NQueens : AlgorithmQuestion {
    override fun printDescription() {
        System.out.println("" +
                "The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.\n" +
                "\n" +
                "Given an integer n, return all distinct solutions to the n-queens puzzle.\n" +
                "\n" +
                "Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space respectively.\n" +
                "\n" +
                "Example\n" +
                "There exist two distinct solutions to the 4-queens puzzle:\n" +
                "\n" +
                "[\n" +
                "  // Solution 1\n" +
                "  [\".Q..\",\n" +
                "   \"...Q\",\n" +
                "   \"Q...\",\n" +
                "   \"..Q.\"\n" +
                "  ],\n" +
                "  // Solution 2\n" +
                "  [\"..Q.\",\n" +
                "   \"Q...\",\n" +
                "   \"...Q\",\n" +
                "   \".Q..\"\n" +
                "  ]\n" +
                "]\n" +
                "Challenge\n" +
                "Can you do it without recursion?")
    }

    /*
     * @param n: The number of queens
     * @return: All distinct solutionsesul
     */
    fun solveNQueens(n: Int): List<List<String>> {
        val result = ArrayList<List<String>>()
        if (n <= 0) {
            return result
        }

        val possible = Array(n) { IntArray(n) }
        dfs(result, ArrayList(), possible, n)
        return result
    }

    private fun dfs(result: MutableList<List<String>>, prefix: MutableList<Int>, possible: Array<IntArray>, n: Int) {
        if (prefix.size == n) {
            result.add(generateResult(prefix, n))
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

    private fun generateResult(list: List<Int>, n: Int): List<String> {
        val result = ArrayList<String>()
        val sb = StringBuilder()
        for (i in list.indices) {
            sb.setLength(0)
            val qPos = list[i]
            for (j in 0 until n) {
                if (j == qPos) {
                    sb.append('Q')
                } else {
                    sb.append('.')
                }
            }
            result.add(sb.toString())
        }
        return result
    }
}
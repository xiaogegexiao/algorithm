package com.algorithm.dynamic_programming;

import com.algorithm.AlgorithmQuestion;

public class UniquePaths implements AlgorithmQuestion {
    @Override
    public void printDescription() {
        System.out.println("A robot is located at the top-left corner of a m x n grid.\n" +
                "\n" +
                "The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid.\n" +
                "\n" +
                "How many possible unique paths are there?\n" +
                "\n" +
                " Notice\n" +
                "m and n will be at most 100.\n" +
                "\n" +
                "Have you met this question in a real interview? \n" +
                "Example\n" +
                "Given m = 3 and n = 3, return 6.\n" +
                "Given m = 4 and n = 5, return 35.");
    }

    /**
     * @param m: positive integer (1 <= m <= 100)
     * @param n: positive integer (1 <= n <= 100)
     * @return: An integer
     */
    public int uniquePaths(int m, int n) {
        if (m <= 0 || n <= 0) {
            return 0;
        }
        int[][] path = new int[m][n];
        for (int i = 0; i < m; i++) {
            path[i][n - 1] = 1;
        }

        for (int i = 0; i < n; i++) {
            path[m - 1][i] = 1;
        }

        for (int i = m - 2; i >= 0; i--) {
            for (int j = n - 2; j >= 0; j--) {
                path[i][j] = path[i][j + 1] + path[i + 1][j];
            }
        }
        return path[0][0];
    }
}

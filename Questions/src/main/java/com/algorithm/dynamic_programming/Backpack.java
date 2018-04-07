package com.algorithm.dynamic_programming;

import com.algorithm.AlgorithmQuestion;

public class Backpack implements AlgorithmQuestion {
    @Override
    public void printDescription() {
        System.out.println("Given n items with size Ai, an integer m denotes the size of a backpack. How full you can fill this backpack?\n" +
                "\n" +
                " Notice\n" +
                "You can not divide any item into small pieces.\n" +
                "\n" +
                "Have you met this question in a real interview? \n" +
                "Example\n" +
                "If we have 4 items with size [2, 3, 5, 7], the backpack size is 11, we can select [2, 3, 5], so that the max size we can fill this backpack is 10. If the backpack size is 12. we can select [2, 3, 7] so that we can fulfill the backpack.\n" +
                "\n" +
                "You function should return the max size we can fill in the given backpack.\n" +
                "\n" +
                "Challenge \n" +
                "O(n x m) time and O(m) memory.\n" +
                "\n" +
                "O(n x m) memory is also acceptable if you do not know how to optimize memory.\n" +
                "\n");
    }

    /**
     * @param m: An integer m denotes the size of a backpack
     * @param A: Given n items with size A[i]
     * @return: The maximum size
     */
    public int backPack(int m, int[] A) {
        if (m <= 0 || A == null || A.length == 0) {
            return 0;
        }

        boolean[][] path = new boolean[A.length + 1][m + 1];
        path[0][0] = true;

        for (int i = 1; i <= A.length; i++) {
            for (int j = 0; j <= m; j++) {
                path[i][j] = path[i - 1][j];
                if (j >= A[i - 1] && path[i - 1][j - A[i - 1]]) {
                    path[i][j] = true;
                }
            }
        }
        int result = 0;
        for (int i = 0; i <= m; i++) {
            if (path[A.length][i]) {
                result = i;
            }
        }
        return result;
    }
}

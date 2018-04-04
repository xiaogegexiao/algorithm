package com.algorithm.dynamic_programming;

import com.algorithm.AlgorithmQuestion;

public class MaximumSubmatrix implements AlgorithmQuestion {
    @Override
    public void printDescription() {
        System.out.println("" +
                "Given an n x n matrix of positive and negative integers, find the submatrix with the largest possible sum.\n" +
                "Example\n" +
                "Given matrix = \n" +
                "[\n" +
                "[1,3,-1],\n" +
                "[2,3,-2],\n" +
                "[-1,-2,-3]\n" +
                "]\n" +
                "return 9.\n" +
                "Explanation:\n" +
                "the submatrix with the largest possible sum is:\n" +
                "[\n" +
                "[1,2],\n" +
                "[2,3]\n" +
                "]");
    }

    /**
     * [[28  ,-11  ,-80  ,-29 ,41  ,94  ,-79],
     *  [26  ,-70  ,-100 ,49  ,-2  ,-91 ,86],
     *  [57  ,74   ,-49  ,18  ,76  ,-31 ,-1],
     *  [80  ,76   ,-52  ,71  ,99  ,81  ,-56],
     *  [43  ,58   ,-36  ,66  ,-36 ,97  ,88],
     *  [70  ,69   ,-94  ,36  ,73  ,39  ,-19],
     *  [-100,-70  ,-65  ,-21 ,64  ,-37 ,51]]
     *
     * @param matrix: the given matrix
     * @return: the largest possible sum
     */
    public int maxSubmatrix(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
            return 0;
        }

        int height = matrix.length;
        int width = matrix[0].length;

        int[][] horizonSum = new int[height][width];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (j == 0) {
                    horizonSum[i][j] = matrix[i][j];
                } else {
                    horizonSum[i][j] = matrix[i][j] + horizonSum[i][j - 1];
                }
            }
        }

        int l = 0;
        int r = 0;
        int row = 0;
        int result = Integer.MIN_VALUE;
        for (; l < width; l++) {
            for (r = l; r < width; r++) {
                int sum = 0;
                int minPre = 0;
                for (row = 0; row < height; row++) {
                    int oldSum = sum;
                    sum += (l == 0) ? horizonSum[row][r] : (horizonSum[row][r] - horizonSum[row][l - 1]);
                    result = Math.max(result, sum - minPre);
                    minPre = Math.min(minPre, sum);
                }
            }
        }
        return result;
    }
}

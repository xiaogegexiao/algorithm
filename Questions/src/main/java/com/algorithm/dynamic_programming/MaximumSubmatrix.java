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
        int width = matrix.length;

        int[][] horizonSum = new int[height][width];
        int[][] verticalSum = new int[height][width];
        int[][] totalSum = new int[height][width];
        int[][] preMimMat = new int[height][width];

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (j == 0) {
                    horizonSum[i][0] = matrix[i][0];
                } else {
                    horizonSum[i][j] = horizonSum[i][j - 1] + matrix[i][j];
                }
            }
        }

        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                if (j == 0) {
                    verticalSum[0][i] = matrix[0][i];
                } else {
                    verticalSum[j][i] = verticalSum[j - 1][i] + matrix[j][i];
                }
            }
        }

        totalSum[0][0] = matrix[0][0];
        preMimMat[0][0] = Math.min(0, matrix[0][0]);

        int result = Integer.MIN_VALUE;
        for (int step = 1; step < width; step++) {
            for (int i = 0; i <= step; i++) {
                int j = step - i;
                if (i == 0) {
                    totalSum[i][j] = horizonSum[i][j];
                    result = Math.max(result, totalSum[i][j] - preMimMat[i][j - 1]);
                    preMimMat[i][j] = Math.min(totalSum[i][j], preMimMat[i][j - 1]);
                } else if (j == 0) {
                    totalSum[i][j] = verticalSum[i][j];
                    result = Math.max(result, totalSum[i][j] - preMimMat[i - 1][j]);
                    preMimMat[i][j] = Math.min(totalSum[i][j], preMimMat[i - 1][j]);
                } else {
                    totalSum[i][j] = totalSum[i - 1][j - 1] + horizonSum[i][j] + verticalSum[i][j] - matrix[i][j];
                    result = Math.max(result, totalSum[i][j] - preMimMat[i - 1][j - 1]);
                    result = Math.max(result, totalSum[i][j] - preMimMat[i][j - 1]);
                    result = Math.max(result, totalSum[i][j] - preMimMat[i - 1][j]);

                    preMimMat[i][j] = Math.min(totalSum[i][j], preMimMat[i - 1][j]);
                    preMimMat[i][j] = Math.min(totalSum[i][j], preMimMat[i][j - 1]);
                    preMimMat[i][j] = Math.min(totalSum[i][j], preMimMat[i - 1][j - 1]);
                }
            }
        }
        return result;
    }
}

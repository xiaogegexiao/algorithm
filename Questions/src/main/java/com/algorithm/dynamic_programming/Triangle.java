package com.algorithm.dynamic_programming;

import com.algorithm.AlgorithmQuestion;

public class Triangle implements AlgorithmQuestion {
    @Override
    public void printDescription() {
        System.out.println("Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.\n" +
                "\n" +
                " Notice\n" +
                "Bonus point if you are able to do this using only O(n) extra space, where n is the total number of rows in the triangle.\n" +
                "\n" +
                "Have you met this question in a real interview? \n" +
                "Example\n" +
                "Given the following triangle:\n" +
                "\n" +
                "[\n" +
                "     [2],\n" +
                "    [3,4],\n" +
                "   [6,5,7],\n" +
                "  [4,1,8,3]\n" +
                "]\n" +
                "The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).\n" +
                "\n");
    }

    /**
     * @param triangle: a list of lists of integers
     * @return: An integer, minimum path sum
     */
    public int minimumTotal(int[][] triangle) {
        if (triangle == null || triangle.length == 0 || triangle[0] == null || triangle[0].length == 0) {
            return 0;
        }
        int height = triangle.length;
        int width = triangle[triangle.length - 1].length;
        int[] minSum = new int[width];
        for (int i = height - 1; i >= 0; i--) {
            for (int j = 0; j < triangle[i].length; j++) {
                if (i == height - 1) {
                    minSum[j] = triangle[i][j];
                } else {
                    minSum[j] = triangle[i][j] + Math.min(minSum[j], minSum[j + 1]);
                }
            }
        }
        return minSum[0];
    }
}

package com.algorithm.dynamic_programming;

import com.algorithm.AlgorithmQuestion;

public class MinCostClimingStairs implements AlgorithmQuestion {
    @Override
    public void printDescription() {
        System.out.println("On a staircase, the i-th step has some non-negative cost cost[i] assigned (0 indexed).\n" +
                "\n" +
                "Once you pay the cost, you can either climb one or two steps. You need to find minimum cost to reach the top of the floor, and you can either start from the step with index 0, or the step with index 1.\n" +
                "\n" +
                "Example 1:\n" +
                "Input: cost = [10, 15, 20]\n" +
                "Output: 15\n" +
                "Explanation: Cheapest is start on cost[1], pay that cost and go to the top.\n" +
                "Example 2:\n" +
                "Input: cost = [1, 100, 1, 1, 1, 100, 1, 1, 100, 1]\n" +
                "Output: 6\n" +
                "Explanation: Cheapest is start on cost[0], and only step on 1s, skipping cost[3].\n" +
                "Note:\n" +
                "cost will have a length in the range [2, 1000].\n" +
                "Every cost[i] will be an integer in the range [0, 999].");
    }

    public int minCostClimbingStairs(int[] cost) {
        int len = cost.length;
        int[] minCost = new int[len];

        minCost[len - 1] = cost[len - 1];
        minCost[len - 2] = cost[len - 2];

        for (int i = len - 3; i >= 0; i--) {
            minCost[i] = cost[i] + Math.min(minCost[i + 1], minCost[i + 2]);
        }

        return Math.min(minCost[0], minCost[1]);
    }
}

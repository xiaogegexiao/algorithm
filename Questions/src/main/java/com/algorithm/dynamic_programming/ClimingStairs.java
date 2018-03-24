package com.algorithm.dynamic_programming;

import com.algorithm.AlgorithmQuestion;

public class ClimingStairs implements AlgorithmQuestion {
    @Override
    public void printDescription() {
        System.out.println("You are climbing a stair case. It takes n steps to reach to the top.\n" +
                "\n" +
                "Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?\n" +
                "\n" +
                "Note: Given n will be a positive integer.\n" +
                "\n" +
                "\n" +
                "Example 1:\n" +
                "\n" +
                "Input: 2\n" +
                "Output:  2\n" +
                "Explanation:  There are two ways to climb to the top.\n" +
                "\n" +
                "1. 1 step + 1 step\n" +
                "2. 2 steps\n" +
                "Example 2:\n" +
                "\n" +
                "Input: 3\n" +
                "Output:  3\n" +
                "Explanation:  There are three ways to climb to the top.\n" +
                "\n" +
                "1. 1 step + 1 step + 1 step\n" +
                "2. 1 step + 2 steps\n" +
                "3. 2 steps + 1 step");
    }

    public int climbStairs(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }

        int[] ways = new int[n];
        ways[n - 1] = 1;
        ways[n - 2] = 2;

        for (int i = n - 3; i >= 0; i--) {
            ways[i] = ways[i + 1] + ways[i + 2];
        }
        return ways[0];
    }
}

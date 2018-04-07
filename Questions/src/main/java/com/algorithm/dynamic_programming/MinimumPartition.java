package com.algorithm.dynamic_programming;

import com.algorithm.AlgorithmQuestion;

public class MinimumPartition implements AlgorithmQuestion {
    @Override
    public void printDescription() {
        System.out.println("Given a set of positive integers, write a function to divide it into two sets S1 and S2 such that the absolute difference between their sums is minimum.\n" +
                "\n" +
                "If there is a set S with n elements, then if we assume Subset1 has m elements, Subset2 must have n-m elements and the value of abs(sum(Subset1) – sum(Subset2)) should be minimum.\n" +
                "\n" +
                "Have you met this question in a real interview? \n" +
                "Example\n" +
                "Given nums = [1, 6, 11, 5], return 1\n" +
                "\n" +
                "// Subset1 = [1, 5, 6], sum of Subset1 = 12 \n" +
                "// Subset2 = [11], sum of Subset2 = 11   \n" +
                "// abs(11 - 12) = 1     ");
    }

    /**
     * @param nums: the given array
     * @return: the minimum difference between their sums
     */
    public int findMin(int[] nums) {
        // write your code here
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        boolean[] dp = new boolean[sum / 2 + 1];
        dp[0] = true;
        for (int num : nums) {
            for (int i = sum / 2; i >= num; i--) {
                dp[i] |= dp[i - num];
            }
        }

        int i = sum / 2;
        for (; i >= 0; i--) {
            if (dp[i]) {
                break;
            }
        }

        return sum - i * 2;
    }
}

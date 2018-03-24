package com.algorithm.dynamic_programming;

import com.algorithm.AlgorithmQuestion;

public class RangeSumQuery implements AlgorithmQuestion {
    @Override
    public void printDescription() {
        System.out.println("Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.\n" +
                "\n" +
                "Example:\n" +
                "Given nums = [-2, 0, 3, -5, 2, -1]\n" +
                "\n" +
                "sumRange(0, 2) -> 1\n" +
                "sumRange(2, 5) -> -1\n" +
                "sumRange(0, 5) -> -3\n" +
                "Note:\n" +
                "1. You may assume that the array does not change.\n" +
                "2. There are many calls to sumRange function.");
    }

    static class NumArray {
        int[] sums;

        public NumArray(int[] nums) {
            if (nums == null) {
                sums = new int[]{};
            } else {
                sums = new int[nums.length + 1];
                for (int i = 1; i < nums.length + 1; i++) {
                    sums[i] = sums[i - 1] + nums[i - 1];
                }
            }
        }

        public int sumRange(int i, int j) {
            if (sums.length == 0 || i < 0 || j >= sums.length - 1) {
                return 0;
            }
            return sums[j + 1] - sums[i];
        }
    }

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(i,j);
 */
}

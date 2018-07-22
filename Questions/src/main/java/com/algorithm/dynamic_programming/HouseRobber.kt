package com.algorithm.dynamic_programming

import com.algorithm.AlgorithmQuestion

class HouseRobber : AlgorithmQuestion {
    override fun printDescription() {
        System.out.println("You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security system connected and it will automatically contact the police if two adjacent houses were broken into on the same night.\n" +
                "\n" +
                "Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police.\n" +
                "\n" +
                "Example 1:\n" +
                "\n" +
                "Input: [1,2,3,1]\n" +
                "Output: 4\n" +
                "Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).\n" +
                "             Total amount you can rob = 1 + 3 = 4.\n" +
                "Example 2:\n" +
                "\n" +
                "Input: [2,7,9,3,1]\n" +
                "Output: 12\n" +
                "Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 (money = 1).\n" +
                "             Total amount you can rob = 2 + 9 + 1 = 12.")
    }

    fun rob(nums: IntArray?): Int {
        if (nums == null || nums.isEmpty()) {
            return 0
        }

        val res = IntArray(nums.size)
        for (i in nums.indices) {
            if (i < 1) {
                res[i] = nums[i]
            } else if (i == 1) {
                res[i] = Math.max(nums[i], res[i - 1])
            } else {
                res[i] = Math.max(res[i - 1], nums[i] + res[i - 2])
            }
        }
        return res[nums.size - 1]
    }
}
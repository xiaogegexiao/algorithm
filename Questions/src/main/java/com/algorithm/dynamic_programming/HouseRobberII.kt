package com.algorithm.dynamic_programming

import com.algorithm.AlgorithmQuestion

class HouseRobberII : AlgorithmQuestion {
    override fun printDescription() {
        System.out.println("You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed. All houses at this place are arranged in a circle. That means the first house is the neighbor of the last one. Meanwhile, adjacent houses have security system connected and it will automatically contact the police if two adjacent houses were broken into on the same night.\n" +
                "\n" +
                "Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police.\n" +
                "\n" +
                "Example 1:\n" +
                "\n" +
                "Input: [2,3,2]\n" +
                "Output: 3\n" +
                "Explanation: You cannot rob house 1 (money = 2) and then rob house 3 (money = 2),\n" +
                "             because they are adjacent houses.\n" +
                "Example 2:\n" +
                "\n" +
                "Input: [1,2,3,1]\n" +
                "Output: 4\n" +
                "Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).\n" +
                "             Total amount you can rob = 1 + 3 = 4.")
    }

    fun rob(nums: IntArray?): Int {
        if (nums == null || nums.isEmpty()) {
            return 0
        }
        if (nums.size == 1) {
            return nums[0]
        }

        val max1 = maxMoney(nums, 0, nums.size - 2)
        val max2 = maxMoney(nums, 1, nums.size - 1)
        return Math.max(max1, max2)
    }

    private fun maxMoney(nums: IntArray, s: Int, e: Int): Int {
        val length = e - s + 1
        val res = IntArray(length)
        res[0] = nums[s]
        for (i in 1 until length) {
            if (i == 1) {
                res[i] = Math.max(nums[s + 1], nums[s])
            } else {
                res[i] = Math.max(nums[s + i] + res[i - 2], res[i - 1])
            }
        }
        return res[length - 1]
    }
}
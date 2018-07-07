package com.algorithm.dynamic_programming

import com.algorithm.AlgorithmQuestion

class MaxProductSubArray : AlgorithmQuestion {
    override fun printDescription() {
        System.out.println("Given an integer array nums, find the contiguous subarray within an array (containing at least one number) which has the largest product.\n" +
                "\n" +
                "Example 1:\n" +
                "\n" +
                "Input: [2,3,-2,4]\n" +
                "Output: 6\n" +
                "Explanation: [2,3] has the largest product 6.\n" +
                "Example 2:\n" +
                "\n" +
                "Input: [-2,0,-1]\n" +
                "Output: 0\n" +
                "Explanation: The result cannot be 2, because [-2,-1] is not a subarray.")
    }

    fun maxProduct(nums: IntArray?): Int {
        if (nums == null || nums.isEmpty()) {
            return 0
        }
        val product = IntArray(nums.size + 1)
        product[0] = 1
        var negativeMax = 1
        var res = Integer.MIN_VALUE
        for (i in 1..nums.size) {
            if (product[i - 1] == 0) {
                product[i] = nums[i - 1]
                negativeMax = 1
            } else {
                product[i] = product[i - 1] * nums[i - 1]
                if (product[i - 1] < 0) {
                    negativeMax = if (negativeMax == 1) product[i - 1] else Math.max(negativeMax, product[i - 1])
                }
            }
            if (product[i] == 0) {
                res = Math.max(res, 0)
            } else if (product[i] > 0) {
                res = Math.max(res, product[i])
            } else {
                res = Math.max(res, product[i] / negativeMax)
            }
        }
        return res
    }
}
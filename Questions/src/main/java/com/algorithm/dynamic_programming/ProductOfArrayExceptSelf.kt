package com.algorithm.dynamic_programming

import com.algorithm.AlgorithmQuestion

class ProductOfArrayExceptSelf : AlgorithmQuestion {
    override fun printDescription() {
        System.out.println("Given an array nums of n integers where n > 1,  return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].\n" +
                "\n" +
                "Example:\n" +
                "\n" +
                "Input:  [1,2,3,4]\n" +
                "Output: [24,12,8,6]\n" +
                "Note: Please solve it without division and in O(n).\n" +
                "\n" +
                "Follow up:\n" +
                "Could you solve it with constant space complexity? (The output array does not count as extra space for the purpose of space complexity analysis.)")
    }

    fun productExceptSelf(nums: IntArray?): IntArray? {
        if (nums == null || nums.isEmpty()) {
            return nums
        }
        val res = IntArray(nums.size)
        var left = 1
        var right = 1
        for (i in nums.indices) {
            if (i != 0) {
                left *= nums[i - 1]
            }
            res[i] = left
        }
        for (i in nums.indices.reversed()) {
            if (i != nums.size - 1) {
                right *= nums[i + 1]
            }
            res[i] *= right
        }
        return res
    }
}
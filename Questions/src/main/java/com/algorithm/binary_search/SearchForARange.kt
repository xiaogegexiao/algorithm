package com.algorithm.binary_search

import com.algorithm.AlgorithmQuestion

class SearchForARange : AlgorithmQuestion {
    override fun printDescription() {
        System.out.println("Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.\n" +
                "\n" +
                "Your algorithm's runtime complexity must be in the order of O(log n).\n" +
                "\n" +
                "If the target is not found in the array, return [-1, -1].\n" +
                "\n" +
                "Example 1:\n" +
                "\n" +
                "Input: nums = [5,7,7,8,8,10], target = 8\n" +
                "Output: [3,4]\n" +
                "Example 2:\n" +
                "\n" +
                "Input: nums = [5,7,7,8,8,10], target = 6\n" +
                "Output: [-1,-1]")
    }

    fun searchRange(nums: IntArray?, target: Int): IntArray {
        if (nums == null || nums.size == 0) {
            return intArrayOf(-1, -1)
        }
        var l = 0
        var r = nums.size - 1
        val result = IntArray(2)
        while (l + 1 < r) {
            val mid = (r - l) / 2 + l
            if (nums[mid] >= target) {
                r = mid
            } else {
                l = mid
            }
        }
        if (nums[l] == target) {
            result[0] = l
        } else if (nums[r] == target) {
            result[0] = r
        } else {
            return intArrayOf(-1, -1)
        }

        l = result[0]
        r = nums.size - 1
        while (l + 1 < r) {
            val mid = (r - l) / 2 + l
            if (nums[mid] <= target) {
                l = mid
            } else {
                r = mid
            }
        }
        if (nums[r] == target) {
            result[1] = r
        } else {
            result[1] = l
        }
        return result
    }
}
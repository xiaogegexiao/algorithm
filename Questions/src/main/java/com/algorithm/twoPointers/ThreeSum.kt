package com.algorithm.twoPointers

import com.algorithm.AlgorithmQuestion
import java.util.ArrayList
import java.util.Arrays



class ThreeSum : AlgorithmQuestion {
    override fun printDescription() {
        System.out.println("" +
                "Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.\n" +
                "\n" +
                "Note:\n" +
                "\n" +
                "The solution set must not contain duplicate triplets.\n" +
                "\n" +
                "Example:\n" +
                "\n" +
                "Given array nums = [-1, 0, 1, 2, -1, -4],\n" +
                "\n" +
                "A solution set is:\n" +
                "[\n" +
                "  [-1, 0, 1],\n" +
                "  [-1, -1, 2]\n" +
                "]")
    }

    fun threeSum(nums: IntArray?): List<List<Int>> {
        val list = ArrayList<List<Int>>()
        if (nums == null || nums.isEmpty()) {
            return list
        }
        Arrays.sort(nums)
        for (i in nums.indices) {
            if (i != 0 && nums[i] == nums[i - 1]) {
                continue
            }
            val rest = 0 - nums[i]
            var l = i + 1
            var r = nums.size - 1
            while (l < r) {
                val sum = nums[l] + nums[r]
                if (sum == rest) {
                    if (r == nums.size - 1 || nums[r] != nums[r + 1]) {
                        list.add(createTriplet(nums[i], nums[l], nums[r]))
                    }
                    r--
                    l++
                } else if (sum > rest) {
                    r--
                } else {
                    l++
                }
            }
        }
        return list
    }


    private fun createTriplet(a: Int, b: Int, c: Int): List<Int> {
        val list = ArrayList<Int>()
        list.add(a)
        list.add(b)
        list.add(c)
        return list
    }
}
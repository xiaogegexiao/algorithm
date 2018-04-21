package com.algorithm.array

import com.algorithm.AlgorithmQuestion
import java.util.HashMap


class MajorityElement : AlgorithmQuestion {
    override fun printDescription() {
        System.out.println("Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.\n" +
                "\n" +
                "You may assume that the array is non-empty and the majority element always exist in the array.\n" +
                "\n" +
                "Credits:\n" +
                "Special thanks to @ts for adding this problem and creating all test cases.")
    }

    fun majorityElement(nums: IntArray): Int {
        val map = HashMap<Int, Int>()
        val len = nums.size
        var result = -1
        for (num in nums) {
            val count = 1 + (map as Map<Int, Int>).getOrDefault(num, 0)
            if (count > len / 2) {
                result = num
                break
            }
            map[num] = count
        }
        return result
    }
}
package com.algorithm.twoPointers

import com.algorithm.AlgorithmQuestion

class TwoSumII : AlgorithmQuestion {
    override fun printDescription() {
        System.out.println("Given an array of integers that is already sorted in ascending order, find two numbers such that they add up to a specific target number.\n" +
                "\n" +
                "The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2.\n" +
                "\n" +
                "Note:\n" +
                "\n" +
                "Your returned answers (both index1 and index2) are not zero-based.\n" +
                "You may assume that each input would have exactly one solution and you may not use the same element twice.\n" +
                "Example:\n" +
                "\n" +
                "Input: numbers = [2,7,11,15], target = 9\n" +
                "Output: [1,2]\n" +
                "Explanation: The sum of 2 and 7 is 9. Therefore index1 = 1, index2 = 2.")
    }

    fun twoSum(numbers: IntArray, target: Int): IntArray {
        val res = IntArray(2)
        var l = 1
        var r = numbers.size
        while (l < r) {
            val sum = numbers[l - 1] + numbers[r - 1]
            if (sum == target) {
                res[0] = l
                res[1] = r
                break
            } else if (sum > target) {
                r--
            } else {
                l++
            }
        }
        return res
    }
}
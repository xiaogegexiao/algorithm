package com.algorithm.binary_search

import com.algorithm.AlgorithmQuestion

class FindDuplicateNumber : AlgorithmQuestion {
    override fun printDescription() {
        System.out.println("" +
                "Given an array nums containing n + 1 integers where each integer is between 1 and n (inclusive), prove that at least one duplicate number must exist. Assume that there is only one duplicate number, find the duplicate one.\n" +
                "\n" +
                "Note:\n" +
                "You must not modify the array (assume the array is read only).\n" +
                "You must use only constant, O(1) extra space.\n" +
                "Your runtime complexity should be less than O(n2).\n" +
                "There is only one duplicate number in the array, but it could be repeated more than once.\n" +
                "Credits:\n" +
                "Special thanks to @jianchao.li.fighter for adding this problem and creating all test cases.")
    }

    public fun findDuplicate(nums: IntArray): Int {
        var l = 1
        var r = nums.size - 1
        while (l + 1 < r) {
            var m = (r - l) / 2 + l
            if (countLessEqualThan(m, nums) <= m) {
                l = m
            } else {
                r = m
            }
        }

        if (countLessEqualThan(l, nums) <= l) {
            return r
        } else {
            return l
        }
    }

    fun countLessEqualThan(target: Int, intArray: IntArray) : Int{
        var result = 0
        for (num in intArray) {
            if (num <= target) {
                result++
            }
        }
        return result
    }
}
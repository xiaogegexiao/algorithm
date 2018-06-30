package com.algorithm.datastructure

import com.algorithm.AlgorithmQuestion

class RangeSumQuery : AlgorithmQuestion {
    override fun printDescription() {
        System.out.println("840. Range Sum Query - Mutable\n" +
                "Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.\n" +
                "\n" +
                "The update(i, val) function modifies nums by updating the element at index i to val.\n" +
                "\n" +
                "Example\n" +
                "Given nums = [1, 3, 5]\n" +
                "\n" +
                "sumRange(0, 2) -> 9\n" +
                "update(1, 2)\n" +
                "sumRange(0, 2) -> 8")
    }

    lateinit var sums: IntArray
    lateinit var nums: IntArray
    fun numArray(nums: IntArray) {
        this.nums = nums
        sums = IntArray(nums.size + 1)
        for (i in 1..nums.size) {
            sums[i] = sums[i - 1] + nums[i - 1]
        }
    }

    fun update(i: Int, `val`: Int) {
        val diff = `val` - nums[i]
        nums[i] = `val`
        for (j in i + 1 until sums.size) {
            sums[j] = sums[j] + diff
        }
    }

    fun sumRange(i: Int, j: Int): Int {
        return sums[j + 1] - sums[i]
    }
}
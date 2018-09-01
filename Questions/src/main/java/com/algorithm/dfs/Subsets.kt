package com.algorithm.dfs

import com.algorithm.AlgorithmQuestion
import java.util.ArrayList



class Subsets : AlgorithmQuestion {
    override fun printDescription() {
        System.out.println("Given a set of distinct integers, nums, return all possible subsets (the power set).\n" +
                "\n" +
                "Note: The solution set must not contain duplicate subsets.\n" +
                "\n" +
                "Example:\n" +
                "\n" +
                "Input: nums = [1,2,3]\n" +
                "Output:\n" +
                "[\n" +
                "  [3],\n" +
                "  [1],\n" +
                "  [2],\n" +
                "  [1,2,3],\n" +
                "  [1,3],\n" +
                "  [2,3],\n" +
                "  [1,2],\n" +
                "  []\n" +
                "]")
    }

    fun subsets(nums: IntArray?): List<List<Int>> {
        val res = ArrayList<List<Int>>()
        if (nums == null) {
            return res
        }
        dfs(res, ArrayList(), nums, 0)
        return res
    }

    fun dfs(res: MutableList<List<Int>>, prev: MutableList<Int>, nums: IntArray, index: Int) {
        res.add(ArrayList(prev))
        if (index == nums.size) {
            return
        }
        for (i in index until nums.size) {
            prev.add(nums[i])
            dfs(res, prev, nums, i + 1)
            prev.removeAt(prev.size - 1)
        }
    }
}
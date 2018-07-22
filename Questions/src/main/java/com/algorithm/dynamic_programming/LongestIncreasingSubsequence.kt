package com.algorithm.dynamic_programming

import com.algorithm.AlgorithmQuestion

class LongestIncreasingSubsequence : AlgorithmQuestion {
    override fun printDescription() {
        System.out.println("" +
                "Given an unsorted array of integers, find the length of longest increasing subsequence.\n" +
                "\n" +
                "Example:\n" +
                "\n" +
                "Input: [10,9,2,5,3,7,101,18]\n" +
                "Output: 4 \n" +
                "Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4. \n" +
                "Note:\n" +
                "\n" +
                "There may be more than one LIS combination, it is only necessary for you to return the length.\n" +
                "Your algorithm should run in O(n2) complexity.\n" +
                "Follow up: Could you improve it to O(n log n) time complexity?\n" +
                "\n" +
                "Seen this question in a real interview before?  \n")
    }

    fun lengthOfLIS(nums: IntArray?): Int {
        if (nums == null || nums.isEmpty()) {
            return 0
        }
        val len = IntArray(nums.size)
        var res = 0
        for (i in nums.indices) {
            len[i] = 1
            if (i != 0) {
                for (j in 0 until i) {
                    if (nums[j] < nums[i]) {
                        len[i] = Math.max(len[i], 1 + len[j])
                    }
                }
            }
            res = Math.max(res, len[i])
        }
        return res
    }
}
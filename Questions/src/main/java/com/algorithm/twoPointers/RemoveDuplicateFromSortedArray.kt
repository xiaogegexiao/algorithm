package com.algorithm.twoPointers

import com.algorithm.AlgorithmQuestion

class RemoveDuplicateFromSortedArray : AlgorithmQuestion {
    override fun printDescription() {
        System.out.println("Description\n" +
                "Follow up for \"Remove Duplicates\":\n" +
                "What if duplicates are allowed at most twice?\n" +
                "\n" +
                "For example,\n" +
                "Given sorted array A = [1,1,1,2,2,3],\n" +
                "\n" +
                "Your function should return length = 5, and A is now [1,1,2,2,3].")
    }

    /**
     * @param A: a array of integers
     * @return : return an integer
     */
    fun removeDuplicates(nums: IntArray?): Int {
        if (nums == null || nums.isEmpty()) {
            return 0
        }

        var index = 0
        var p = 1
        var repeatTime = 0
        while (p < nums.size) {
            if (nums[p] != nums[index]) {
                 nums[++index] = nums[p++]
                repeatTime = 0
            } else {
                if (repeatTime++ < 1) {
                    nums[++index] = nums[p++]
                } else {
                    p++
                }
            }
        }
        return index + 1
    }
}
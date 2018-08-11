package com.algorithm.datastructure

import com.algorithm.AlgorithmQuestion
import java.util.HashMap



class KDiffPairInArray : AlgorithmQuestion {
    override fun printDescription() {
        System.out.println("Given an array of integers and an integer k, you need to find the number of unique k-diff pairs in the array. Here a k-diff pair is defined as an integer pair (i, j), where i and j are both numbers in the array and their absolute difference is k.\n" +
                "\n" +
                "Example 1:\n" +
                "Input: [3, 1, 4, 1, 5], k = 2\n" +
                "Output: 2\n" +
                "Explanation: There are two 2-diff pairs in the array, (1, 3) and (3, 5).\n" +
                "Although we have two 1s in the input, we should only return the number of unique pairs.\n" +
                "Example 2:\n" +
                "Input:[1, 2, 3, 4, 5], k = 1\n" +
                "Output: 4\n" +
                "Explanation: There are four 1-diff pairs in the array, (1, 2), (2, 3), (3, 4) and (4, 5).\n" +
                "Example 3:\n" +
                "Input: [1, 3, 1, 5, 4], k = 0\n" +
                "Output: 1\n" +
                "Explanation: There is one 0-diff pair in the array, (1, 1).\n" +
                "Note:\n" +
                "The pairs (i, j) and (j, i) count as the same pair.\n" +
                "The length of the array won't exceed 10,000.\n" +
                "All the integers in the given input belong to the range: [-1e7, 1e7].\n")
    }


    fun findPairs(nums: IntArray?, k: Int): Int {
        if (nums == null || nums.size < 2 || k < 0) {
            return 0
        }
        val map = HashMap<Int, Int>()
        var res = 0
        for (num in nums) {
            if (k == 0) {
                val count = (map as Map<Int, Int>).getOrDefault(num, 0)
                if (count == 1) {
                    res++
                }
                map[num] = count + 1
            } else {
                if (map.containsKey(num)) {
                    continue
                }
                if ((map as Map<Int, Int>).getOrDefault(num + k, 0) > 0) {
                    res++
                }
                if ((map as Map<Int, Int>).getOrDefault(num - k, 0) > 0) {
                    res++
                }
                map[num] = (map as Map<Int, Int>).getOrDefault(num, 0) + 1
            }
        }
        return res
    }
}
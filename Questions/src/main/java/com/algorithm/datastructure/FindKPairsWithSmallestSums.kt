package com.algorithm.datastructure

import com.algorithm.AlgorithmQuestion
import java.util.ArrayList
import java.util.Comparator
import java.util.PriorityQueue
import java.util.Queue



class FindKPairsWithSmallestSums : AlgorithmQuestion {
    override fun printDescription() {
        System.out.println("You are given two integer arrays nums1 and nums2 sorted in ascending order and an integer k.\n" +
                "\n" +
                "Define a pair (u,v) which consists of one element from the first array and one element from the second array.\n" +
                "\n" +
                "Find the k pairs (u1,v1),(u2,v2) ...(uk,vk) with the smallest sums.\n" +
                "\n" +
                "Example 1:\n" +
                "\n" +
                "Input: nums1 = [1,7,11], nums2 = [2,4,6], k = 3\n" +
                "Output: [[1,2],[1,4],[1,6]] \n" +
                "Explanation: The first 3 pairs are returned from the sequence: \n" +
                "             [1,2],[1,4],[1,6],[7,2],[7,4],[11,2],[7,6],[11,4],[11,6]\n" +
                "Example 2:\n" +
                "\n" +
                "Input: nums1 = [1,1,2], nums2 = [1,2,3], k = 2\n" +
                "Output: [1,1],[1,1]\n" +
                "Explanation: The first 2 pairs are returned from the sequence: \n" +
                "             [1,1],[1,1],[1,2],[2,1],[1,2],[2,2],[1,3],[1,3],[2,3]\n" +
                "Example 3:\n" +
                "\n" +
                "Input: nums1 = [1,2], nums2 = [3], k = 3\n" +
                "Output: [1,3],[2,3]\n" +
                "Explanation: All possible pairs are returned from the sequence: [1,3],[2,3]")
    }

    fun kSmallestPairs(nums1: IntArray?, nums2: IntArray?, k: Int): List<IntArray> {
        var k = k
        val queue = PriorityQueue(Comparator<IntArray> { p1, p2 -> p1[0] + p1[1] - p2[0] - p2[1] })
        val res = ArrayList<IntArray>()
        if (nums1 == null || nums1.isEmpty() || nums2 == null || nums2.isEmpty()) {
            return res
        }
        for (num1 in nums1) {
            queue.offer(intArrayOf(num1, nums2[0], 0))
        }
        while (k-- > 0 && !queue.isEmpty()) {
            val pair = queue.poll()
            res.add(intArrayOf(pair!![0], pair[1]))
            if (pair[2] == nums2.size - 1)
                continue
            queue.offer(intArrayOf(pair[0], nums2[pair[2] + 1], pair[2] + 1))
        }
        return res
    }
}
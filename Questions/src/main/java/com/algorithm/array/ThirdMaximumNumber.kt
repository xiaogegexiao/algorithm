package com.algorithm.array

import com.algorithm.AlgorithmQuestion
import java.util.PriorityQueue
import java.util.Queue
import java.util.HashSet



class ThirdMaximumNumber : AlgorithmQuestion {
    override fun printDescription() {
        System.out.println("Given a non-empty array of integers, return the third maximum number in this array. If it does not exist, return the maximum number. The time complexity must be in O(n).\n" +
                "\n" +
                "Example 1:\n" +
                "Input: [3, 2, 1]\n" +
                "\n" +
                "Output: 1\n" +
                "\n" +
                "Explanation: The third maximum is 1.\n" +
                "Example 2:\n" +
                "Input: [1, 2]\n" +
                "\n" +
                "Output: 2\n" +
                "\n" +
                "Explanation: The third maximum does not exist, so the maximum (2) is returned instead.\n" +
                "Example 3:\n" +
                "Input: [2, 2, 3, 1]\n" +
                "\n" +
                "Output: 1\n" +
                "\n" +
                "Explanation: Note that the third maximum here means the third maximum distinct number.\n" +
                "Both numbers with value 2 are both considered as second maximum.\n")
    }

    fun thirdMax(nums: IntArray): Int {
        val set = HashSet<Int>()
        val queue = PriorityQueue<Int>()
        for (num in nums) {
            if (set.contains(num)) {
                continue
            }
            set.add(num)
            queue.offer(num)
            if (queue.size > 3) {
                queue.poll()
            }
        }
        if (queue.size < 3) {
            while (queue.size > 1) {
                queue.poll()
            }
        }
        return queue.poll()!!
    }
}
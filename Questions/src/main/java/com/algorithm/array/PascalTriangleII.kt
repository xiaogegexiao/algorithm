package com.algorithm.array

import com.algorithm.AlgorithmQuestion
import java.util.ArrayList
import java.util.Arrays



class PascalTriangleII : AlgorithmQuestion {
    override fun printDescription() {
        System.out.println("Given a non-negative index k where k ≤ 33, return the kth index row of the Pascal's triangle.\n" +
                "\n" +
                "Note that the row index starts from 0.\n" +
                "\n" +
                "\n" +
                "In Pascal's triangle, each number is the sum of the two numbers directly above it.\n" +
                "\n" +
                "Example:\n" +
                "\n" +
                "Input: 3\n" +
                "Output: [1,3,3,1]\n" +
                "Follow up:\n" +
                "\n" +
                "Could you optimize your algorithm to use only O(k) extra space?\n" +
                "\n")
    }

    fun getRow(rowIndex: Int): List<Int> {
        if (rowIndex == 0) {
            return Arrays.asList(1)
        }
        val prev = getRow(rowIndex - 1)
        val res = ArrayList<Int>()
        res.add(1)
        for (i in 0 until prev.size - 1) {
            res.add(prev[i] + prev[i + 1])
        }
        res.add(1)
        return res
    }
}
package com.algorithm.datastructure

import com.algorithm.AlgorithmQuestion
import java.util.HashSet



class HappyNumber : AlgorithmQuestion {
    override fun printDescription() {
        System.out.println("" +
                "Write an algorithm to determine if a number is \"happy\".\n" +
                "\n" +
                "A happy number is a number defined by the following process: Starting with any positive integer, replace the number by the sum of the squares of its digits, and repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1. Those numbers for which this process ends in 1 are happy numbers.\n" +
                "\n" +
                "Example: \n" +
                "\n" +
                "Input: 19\n" +
                "Output: true\n" +
                "Explanation: \n" +
                "12 + 92 = 82\n" +
                "82 + 22 = 68\n" +
                "62 + 82 = 100\n" +
                "12 + 02 + 02 = 1")
    }

    var set: MutableSet<Int> = HashSet()
    fun isHappy(n: Int): Boolean {
        var n = n
        if (n == 1) {
            return true
        }
        if (set.contains(n)) {
            return false
        }
        set.add(n)
        var count = 0
        while (n > 0) {
            count += n % 10 * (n % 10)
            n /= 10
        }
        return isHappy(count)
    }
}
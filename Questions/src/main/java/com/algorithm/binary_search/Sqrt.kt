package com.algorithm.binary_search

import com.algorithm.AlgorithmQuestion

class Sqrt : AlgorithmQuestion {
    override fun printDescription() {
        System.out.println("Implement int sqrt(int x).\n" +
                "\n" +
                "Compute and return the square root of x.\n" +
                "\n" +
                "x is guaranteed to be a non-negative integer.\n" +
                "\n" +
                "\n" +
                "Example 1:\n" +
                "\n" +
                "Input: 4\n" +
                "Output: 2\n" +
                "Example 2:\n" +
                "\n" +
                "Input: 8\n" +
                "Output: 2\n" +
                "Explanation: The square root of 8 is 2.82842..., and since we want to return an integer, the decimal part will be truncated.")
    }


    fun mySqrt(x: Int): Int {
        if (x <= 1) {
            return x
        }

        var l: Long = 1
        var r = x.toLong()

        while (l + 1 < r) {
            val mid = (r - l) / 2 + l
            if (mid * mid > x.toLong()) {
                r = mid
            } else {
                l = mid
            }
        }

        return if (r * r <= x) {
            r.toInt()
        } else l.toInt()
    }
}
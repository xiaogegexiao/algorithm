package com.algorithm.dynamic_programming

import com.algorithm.AlgorithmQuestion

class CountPrimes : AlgorithmQuestion {
    override fun printDescription() {
        System.out.println("Count the number of prime numbers less than a non-negative number, n.\n" +
                "\n" +
                "Example:\n" +
                "\n" +
                "Input: 10\n" +
                "Output: 4\n" +
                "Explanation: There are 4 prime numbers less than 10, they are 2, 3, 5, 7.\n")
    }

    fun countPrimes(n: Int): Int {
        val notPrime = BooleanArray(n)
        var res = 0

        for (i in 2 until n) {
            if (!notPrime[i]) {
                res++
                var j = 2
                while (j * i < 10) {
                    notPrime[j * i] = true
                    j++
                }
            }
        }
        return res
    }
}
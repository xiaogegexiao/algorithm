package com.algorithm.dynamic_programming

import com.algorithm.AlgorithmQuestion

class MaxRepeatSubarray : AlgorithmQuestion {
    override fun printDescription() {
        System.out.println("Try to find out the max repeat array len\n" +
                "For example: ababa, the max repeat subarray len is 3 which is aba")
    }

    fun maxRepeatSubarrayLen(text : String): Int {
        if (text.isBlank()) {
            return 0
        }

        val textLen = text.length
        val mat = Array(textLen) { IntArray(textLen) }
        var result = 0
        for (i in textLen - 1 downTo 0) {
            for (j in textLen - 1 downTo 0) {
                if (text[i] == text[j]) {
                    if (i == textLen - 1 || j == textLen - 1) {
                        mat[i][j] = 1
                    } else {
                        mat[i][j] = 1 + mat[i + 1][j + 1]
                    }
                    if (i != j) {
                        result = Math.max(result, mat[i][j])
                    }
                }
            }
        }
        return result
    }
}
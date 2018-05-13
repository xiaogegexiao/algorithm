package com.algorithm.dynamic_programming

import com.algorithm.AlgorithmQuestion

class MaximumSubmatrix : AlgorithmQuestion {
    override fun printDescription() {
        println("" +
                "Given an n x n matrix of positive and negative integers, find the submatrix with the largest possible sum.\n" +
                "Example\n" +
                "Given matrix = \n" +
                "[\n" +
                "[1,3,-1],\n" +
                "[2,3,-2],\n" +
                "[-1,-2,-3]\n" +
                "]\n" +
                "return 9.\n" +
                "Explanation:\n" +
                "the submatrix with the largest possible sum is:\n" +
                "[\n" +
                "[1,2],\n" +
                "[2,3]\n" +
                "]")
    }

    /**
     * [[28  ,-11  ,-80  ,-29 ,41  ,94  ,-79],
     * [26  ,-70  ,-100 ,49  ,-2  ,-91 ,86],
     * [57  ,74   ,-49  ,18  ,76  ,-31 ,-1],
     * [80  ,76   ,-52  ,71  ,99  ,81  ,-56],
     * [43  ,58   ,-36  ,66  ,-36 ,97  ,88],
     * [70  ,69   ,-94  ,36  ,73  ,39  ,-19],
     * [-100,-70  ,-65  ,-21 ,64  ,-37 ,51]]
     *
     * @param matrix: the given matrix
     * @return: the largest possible sum
     */
    fun maxSubmatrix(matrix: Array<IntArray>?): Int {
        if (matrix == null || matrix.isEmpty() || matrix[0].isEmpty()) {
            return 0
        }

        val height = matrix.size
        val width = matrix[0].size

        val horizonSum = Array(height) { IntArray(width) }
        for (i in 0 until height) {
            for (j in 0 until width) {
                if (j == 0) {
                    horizonSum[i][j] = matrix[i][j]
                } else {
                    horizonSum[i][j] = matrix[i][j] + horizonSum[i][j - 1]
                }
            }
        }

        var l = 0
        var r = 0
        var row = 0
        var result = Integer.MIN_VALUE
        while (l < width) {
            r = l
            while (r < width) {
                var sum = 0
                var minPre = 0
                row = 0
                while (row < height) {
                    val oldSum = sum
                    sum += if (l == 0) horizonSum[row][r] else horizonSum[row][r] - horizonSum[row][l - 1]
                    result = Math.max(result, sum - minPre)
                    minPre = Math.min(minPre, sum)
                    row++
                }
                r++
            }
            l++
        }
        return result
    }
}

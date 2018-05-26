package com.algorithm.twoPointers

import com.algorithm.AlgorithmQuestion
import java.util.*


class MostProfitAssigningWork : AlgorithmQuestion {
    override fun printDescription() {
        System.out.println("We have jobs: difficulty[i] is the difficulty of the ith job, and profit[i] is the profit of the ith job. \n" +
                "\n" +
                "Now we have some workers. worker[i] is the ability of the ith worker, which means that this worker can only complete a job with difficulty at most worker[i]. \n" +
                "\n" +
                "Every worker can be assigned at most one job, but one job can be completed multiple times.\n" +
                "\n" +
                "For example, if 3 people attempt the same job that pays \$1, then the total profit will be \$3.  If a worker cannot complete any job, his profit is \$0.\n" +
                "\n" +
                "What is the most profit we can make?\n" +
                "\n" +
                "Example 1:\n" +
                "\n" +
                "Input: difficulty = [2,4,6,8,10], profit = [10,20,30,40,50], worker = [4,5,6,7]\n" +
                "Output: 100 \n" +
                "Explanation: Workers are assigned jobs of difficulty [4,4,6,6] and they get profit of [20,20,30,30] seperately.\n" +
                "Notes:\n" +
                "\n" +
                "1 <= difficulty.length = profit.length <= 10000\n" +
                "1 <= worker.length <= 10000\n" +
                "difficulty[i], profit[i], worker[i]  are in range [1, 10^5]\n")
    }


    fun maxProfitAssignment(difficulty: IntArray?, profit: IntArray, worker: IntArray?): Int {
        if (difficulty == null || difficulty.isEmpty() || worker == null || worker.isEmpty()) {
            return 0
        }
        val works = kotlin.arrayOfNulls<Work>(difficulty.size)
        for (i in difficulty.indices) {
            works[i] = Work(difficulty[i], profit[i])
        }
        Arrays.sort<Work>(works) { w1, w2 -> w1.diff - w2.diff }
        Arrays.sort(worker)
        var workerIndex = 0
        var workIndex = 0
        var mostWorkProfit = 0
        var result = 0
        while (workerIndex < worker.size) {
            val workerAbi = worker[workerIndex]
            while (workIndex < works.size) {
                if (works[workIndex]!!.diff <= workerAbi) {
                    mostWorkProfit = Math.max(mostWorkProfit, works[workIndex]!!.profit)
                    workIndex++
                } else {
                    break
                }
            }
            result += mostWorkProfit
            workerIndex++
        }
        return result
    }

    internal inner class Work(var diff: Int, var profit: Int)
}
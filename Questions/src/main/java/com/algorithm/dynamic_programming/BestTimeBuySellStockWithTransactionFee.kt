package com.algorithm.dynamic_programming

import com.algorithm.AlgorithmQuestion

class BestTimeBuySellStockWithTransactionFee : AlgorithmQuestion {
    override fun printDescription() {
        System.out.println("Your are given an array of integers prices, for which the i-th element is the price of a given stock on day i; and a non-negative integer fee representing a transaction fee.\n" +
                "\n" +
                "You may complete as many transactions as you like, but you need to pay the transaction fee for each transaction. You may not buy more than 1 share of a stock at a time (ie. you must sell the stock share before you buy again.)\n" +
                "\n" +
                "Return the maximum profit you can make.\n" +
                "\n" +
                "Example 1:\n" +
                "Input: prices = [1, 3, 2, 8, 4, 9], fee = 2\n" +
                "Output: 8\n" +
                "Explanation: The maximum profit can be achieved by:\n" +
                "Buying at prices[0] = 1\n" +
                "Selling at prices[3] = 8\n" +
                "Buying at prices[4] = 4\n" +
                "Selling at prices[5] = 9\n" +
                "The total profit is ((8 - 1) - 2) + ((9 - 4) - 2) = 8.\n" +
                "Note:\n" +
                "\n" +
                "0 < prices.length <= 50000.\n" +
                "0 < prices[i] < 50000.\n" +
                "0 <= fee < 50000.\n")
    }

    fun maxProfit(prices: IntArray?, fee: Int): Int {
        if (prices == null || prices.size < 2) {
            return 0
        }

        val buy = IntArray(prices.size)
        val hold = IntArray(prices.size)
        val skip = IntArray(prices.size)
        val sell = IntArray(prices.size)
        buy[0] = -prices[0]
        hold[0] = -prices[0]

        for (i in 1 until prices.size) {
            buy[i] = Math.max(skip[i - 1], sell[i - 1]) - prices[i]
            hold[i] = Math.max(buy[i - 1], hold[i - 1])
            skip[i] = Math.max(skip[i - 1], sell[i - 1])
            sell[i] = Math.max(buy[i - 1], hold[i - 1]) + prices[i] - fee
        }

        return Math.max(Math.max(buy[prices.size - 1], hold[prices.size - 1]), Math.max(skip[prices.size - 1], sell[prices.size - 1]))
    }
}
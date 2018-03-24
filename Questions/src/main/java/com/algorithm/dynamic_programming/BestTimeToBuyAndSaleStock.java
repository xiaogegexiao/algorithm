package com.algorithm.dynamic_programming;

import com.algorithm.AlgorithmQuestion;

public class BestTimeToBuyAndSaleStock implements AlgorithmQuestion {
    @Override
    public void printDescription() {
        System.out.println("Say you have an array for which the ith element is the price of a given stock on day i.\n" +
                "\n" +
                "If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock), design an algorithm to find the maximum profit.\n" +
                "\n" +
                "Example 1:\n" +
                "Input: [7, 1, 5, 3, 6, 4]\n" +
                "Output: 5\n" +
                "\n" +
                "max. difference = 6-1 = 5 (not 7-1 = 6, as selling price needs to be larger than buying price)\n" +
                "Example 2:\n" +
                "Input: [7, 6, 4, 3, 1]\n" +
                "Output: 0\n" +
                "\n" +
                "In this case, no transaction is done, i.e. max profit = 0.");
    }

    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int len = prices.length;

        int[] diff = new int[len];
        for (int i = 1; i < len; i++) {
            diff[i] = prices[i] - prices[i - 1];
        }

        int res = Integer.MIN_VALUE;
        int sum = 0;
        int minPre = Integer.MAX_VALUE;

        for (int i = 0; i < len; i++) {
            sum += diff[i];
            minPre = Math.min(minPre, sum - diff[i]);
            res = Math.max(res, sum - minPre);
        }

        return res;
    }
}

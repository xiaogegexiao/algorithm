package com.algorithm.dynamic_programming;

import com.algorithm.AlgorithmQuestion;

import java.util.Scanner;

public class StockMarket implements AlgorithmQuestion {
    @Override
    public void printDescription() {

    }

    public static void main(String[] args) throws java.lang.Exception {
        // input:
        Scanner in = new Scanner(System.in);
        String prices = in.nextLine();

        String gain = "";

        // Put answer in 'gain'
        String[] priceStrs = prices.split(",");
        int[] priceDiffInt = new int[priceStrs.length];
        for (int i = 0; i < priceStrs.length; i++) {
            if (i == 0) {
                // first day, we assume that you cannot sell at the first day, then the diff to previous day is 0
                priceDiffInt[i] = 0;
            } else {
                // calculate price diff to previous day
                priceDiffInt[i] = Integer.parseInt(priceStrs[i]) - Integer.parseInt(priceStrs[i - 1]);
            }
        }

        int[] sums = new int[priceDiffInt.length];
        // minPre for dynamically record the minimum previous sum
        int minPre = 0;
        int result = Integer.MIN_VALUE;
        for (int i = 0; i < priceDiffInt.length; i++) {
            if (i == 0) {
                sums[i] = priceDiffInt[i];
            } else {
                sums[i] = sums[i - 1] + priceDiffInt[i];
            }
            result = Math.max(result, sums[i] - minPre);
            minPre = Math.min(minPre, sums[i]);
        }
        gain = String.valueOf(result);
        System.out.println(gain);
    }
}

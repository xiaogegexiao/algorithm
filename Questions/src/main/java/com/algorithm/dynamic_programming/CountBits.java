package com.algorithm.dynamic_programming;

import com.algorithm.AlgorithmQuestion;

public class CountBits implements AlgorithmQuestion {
    @Override
    public void printDescription() {
        System.out.println("Given a non negative integer number num. For every numbers i in the range 0 ≤ i ≤ num calculate the number of 1's in their binary representation and return them as an array.\n" +
                "\n" +
                "Have you met this question in a real interview? \n" +
                "Example\n" +
                "Given num = 5 you should return [0,1,1,2,1,2].\n" +
                "\n" +
                "Challenge \n" +
                "It is very easy to come up with a solution with run time O(n*sizeof(integer)). But can you do it in linear time O(n) /possibly in a single pass?\n" +
                "Space complexity should be O(n).\n" +
                "Can you do it like a boss? Do it without using any builtin function like __builtin_popcount in c++ or in any other language.");
    }

    /**
     * @param num: a non negative integer number
     * @return: an array represent the number of 1's in their binary
     */
    public int[] countBits(int num) {
        if (num < 0) {
            return null;
        }

        int[] result = new int[num + 1];
        result[0] = 0;
        for (int i = 1; i <= num; i++) {
            result[i] = (i & 1) + result[i >> 1];
        }
        return result;
    }
}

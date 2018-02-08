package com.algorithm.twoPointers;

import com.algorithm.AlgorithmQuestion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum implements AlgorithmQuestion {
    @Override
    public void printDescription() {
        System.out.println("Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d = target?\n" +
                "\n" +
                "Find all unique quadruplets in the array which gives the sum of target.\n" +
                "\n" +
                " Notice\n" +
                "Elements in a quadruplet (a,b,c,d) must be in non-descending order. (ie, a ≤ b ≤ c ≤ d)\n" +
                "The solution set must not contain duplicate quadruplets.\n" +
                "Given array S = {1 0 -1 0 -2 2}, and target = 0. A solution set is:\n" +
                "\n" +
                "(-1, 0, 0, 1)\n" +
                "(-2, -1, 1, 2)\n" +
                "(-2, 0, 0, 2)");
    }

    /*
     * @param numbers: Give an array
     * @param target: An integer
     * @return: Find all unique quadruplets in the array which gives the sum of zero
     */
    public List<List<Integer>> fourSum(int[] numbers, int target) {
        if (numbers == null || numbers.length < 4) {
            return new ArrayList<>();
        }

        Arrays.sort(numbers);
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < numbers.length; i++) {
            if (i != 0 && numbers[i] == numbers[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < numbers.length; j++) {
                if (j != i + 1 && numbers[j] == numbers[j - 1]) {
                    continue;
                }
                int l = j + 1;
                int r = numbers.length - 1;
                while (l < r) {
                    if (l != j + 1 && numbers[l] == numbers[l - 1]) {
                        l++;
                        continue;
                    }
                    if (r != numbers.length - 1 && numbers[r] == numbers[r + 1]) {
                        r--;
                        continue;
                    }
                    int sum = numbers[i] + numbers[j] + numbers[l] + numbers[r];
                    if (sum > target) {
                        r--;
                    } else if (sum < target) {
                        l++;
                    } else {
                        result.add(Arrays.asList(numbers[i], numbers[j], numbers[l], numbers[r]));
                        l++;
                        r--;
                    }
                }
            }
        }
        return result;
    }
}

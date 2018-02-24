package com.algorithm.datastructure;

import com.algorithm.AlgorithmQuestion;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSeq implements AlgorithmQuestion{

    @Override
    public void printDescription() {
        System.out.println("Given an unsorted array of integers, find the length of the longest consecutive elements sequence.\n" +
                "\n" +
                "Have you met this question in a real interview? \n" +
                "Clarification\n" +
                "Your algorithm should run in O(n) complexity.\n" +
                "\n" +
                "Example\n" +
                "Given [100, 4, 200, 1, 3, 2],\n" +
                "The longest consecutive elements sequence is [1, 2, 3, 4]. Return its length: 4.");
    }

    /**
     * @param num: A list of integers
     * @return: An integer
     */
    public int longestConsecutive(int[] num) {
        Set<Integer> set = new HashSet<>();
        for (int n : num) {
            set.add(n);
        }

        int longest = 0;
        for (int n : num) {
            set.remove(n);
            int down = n - 1;
            while (set.contains(down)) {
                set.remove(down);
                down--;
            }

            int up = n + 1;
            while (set.contains(up)) {
                set.remove(up);
                up++;
            }
            longest = Math.max(longest, up - down - 1);
        }
        return longest;
    }
}

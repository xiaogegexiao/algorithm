package com.algorithm.dynamic_programming;

import com.algorithm.AlgorithmQuestion;

public class PalindromeSubstrings implements AlgorithmQuestion {
    @Override
    public void printDescription() {
        System.out.println("Given a string, your task is to count how many palindromic substrings in this string.\n" +
                "\n" +
                "The substrings with different start indexes or end indexes are counted as different substrings even they consist of same characters.\n" +
                "\n" +
                "Example 1:\n" +
                "Input: \"abc\"\n" +
                "Output: 3\n" +
                "Explanation: Three palindromic strings: \"a\", \"b\", \"c\".\n" +
                "Example 2:\n" +
                "Input: \"aaa\"\n" +
                "Output: 6\n" +
                "Explanation: Six palindromic strings: \"a\", \"a\", \"a\", \"aa\", \"aa\", \"aaa\".\n" +
                "Note:\n" +
                "The input string length won't exceed 1000.");
    }

    public int countSubstrings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        // a->b = (a->b ? 1 : 0) + (a+1->b + a->b-1 - a+1>b-1)

        int len = s.length();
        int[][] matrix = new int[len + 1][len + 1];
        boolean[][] palindrome = new boolean[len + 1][len + 1];
        for (int i = 0; i < len + 1; i++) {
            palindrome[i][i] = true;
            if (i < len) {
                matrix[i][i + 1] = 1;
                palindrome[i][i + 1] = true;
            }
        }
        for (int step = 2; step <= len; step++) {
            for (int i = 0; i < len - step + 1; i++) {
                int j = i + step;
                palindrome[i][j] = (s.charAt(i) == s.charAt(j - 1)) && palindrome[i + 1][j - 1];
                matrix[i][j] = (palindrome[i][j] ? 1 : 0) + matrix[i + 1][j] + matrix[i][j - 1] - matrix[i + 1][j - 1];
            }
        }
        return matrix[0][len];
    }
}

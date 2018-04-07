package com.algorithm.dfs;

import com.algorithm.AlgorithmQuestion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class FindRightTermsNumber implements AlgorithmQuestion {
    @Override
    public void printDescription() {

    }

    public static void main(String[] args) throws java.lang.Exception {
        // input:
        // l : string L
        // s : string s
        Scanner in = new Scanner(System.in);
        String l = in.nextLine();
        String s = in.nextLine();

        // write your code here
        // store your results in `t`
        String[] lStrs = l.split(",");
        int[] lInts = new int[lStrs.length];
        for (int i = 0; i < lStrs.length; i++) {
            lInts[i] = Integer.parseInt(lStrs[i]);
        }
        int sInt = Integer.parseInt(s);
//        Arrays.sort(lInts);
        System.out.println(Arrays.toString(lInts));
        int[] result = new int[1];
        dfs(new ArrayList<>(), lInts, 0, sInt, result);
        String t = String.valueOf(result[0]);

        // output
        System.out.println(t);
    }

    // dfs for recursively looking deeper to check
    static void dfs(List<Integer> prev, int[] lInts, int index, int rest, int[] result) {
        if (rest == 0) {
            System.out.println(prev.toString());
            result[0]++;
            return;
        }
        if (rest < 0) {
            return;
        }
        if (index >= lInts.length) {
            return;
        }
        for (int i = index; i < lInts.length; i++) {
//            if (lInts[i] > rest) {
//                return;
//            }
//            if (i != index && lInts[i] == lInts[i - 1]) {
//                continue;
//            }
            if (i == index || lInts[i] != lInts[i - 1]) {
                prev.add(lInts[i]);
                dfs(prev, lInts, i + 1, rest - lInts[i], result);
                prev.remove(prev.size() - 1);
            }
        }
    }
}
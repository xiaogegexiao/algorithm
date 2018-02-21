package com.algorithm.datastructure;

import com.algorithm.AlgorithmQuestion;

import java.util.*;

public class TopKLargestNumberII implements AlgorithmQuestion {
    @Override
    public void printDescription() {
        System.out.println("Implement a data structure, provide two interfaces:\n" +
                "\n" +
                "1, add(number). Add a new number in the data structure.\n" +
                "2, topk(). Return the top k largest numbers in this data structure. k is given when we create the data structure.");
    }

    public static class Solution {
        Queue<Integer> curtQueue;

        int size = 0;
        /*
         * @param k: An integer
         */
        public Solution(int k) {
            size = k;
            curtQueue = new PriorityQueue<>(k + 1);
        }

        /*
         * @param num: Number to be added
         * @return: nothing
         */
        public void add(int num) {
            curtQueue.offer(num);
            if (curtQueue.size() > size) {
                curtQueue.poll();
            }
        }

        /*
         * @return: Top k element
         */
        public List<Integer> topk() {
            List<Integer> list = new ArrayList<>();
            Iterator<Integer> iter = curtQueue.iterator();
            while (iter.hasNext()) {
                list.add(iter.next());
            }
            Collections.sort(list, Collections.reverseOrder());
            return list;
        }
    }
}

package com.algorithm.datastructure;

import com.algorithm.AlgorithmQuestion;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class MergeKSortedArray implements AlgorithmQuestion {
    @Override
    public void printDescription() {
        System.out.println("Given k sorted integer arrays, merge them into one sorted array.\n" +
                "Example\n" +
                "Given 3 sorted arrays:\n" +
                "\n" +
                "[\n" +
                "  [1, 3, 5, 7],\n" +
                "  [2, 4, 6],\n" +
                "  [0, 8, 9, 10, 11]\n" +
                "]\n" +
                "return [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11].\n" +
                "\n" +
                "Challenge \n" +
                "Do it in O(N log k).\n" +
                "\n" +
                "N is the total number of integers.\n" +
                "k is the number of arrays.");
    }

    class Element {
        int row;
        int index;
        int val;
        public Element(int row, int index, int val) {
            this.row = row;
            this.index = index;
            this.val = val;
        }
    }

    /**
     * @param arrays: k sorted integer arrays
     * @return: a sorted array
     */
    public int[] mergekSortedArrays(int[][] arrays) {
        Queue<Element> queue = new PriorityQueue<>(arrays.length, new Comparator<Element>(){
            @Override
            public int compare(Element e1, Element e2) {
                return e1.val - e2.val;
            }
        });
        int totalLen = 0;

        for (int i = 0; i < arrays.length; i++) {
            if (arrays[i] != null && arrays[i].length > 0) {
                queue.offer(new Element(i, 0, arrays[i][0]));
                totalLen += arrays[i].length;
            }
        }

        int[] resArr = new int[totalLen];
        int resIndex = 0;
        while (!queue.isEmpty()) {
            Element e = queue.poll();
            resArr[resIndex++] = e.val;
            if (arrays[e.row].length > e.index + 1) {
                e.index += 1;
                e.val = arrays[e.row][e.index];
                queue.offer(e);
            }
        }

        return resArr;
    }
}

package com.algorithm.datastructure;

import com.algorithm.AlgorithmQuestion;

public class Heapify implements AlgorithmQuestion{
    @Override
    public void printDescription() {
        System.out.println("Given an integer array, heapify it into a min-heap array.\n" +
                "\n" +
                "For a heap array A, A[0] is the root of heap, and for each A[i], A[i * 2 + 1] is the left child of A[i] and A[i * 2 + 2] is the right child of A[i].\n" +
                "Clarification\n" +
                "What is heap?\n" +
                "\n" +
                "Heap is a data structure, which usually have three methods: push, pop and top. where \"push\" add a new element the heap, \"pop\" delete the minimum/maximum element in the heap, \"top\" return the minimum/maximum element.\n" +
                "\n" +
                "What is heapify?\n" +
                "Convert an unordered integer array into a heap array. If it is min-heap, for each element A[i], we will get A[i * 2 + 1] >= A[i] and A[i * 2 + 2] >= A[i].\n" +
                "\n" +
                "What if there is a lot of solutions?\n" +
                "Return any of them.\n" +
                "Example\n" +
                "Given [3,2,1,4,5], return [1,2,3,4,5] or any legal heap array.\n" +
                "\n" +
                "Challenge \n" +
                "O(n) time complexity");
    }

    /*
     * @param A: Given an integer array
     * @return: nothing
     */
    public void heapify(int[] A) {
        helper(A, 0);
    }

    private void helper(int[] A, int offset) {
        if (A.length <= offset) {
            return;
        }

        helper(A, 2 * offset + 1);
        helper(A, 2 * offset + 2);
        shift(A, offset);
    }

    private void shift(int[] A, int offset) {
        if (A.length <= offset) {
            return;
        }
        int left = offset * 2 + 1;
        int right = offset * 2 + 2;
        int changeIndex = 0;
        if (right < A.length) {
            changeIndex = A[left] > A[right] ? right : left;
            if (A[offset] > A[changeIndex]) {
                swap(A, offset, changeIndex);
                shift(A, changeIndex);
            }
        } else if (left < A.length) {
            changeIndex = left;
            if (A[offset] > A[changeIndex]) {
                swap(A, offset, changeIndex);
                shift(A, changeIndex);
            }
        }
    }

    private void swap(int[] A, int left, int right) {
        int temp = A[left];
        A[left] = A[right];
        A[right] = temp;
    }
}

package com.algorithm.datastructure;

import com.algorithm.AlgorithmQuestion;

import java.util.PriorityQueue;
import java.util.Queue;

public class KLargestNumberElementII implements AlgorithmQuestion{
    @Override
    public void printDescription() {
        System.out.println("Find K-th largest element in an array. and N is much larger than k.\nExample\n" +
                "In array [9,3,2,4,8], the 3rd largest element is 4.\n" +
                "\n" +
                "In array [1,2,3,4,5], the 1st largest element is 5, 2nd largest element is 4, 3rd largest element is 3 and etc.");
    }

    /*
     * @param nums: an integer unsorted array
     * @param k: an integer from 1 to n
     * @return: the kth largest element
     */
    public int kthLargestElement2(int[] nums, int k) {
        Queue<Integer> queue = new PriorityQueue<>();
        for (int num : nums) {
            queue.offer(num);
            if (queue.size() > k) {
                queue.poll();
            }
        }
        return queue.poll();
    }
}

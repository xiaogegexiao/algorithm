package com.algorithm.twoPointers;

import com.algorithm.AlgorithmQuestion;

public class KthSmallestNumber implements AlgorithmQuestion {
    @Override
    public void printDescription() {
        System.out.print("Find the kth smallest numbers in an unsorted integer array.\n" +
                "Example\n" +
                "Given [3, 4, 1, 2, 5], k = 3, the 3rd smallest numbers are [1, 2, 3].\n" +
                "Challenge \n" +
                "An O(nlogn) algorithm is acceptable, if you can do it in O(n), that would be great.");
    }

    /*
     * @param k: An integer
     * @param nums: An integer array
     * @return: kth smallest element
     */
    public int kthSmallest(int k, int[] nums) {
        if (nums == null || nums.length < k || k <= 0) {
            return 0;
        }

        return kthSmallest(k - 1, 0, nums.length - 1, nums);
    }

    private int kthSmallest(int k, int start, int end, int[] nums) {
        int l = start;
        int r = end;
        int m = l;

        int pivot = nums[(start + end) / 2];

        while (m <= r) {
            if (nums[m] < pivot) {
                swap(nums, l, m);
                l++;
                m++;
            } else if (nums[m] > pivot) {
                swap(nums, m, r);
                r--;
            } else {
                m++;
            }
        }
        if (k >= start && k < l) {
            return kthSmallest(k, start, l - 1, nums);
        } else if (k > r && k <= end) {
            return kthSmallest(k, r + 1, end, nums);
        } else {
            return nums[k];
        }
    }

    private void swap(int[] nums, int l, int r) {
        int temp = nums[l];
        nums[l] = nums[r];
        nums[r] = temp;
    }
}

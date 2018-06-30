package com.algorithm.datastructure

import com.algorithm.AlgorithmQuestion

class MedianOfKSortedArrayByMediamOf2SortedArray : AlgorithmQuestion {
    override fun printDescription() {
        System.out.println("931. Median of K Sorted Arrays\n" +
                "There are k sorted arrays nums. Find the median of the given k sorted arrays.\n" +
                "\n" +
                "Example\n" +
                "Given nums = [[1],[2],[3]], return 2.00.")
    }

    /**
     * @param nums: the given k sorted arrays
     * @return: the median of the given k sorted arrays
     */
    fun findMedian(nums: Array<IntArray>?): Double {
        if (nums == null || nums.size == 0) {
            return 0.0
        }
        val A = mergeArray(nums, 0, nums.size / 2 - 1)
        val B = mergeArray(nums, nums.size / 2, nums.size - 1)
        return findMedianSortedArrays(A, B)
    }

    fun mergeArray(nums: Array<IntArray>, sIndex: Int, eIndex: Int): IntArray? {
        if (sIndex > eIndex) {
            return IntArray(0)
        }
        if (sIndex == eIndex) {
            return nums[sIndex]
        }
        val A = mergeArray(nums, sIndex, (sIndex + eIndex) / 2)
        val B = mergeArray(nums, (sIndex + eIndex) / 2 + 1, eIndex)
        if (A == null || A.isEmpty()) {
            return B
        }
        if (B == null || B.isEmpty()) {
            return A
        }
        val aLen = A.size
        val bLen = B.size
        val res = IntArray(aLen + bLen)
        var aIndex = 0
        var bIndex = 0
        var rIndex = 0
        while (aIndex < A.size && bIndex < B.size) {
            if (A[aIndex] < B[bIndex]) {
                res[rIndex++] = A[aIndex++]
            } else {
                res[rIndex++] = B[bIndex++]
            }
        }
        while (aIndex < A.size) {
            res[rIndex++] = A[aIndex++]
        }
        while (bIndex < B.size) {
            res[rIndex++] = B[bIndex++]
        }
        return res
    }

    /*
     * @param A: An integer array
     * @param B: An integer array
     * @return: a double whose format is *.5 or *.0
     */
    fun findMedianSortedArrays(A: IntArray?, B: IntArray?): Double {
        val aLen = A!!.size
        val bLen = B!!.size
        if (aLen + bLen <= 0) {
            return 0.0
        }
        return if ((aLen + bLen) % 2 == 0) {
            (findKthNumber(A, 0, B, 0, (aLen + bLen) / 2) + findKthNumber(A, 0, B, 0, (aLen + bLen) / 2 + 1)) / 2.0
        } else {
            findKthNumber(A, 0, B, 0, (aLen + bLen) / 2 + 1).toDouble()
        }
    }

    fun findKthNumber(A: IntArray, aIndex: Int, B: IntArray, bIndex: Int, k: Int): Int {
        if (aIndex == A.size) {
            return B[bIndex + k - 1]
        } else if (bIndex == B.size) {
            return A[aIndex + k - 1]
        } else if (k == 1) {
            return if (A[aIndex] > B[bIndex]) B[bIndex] else A[aIndex]
        }

        val l = k / 2
        var aAttemp = 0
        var bAttemp = 0
        if (aIndex + l > A.size) {
            aAttemp = A.size - 1
            bAttemp = bIndex + k - (A.size - aIndex) - 1
        } else if (bIndex + l > B.size) {
            bAttemp = B.size - 1
            aAttemp = aIndex + k - (B.size - bIndex) - 1
        } else {
            aAttemp = aIndex + l - 1
            bAttemp = bIndex + k - l - 1
        }
        return if (A[aAttemp] > B[bAttemp]) {
            findKthNumber(A, aIndex, B, bAttemp + 1, k - (bAttemp - bIndex + 1))
        } else {
            findKthNumber(A, aAttemp + 1, B, bIndex, k - (aAttemp - aIndex + 1))
        }
    }
}
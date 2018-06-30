package com.algorithm.datastructure

import com.algorithm.AlgorithmQuestion

class MedianOfKSortedArrayByBinarySearch : AlgorithmQuestion {
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
        if (nums == null || nums.isEmpty()) {
            return 0.0
        }
        val totalNum = getTotalNum(nums)
        if (totalNum % 2 == 0) {
            return (findKthNumber(nums, totalNum / 2) + findKthNumber(nums, totalNum / 2 + 1)) / 2.0
        } else {
            return findKthNumber(nums, totalNum / 2 + 1).toDouble()
        }
    }

    private fun getTotalNum(nums: Array<IntArray>): Int {
        var res = 0
        for (num in nums) {
            res += num.size
        }
        return res
    }

    private fun findKthNumber(nums: Array<IntArray>, k: Int): Int{
        var start = Int.MIN_VALUE.toLong()
        var end = Int.MAX_VALUE.toLong()

        while (start + 1 < end) {
            var mid: Long = start + (end - start) / 2
            if (getLE(nums, mid) < k) {
                start = mid
            } else {
                end = mid
            }
        }
        val res = if (getLE(nums, start) < k) {
            end
        } else {
            start
        }
        return res.toInt()
    }

    private fun getLE(nums: Array<IntArray>, num: Long): Int {
        var res = 0
        for (numArray in nums) {
            res += getLE(numArray, num)
        }
        return res
    }

    private fun getLE(numArray: IntArray, num: Long): Int {
        var start = 0
        var end = numArray.size - 1
        while (start + 1 < end) {
            var mid = start + (end - start) / 2
            if (numArray[mid] <= num) {
                start = mid
            } else {
                end = mid
            }
        }
        if (numArray[end] <= num) {
            return end + 1
        } else {
            return end
        }
    }
}
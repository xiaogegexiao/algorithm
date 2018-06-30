package com.algorithm.datastructure

import com.algorithm.AlgorithmQuestion
import java.util.ArrayList


class MergeKSortedIntervalListDivideConquer : AlgorithmQuestion {
    override fun printDescription() {
        System.out.println()
    }

    /**
     * Definition of Interval:
     * public classs Interval {
     * int start, end;
     * Interval(int start, int end) {
     * this.start = start;
     * this.end = end;
     * }
     * }
     */

    /**
     * @param intervals: the given k sorted interval lists
     * @return:  the new sorted interval list
     */
    fun mergeKSortedIntervalLists(intervals: List<List<Interval>>): List<Interval>? {
        return mergeKSortedIntervalLists(intervals, 0, intervals.size - 1)
    }

    private fun mergeKSortedIntervalLists(intervals: List<List<Interval>>, start: Int, end: Int): List<Interval>? {
        if (start > end) {
            return ArrayList<Interval>()
        } else if (start == end) {
            return intervals[start]
        } else {
            val mid = (end + start) / 2
            val interval1 = mergeKSortedIntervalLists(intervals, start, mid)
            val interval2 = mergeKSortedIntervalLists(intervals, mid + 1, end)
            return merge2SortedIntervalLists(interval1, interval2)
        }
    }

    private fun merge2SortedIntervalLists(interval1: List<Interval>?, interval2: List<Interval>?): List<Interval>? {
        if (interval1 == null || interval1.isEmpty()) {
            return interval2
        } else if (interval2 == null || interval2.isEmpty()) {
            return interval1
        }
        val list = ArrayList<Interval>()
        var index1 = 0
        var index2 = 0
        var lastEnd = Integer.MIN_VALUE
        while (index1 < interval1.size && index2 < interval2.size) {
            val i1 = interval1[index1]
            val i2 = interval2[index2]
            val temp = Interval(0, 0)
            if (i1.start >= i2.start && i1.start <= i2.end) {
                temp.start = i2.start
                temp.end = Math.max(i2.end, i1.end)
                index1++
                index2++
            } else if (i2.start >= i1.start && i2.start <= i1.end) {
                temp.start = i1.start
                temp.end = Math.max(i2.end, i1.end)
                index1++
                index2++
            } else {
                temp.start = if (i1.start < i2.start) i1.start else i2.start
                temp.end = if (i1.start < i2.start) i1.end else i2.end
                if (i1.start < i2.start) {
                    index1++
                } else {
                    index2++
                }
            }

            if (lastEnd >= temp.start) {
                val removal = list.removeAt(list.size - 1)
                temp.start = Math.min(temp.start, removal.start)
                temp.end = Math.max(temp.end, removal.end)
            }
            list.add(temp)
            lastEnd = temp.end
        }

        while (index1 < interval1.size) {
            val i1 = interval1[index1++]
            val temp = Interval(i1.start, i1.end)
            if (i1.start <= lastEnd) {
                val removal = list.removeAt(list.size - 1)
                temp.start = Math.min(temp.start, removal.start)
                temp.end = Math.max(temp.end, removal.end)
            }
            list.add(temp)
            lastEnd = temp.end
        }

        while (index2 < interval2.size) {
            val i2 = interval2[index2++]
            val temp = Interval(i2.start, i2.end)
            if (i2.start <= lastEnd) {
                val removal = list.removeAt(list.size - 1)
                temp.start = Math.min(temp.start, removal.start)
                temp.end = Math.max(temp.end, removal.end)
            }
            list.add(temp)
            lastEnd = temp.end
        }
        return list
    }

    class Interval(var start: Int, var end: Int)
}
package com.algorithm.datastructure

import com.algorithm.AlgorithmQuestion
import java.util.*


class MergeSortedIntervalListPriorityQueue : AlgorithmQuestion {
    override fun printDescription() {
        System.out.println("577. Merge K Sorted Interval Lists\n" +
                "Merge K sorted interval lists into one sorted interval list. You need to merge overlapping intervals too.\n" +
                "\n" +
                "Example\n" +
                "Given\n" +
                "\n" +
                "[\n" +
                "  [(1,3),(4,7),(6,8)],\n" +
                "  [(1,2),(9,10)]\n" +
                "]\n" +
                "Return\n" +
                "\n" +
                "[(1,3),(4,8),(9,10)]")
    }

    /**
     * @param intervals: the given k sorted interval lists
     * @return:  the new sorted interval list
     */
    internal inner class Pair(var first: Int, var second: Int)

    fun mergeKSortedIntervalLists(intervals: List<List<Interval>>): List<Interval> {
        val queue = PriorityQueue(Comparator<Pair> { p1, p2 -> intervals[p1.first][p1.second].start - intervals[p2.first][p2.second].start })

        for (i in intervals.indices) {
            if (intervals[i].isNotEmpty()) {
                queue.offer(Pair(i, 0))
            }
        }
        val res = ArrayList<Interval>()
        var lastEnd = Integer.MIN_VALUE

        while (!queue.isEmpty()) {
            val p = queue.poll()
            val i = intervals[p!!.first][p.second]
            if (i.start <= lastEnd) {
                val removal = res.removeAt(res.size - 1)
                i.start = Math.min(i.start, removal.start)
                i.end = Math.max(i.end, removal.end)
            }
            res.add(i)
            lastEnd = i.end
            if (intervals[p.first].size > p.second + 1) {
                queue.offer(Pair(p.first, p.second + 1))
            }
        }
        return res
    }

    class Interval(var start: Int, var end: Int)
}
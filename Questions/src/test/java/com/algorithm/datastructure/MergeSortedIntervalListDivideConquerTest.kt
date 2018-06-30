package com.algorithm.datastructure

import com.algorithm.datastructure.MergeKSortedIntervalListDivideConquer.Interval
import org.hamcrest.CoreMatchers.`is`
import org.junit.Assert.assertThat
import org.junit.Test


class MergeSortedIntervalListDivideConquerTest {
    @Test
    fun test() {
        val mergeKSortedIntervalListDivideConquer = MergeKSortedIntervalListDivideConquer()
        mergeKSortedIntervalListDivideConquer.printDescription()
        assertThat(listOf(Interval(1, 13), Interval(14, 53), Interval(57, 61)), `is`(mergeKSortedIntervalListDivideConquer.mergeKSortedIntervalLists(listOf(
                listOf(Interval(2, 5), Interval(9, 13), Interval(16, 28), Interval(32, 53)),
                listOf(Interval(1, 3), Interval(16, 17), Interval(22, 27), Interval(47, 51)),
                listOf(Interval(16, 22), Interval(31, 50), Interval(51, 53), Interval(57, 61)),
                listOf(Interval(1, 9), Interval(17, 20), Interval(23, 25), Interval(27, 34)),
                listOf(Interval(4, 11), Interval(14, 18), Interval(19, 21), Interval(28, 35))
        ))))
    }
}
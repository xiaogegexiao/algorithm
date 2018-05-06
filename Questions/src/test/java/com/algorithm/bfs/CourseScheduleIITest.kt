package com.algorithm.bfs

import org.junit.Assert.assertArrayEquals
import org.junit.Test

class CourseScheduleIITest {
    @Test
    fun test() {
        var courseScheduleII = CourseScheduleII()
        courseScheduleII.printDescription()
        assertArrayEquals(intArrayOf(0, 1), courseScheduleII.findOrder(2, arrayOf(intArrayOf(1, 0))))
    }
}
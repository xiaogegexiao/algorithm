package com.algorithm.bfs

import junit.framework.Assert.assertEquals
import org.junit.Test

class NetworkDelayTimeTest {
    @Test
    fun test() {
        var networkDelayTime = NetworkDelayTime()
        networkDelayTime.printDescription()
        assertEquals(2, networkDelayTime.networkDelayTime(arrayOf(intArrayOf(2, 1, 1), intArrayOf(2, 3, 1), intArrayOf(3, 4, 1)), 4, 2))
    }
}
package com.algorithm.bfs

import junit.framework.Assert.assertEquals
import org.junit.Test

class CheapestFlightsWithinKStopTest {
    @Test
    fun test() {
        var cheapestFlightsWithinKStop = CheapestFlightsWithinKStop();
        cheapestFlightsWithinKStop.printDescription()
        assertEquals(200, cheapestFlightsWithinKStop.findCheapestPrice(3, arrayOf(intArrayOf(0, 1, 100), intArrayOf(1, 2, 100), intArrayOf(0, 2, 500)), 0, 2, 1))
        assertEquals(500, cheapestFlightsWithinKStop.findCheapestPrice(3, arrayOf(intArrayOf(0, 1, 100), intArrayOf(1, 2, 100), intArrayOf(0, 2, 500)), 0, 2, 0))
    }
}
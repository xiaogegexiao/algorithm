package com.algorithm.bfs

import org.junit.Test

class Fast4estWayToDeliverTest {
    @Test
    fun test() {
        val fastestWayToDeliver = FastestWayToDeliver()
        fastestWayToDeliver.printDescription()
        val res = fastestWayToDeliver.fastestway(arrayOf(intArrayOf(0, 0, 1, 0, 0), intArrayOf(0, 1, 0, 0, 0), intArrayOf(0, 0, 0, 1, 1), intArrayOf(1, 1, 0, 0, 0)), intArrayOf(3, 3))
        for (i in res) {
            println("${i[0]}, ${i[1]} -> ")
        }
    }
}
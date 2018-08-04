package com.algorithm.datastructure

import com.algorithm.AlgorithmQuestion
import java.util.*
import kotlin.Comparator
import kotlin.collections.ArrayList

class KClosestLocations : AlgorithmQuestion {
    override fun printDescription() {
        System.out.println("Given a list of Locations ,find k closest locations from start points [0,0]\n")
    }

    fun kClosestLocations(locations: List<List<Int>>, k: Int): List<List<Int>> {
        var queue = PriorityQueue<List<Int>>(Comparator<List<Int>> { o1, o2 ->
            o2[0] * o2[0] + o2[1] * o2[1] - o1[0] * o1[0] - o1[1] * o1[1]
        })

        for (location in locations) {
            queue.offer(location)
            if (queue.size > k) {
                queue.poll()
            }
        }

        var res = ArrayList<List<Int>>()
        while (queue.isNotEmpty()) {
            res.add(queue.poll())
        }
        res.reverse()
        return res
    }
}
package com.algorithm.bfs

import com.algorithm.AlgorithmQuestion
import java.util.*
import kotlin.collections.ArrayList

class FastestWayToDeliver : AlgorithmQuestion {
    override fun printDescription() {
        System.out.println("题目的意思是要去送货，假设是在一个二维的地图上，图上的点也是用List<List<Integer>>表示。每个坐标上的点有三种，0，1，2. 0表示可以到达， 1表示没有路可以去，2表示是要送的货的终点。\n" +
                "每次都是从{0，0}这个点出发。最后要求求出最短的路径\n")
    }

    class Coord(var x: Int = 0, var y: Int = 0) {
        constructor(position: IntArray) : this(position[0], position[1])

        override fun hashCode(): Int {
            return x * 33 + y
        }

        override fun equals(other: Any?): Boolean {
            return if (other is Coord) (x == other.x && y == other.y) else false
        }
    }

    fun fastestway(map: Array<IntArray>, dest: IntArray): List<IntArray> {
        val directionMap = HashMap<Coord, Coord>()
        val queue = LinkedList<Coord>()
        val height = map.size
        val width = map[0].size
        queue.offer(Coord(0, 0))
        var foundDest = false
        while (queue.isNotEmpty() && !foundDest) {
            val qSize = queue.size
            for (i in 0..(qSize - 1)) {
                val coord = queue.poll()
                if (coord == Coord(dest)) {
                    foundDest = true
                    break
                }
                for (j in xDelta.indices) {
                    val newX = coord.x + xDelta[j]
                    val newY = coord.y + yDelta[j]
                    if (newX < 0 || newX >= height || newY < 0 || newY >= width || map[newX][newY] == 1) {
                        continue
                    }
                    map[newX][newY] = 1
                    directionMap[Coord(newX, newY)] = coord
                    queue.offer(Coord(newX, newY))
                }
            }
        }
        return if (!foundDest) {
            emptyList()
        } else {
            val res = ArrayList<IntArray>()
            var current: Coord? = Coord(dest)
            while (current != null && current != Coord(0, 0)) {
                res.add(intArrayOf(current.x, current.y))
                current = directionMap[current]
            }
            res.add(intArrayOf(0, 0))
            res.reverse()
            res
        }
    }

    companion object {
        val xDelta = intArrayOf(0, 1, 0, -1)
        val yDelta = intArrayOf(1, 0, -1, 0)
    }
}
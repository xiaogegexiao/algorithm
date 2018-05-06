package com.algorithm.bfs

import com.algorithm.AlgorithmQuestion
import java.util.ArrayList
import java.util.LinkedList
import java.util.Queue
import java.util.HashMap



class NetworkDelayTime : AlgorithmQuestion{
    override fun printDescription() {
        System.out.println("There are N network nodes, labelled 1 to N.\n" +
                "\n" +
                "Given times, a list of travel times as directed edges times[i] = (u, v, w), where u is the source node, v is the target node, and w is the time it takes for a signal to travel from source to target.\n" +
                "\n" +
                "Now, we send a signal from a certain node K. How long will it take for all nodes to receive the signal? If it is impossible, return -1.\n" +
                "\n" +
                "Note:\n" +
                "N will be in the range [1, 100].\n" +
                "K will be in the range [1, N].\n" +
                "The length of times will be in the range [1, 6000].\n" +
                "All edges times[i] = (u, v, w) will have 1 <= u, v <= N and 1 <= w <= 100.")
    }

    fun networkDelayTime(times: Array<IntArray>, N: Int, K: Int): Int {
        val delayMap = HashMap<Int, MutableList<Delay>>()
        for (time in times) {
            val delayList = (delayMap as Map<Int, MutableList<Delay>>).getOrDefault(time[0], ArrayList())
            delayList.add(Delay(time[1], time[2]))
            delayMap[time[0]] = delayList
        }

        val distanceMap = HashMap<Int, Int>()
        distanceMap[K] = 0

        val queue = LinkedList<Int>()
        queue.offer(K)
        while (!queue.isEmpty()) {
            val curtNode = queue.poll()
            val dList = (delayMap as Map<Int, List<Delay>>).getOrDefault(curtNode, ArrayList())
            for (delay in dList) {
                val time = distanceMap[curtNode]!! + delay.time
                if (time < (distanceMap as Map<Int, Int>).getOrDefault(delay.node, Integer.MAX_VALUE)) {
                    distanceMap[delay.node] = time
                    queue.remove(delay.node)
                    queue.offer(delay.node)
                }
            }
        }

        var result = 0
        for (distance in distanceMap.values) {
            result = Math.max(result, distance)
        }
        return if (distanceMap.size == N) result else -1
    }

    internal inner class Delay(var node: Int, var time: Int)
}
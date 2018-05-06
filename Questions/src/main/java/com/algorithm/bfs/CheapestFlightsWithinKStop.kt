package com.algorithm.bfs

import com.algorithm.AlgorithmQuestion
import java.util.ArrayList
import java.util.HashMap



class CheapestFlightsWithinKStop : AlgorithmQuestion {
    override fun printDescription() {
        System.out.println("There are n cities connected by m flights. Each fight starts from city u and arrives at v with a price w.\n" +
                "\n" +
                "Now given all the cities and fights, together with starting city src and the destination dst, your task is to find the cheapest price from src to dst with up to k stops. If there is no such route, output -1.\n" +
                "\n" +
                "Example 1:\n" +
                "Input: \n" +
                "n = 3, edges = [[0,1,100],[1,2,100],[0,2,500]]\n" +
                "src = 0, dst = 2, k = 1\n" +
                "Output: 200\n" +
                "Explanation: \n" +
                "The graph looks like this:\n" +
                "\n" +
                "\n" +
                "The cheapest price from city 0 to city 2 with at most 1 stop costs 200, as marked red in the picture.\n" +
                "Example 2:\n" +
                "Input: \n" +
                "n = 3, edges = [[0,1,100],[1,2,100],[0,2,500]]\n" +
                "src = 0, dst = 2, k = 0\n" +
                "Output: 500\n" +
                "Explanation: \n" +
                "The graph looks like this:\n" +
                "\n" +
                "\n" +
                "The cheapest price from city 0 to city 2 with at most 0 stop costs 500, as marked blue in the picture.\n" +
                "Note:\n" +
                "\n" +
                "The number of nodes n will be in range [1, 100], with nodes labeled from 0 to n - 1.\n" +
                "The size of flights will be in range [0, n * (n - 1) / 2].\n" +
                "The format of each flight will be (src, dst, price).\n" +
                "The price of each flight will be in the range [1, 10000].\n" +
                "k is in the range of [0, n - 1].\n" +
                "There will not be any duplicated flights or self cycles.\n")
    }

    fun findCheapestPrice(n: Int, flights: Array<IntArray>, src: Int, dst: Int, K: Int): Int {
        val costMap = HashMap<Int,  MutableList<Cost>>()
        for (flight in flights) {
            val costList = (costMap as Map<Int, MutableList<Cost>>).getOrDefault(flight[0], ArrayList())
            costList.add(Cost(flight[1], flight[2]))
            costMap[flight[0]] = costList
        }

        // Queue<Cost> queue = new LinkedList<>();
        // queue.offer(new Cost(src, 0));
        // int result = Integer.MAX_VALUE;
        // int step = 0;
        // while (!queue.isEmpty()) {
        //     int qSize = queue.size();
        //     for (int i = 0; i < qSize; i++) {
        //         Cost curtCost = queue.poll();
        //         List<Cost> cList = costMap.getOrDefault(curtCost.city, new ArrayList<>());
        //         for (Cost cost : cList) {
        //             if (cost.cost + curtCost.cost > result) {
        //                 continue;
        //             }
        //             if (cost.city == dst) {
        //                 result = Math.min(result, cost.cost + curtCost.cost);
        //             }
        //             queue.offer(new Cost(cost.city, cost.cost + curtCost.cost));
        //         }
        //     }
        //     step++;
        //     if (step > K) {
        //         break;
        //     }
        // }
        // return result == Integer.MAX_VALUE ? -1 : result;

        val result = intArrayOf(Integer.MAX_VALUE)
        dfs(costMap, result, 0, src, dst, -1, K)
        return if (result[0] == Integer.MAX_VALUE) -1 else result[0]
    }

    private fun dfs(costMap: Map<Int, List<Cost>>, result: IntArray, curtCost: Int, curtCity: Int, dst: Int, step: Int, stepLimit: Int) {
        if (curtCost > result[0]) {
            return
        }
        if (curtCity == dst) {
            result[0] = Math.min(result[0], curtCost)
            return
        }
        if (step >= stepLimit) {
            return
        }
        val list = costMap.getOrDefault(curtCity, ArrayList())
        for (cost in list) {
            dfs(costMap, result, cost.cost + curtCost, cost.city, dst, step + 1, stepLimit)
        }
    }

    private inner class Cost(var city: Int, var cost: Int)
}
package com.algorithm.binary_tree

import com.algorithm.AlgorithmQuestion

class DeliverMessage: AlgorithmQuestion {
    override fun printDescription() {
        System.out.println("Given the information of a company's personnel. The time spent by the ith person passing the message is t[i] and the list of subordinates is list[i]. When someone receives a message, he will immediately pass it on to all his subordinates. Person numbered 0 is the CEO. Now that the CEO has posted a message, find how much time it takes for everyone in the company to receive the message?\n" +
                "\n" +
                " Notice\n" +
                "The number of employees is n，n <= 1000.\n" +
                "Everyone can have multiple subordinates but only one superior.\n" +
                "Time t[i] <= 10000。\n" +
                "-1 represent no subordinates.\n" +
                "Have you met this question in a real interview? \n" +
                "Example\n" +
                "Given t = [1,2,3], list = [[1,2],[-1],[-1]], return 1.\n" +
                "\n" +
                "Explanation:\n" +
                "The news was passed from the CEO, and the time passed to No. 1 and No. 2 was 1. At this time, all the people in the company received the news.\n" +
                "Given t = [1,2,1,4,5], list = [[1,2],[3,4],[-1],[-1],[-1]], return 3.\n" +
                "\n" +
                "Explanation:\n" +
                "The message was passed from the CEO. The time passed to the No. 1 and No. 2 characters was 1, the time passed to the No. 3 character was 3, and the message passed through 2 to 4 was faster than passing through 1  so the time which is costed for passing to 4 was 2. Finally at the time of 3, everyone received the news.")
    }

    /**
     * @param t: the time of each employee to pass a meeage
     * @param subordinate: the subordinate of each employee
     * @return: the time of the last staff recieve the message
     */

    var cost = 0

    fun deliverMessage(t: IntArray, subordinate: Array<IntArray>): Int {
        if (subordinate[0].isEmpty() || subordinate[0][0] == -1) {
            return 0
        }
        dfs(t, subordinate, 0, t[0])
        return cost
    }

    fun dfs(t: IntArray, sub: Array<IntArray>, person: Int, acost: Int) {
        var acost = acost
        for (subP in sub[person]) {
            if (sub[subP].isEmpty() || sub[subP][0] == -1) {
                cost = Math.max(cost, acost)
                continue
            }
            acost += t[subP]
            dfs(t, sub, subP, acost)
            acost -= t[subP]
        }
    }
}
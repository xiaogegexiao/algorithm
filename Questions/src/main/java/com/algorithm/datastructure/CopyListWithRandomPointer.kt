package com.algorithm.datastructure

import com.algorithm.AlgorithmQuestion
import java.util.*


class CopyListWithRandomPointer : AlgorithmQuestion {
    override fun printDescription() {
        System.out.println("A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.\n" +
                "\n" +
                "Return a deep copy of the list.\n" +
                "\n")
    }

    class RandomListNode(var label: Int, var next: RandomListNode? = null, var random: RandomListNode? = null)

    fun copyRandomList(head: RandomListNode?): RandomListNode? {
        if (head == null) {
            return null
        }
        var curt = head
        val map = HashMap<RandomListNode, RandomListNode>()
        while (curt != null) {
            if (!map.containsKey(curt)) {
                map[curt] = RandomListNode(curt.label)
                curt = curt.next
            } else {
                break
            }
        }

        for (node in map.keys) {
            map[node]!!.next = map[node.next]
            map[node]!!.random = map[node.random]
        }
        return map[head]
    }
}
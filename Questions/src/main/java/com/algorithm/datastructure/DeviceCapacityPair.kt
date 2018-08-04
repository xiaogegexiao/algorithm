package com.algorithm.datastructure

import com.algorithm.AlgorithmQuestion
import java.util.*
import kotlin.collections.ArrayList

class DeviceCapacityPair : AlgorithmQuestion {
    override fun printDescription() {
        System.out.println("Given a device capacity，a list of foreground application, a list background application, every application is tuple： (id, size)。find all pair that  求所有总size加起来不超过device  capacity的foreground和background application的pair。\n" +
                "\n" +
                "For example : foreground application: [[1, 2], [3, 4]],  background application: [[4, 1], [5, 6]]，capacity: 8，this answer should be [[1, 5]] 因为 [1,2 ] 和[5,6] 组合起来刚好能撑满整个capacity。要求返回所有满足pair id。\n")
    }

    fun getAllPairs(foregrounds: List<List<Int>>, backgrounds: List<List<Int>>, capacity: Int): List<List<Int>> {
        Collections.sort(foregrounds, { o1, o2 ->
            o1[1] - o2[1]
        })

        Collections.sort(backgrounds, { o1, o2 ->
            o1[1] - o2[1]
        })
        var bgIndex = backgrounds.size - 1
        val res = ArrayList<List<Int>>()
        for (i in foregrounds.indices) {
            var rest = capacity - foregrounds[i][1]
            var currentBgIndex = bgIndex
            for (j in currentBgIndex downTo 0) {
                if (rest >= backgrounds[j][1]) {
                    bgIndex = j
                    break
                }
            }
            for (j in bgIndex downTo 0) {
                res.add(listOf(foregrounds[i][0], backgrounds[j][0]))
            }
        }
        return res
    }

}
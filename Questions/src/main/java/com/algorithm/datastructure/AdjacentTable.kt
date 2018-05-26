package com.algorithm.datastructure

import com.algorithm.AlgorithmQuestion

class AdjacentTable : AlgorithmQuestion {
    override fun printDescription() {
        System.out.println("Implementation of adjacent table")
    }

    fun constructAdjacentTable(initArray: Array<IntArray>) {
        var aSize = initArray.size
        var uArray = intArrayOf(aSize + 1)
        var wArray = intArrayOf(aSize + 1)
        var vArray = intArrayOf(aSize + 1)
    }
}
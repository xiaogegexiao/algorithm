package com.algorithm.dfs

import org.junit.Test
import java.util.*

class SubsetsTest {
    @Test
    fun test() {
        val subsets = Subsets()
        subsets.printDescription()
        val res = subsets.subsets(intArrayOf(1, 2, 3))
        for (list in res) {
            System.out.println(Arrays.toString(list.toIntArray()))
        }
    }
}
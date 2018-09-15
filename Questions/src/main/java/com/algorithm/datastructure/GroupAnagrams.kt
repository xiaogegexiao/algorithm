package com.algorithm.datastructure

import com.algorithm.AlgorithmQuestion
import java.util.*
import java.util.ArrayList
import java.util.HashMap




class GroupAnagrams : AlgorithmQuestion {
    override fun printDescription() {
        System.out.println("Given an array of strings, group anagrams together.\n" +
                "\n" +
                "Example:\n" +
                "\n" +
                "Input: [\"eat\", \"tea\", \"tan\", \"ate\", \"nat\", \"bat\"],\n" +
                "Output:\n" +
                "[\n" +
                "  [\"ate\",\"eat\",\"tea\"],\n" +
                "  [\"nat\",\"tan\"],\n" +
                "  [\"bat\"]\n" +
                "]\n" +
                "Note:\n" +
                "\n" +
                "All inputs will be in lowercase.\n" +
                "The order of your output does not matter.\n")
    }

    fun groupAnagrams(strs: Array<String>): List<List<String>> {
        val primeNums = intArrayOf(2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101)

        val map = HashMap<Int, MutableList<String>>()
        for (str in strs) {
            val hashCode = calcHashCode(str, primeNums)
            val value = map.getOrDefault(hashCode, ArrayList())
            value.add(str)
            map[hashCode] = value
        }
        val res = ArrayList<List<String>>()
        for (value in map.values) {
            res.add(value)
        }
        return res
    }

    fun calcHashCode(str: String?, primeNums: IntArray): Int {
        var hashCode = 1
        if (str == null) {
            return hashCode
        }
        for (i in 0 until str.length) {
            hashCode *= primeNums[str[i] - 'a']
        }
        return hashCode
    }
}
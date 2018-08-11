package com.algorithm.datastructure

import com.algorithm.AlgorithmQuestion
import java.util.*


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
        val map = HashMap<NoOrderString, ArrayList<String>>()
        for (str in strs) {
            val sortedStr = NoOrderString(str)
            map[sortedStr] = (map as Map<NoOrderString, ArrayList<String>>).getOrDefault(sortedStr, ArrayList())
            map[sortedStr]!!.add(str)
        }

        val res = ArrayList<List<String>>()
        res.addAll(map.values)
        return res
    }

    // private String sort(String str) {
    //     char[] array = str.toCharArray();
    //     Arrays.sort(array);
    //     return new String(array);
    // }

    internal inner class NoOrderString(var value: String) {
        var hashValue = 0
        var map: MutableMap<Int, Int> = HashMap()

        init {
            for (i in 0 until value.length) {
                hashValue += value[i].toInt()
                map[value[i].toInt()] = (map as Map<Int, Int>).getOrDefault(value[i].toInt(), 0) + 1
            }
        }

        override fun hashCode(): Int {
            return hashValue
        }

        override fun equals(o: Any?): Boolean {
            return if (o is NoOrderString) {
                mapEquals(map, o.map)
            } else {
                false
            }
        }

        private fun mapEquals(map1: Map<Int, Int>, map2: Map<Int, Int>): Boolean {
            if (map1.size != map2.size) {
                return false
            } else {
                for (key in map1.keys) {
                    if (map1[key] != map2.getOrDefault(key, 0)) {
                        return false
                    }
                }
            }
            return true
        }
    }
}
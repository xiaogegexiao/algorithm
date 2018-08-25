package com.algorithm.datastructure

import com.algorithm.AlgorithmQuestion

class RandomSet : AlgorithmQuestion {
    override fun printDescription() {
        System.out.println("Design a data structure that supports all following operations in average O(1) time.\n" +
                "\n" +
                "insert(val): Inserts an item val to the set if not already present.\n" +
                "remove(val): Removes an item val from the set if present.\n" +
                "getRandom: Returns a random element from current set of elements. Each element must have the same probability of being returned.\n" +
                "Example:\n" +
                "\n" +
                "// Init an empty set.\n" +
                "RandomizedSet randomSet = new RandomizedSet();\n" +
                "\n" +
                "// Inserts 1 to the set. Returns true as 1 was inserted successfully.\n" +
                "randomSet.insert(1);\n" +
                "\n" +
                "// Returns false as 2 does not exist in the set.\n" +
                "randomSet.remove(2);\n" +
                "\n" +
                "// Inserts 2 to the set, returns true. Set now contains [1,2].\n" +
                "randomSet.insert(2);\n" +
                "\n" +
                "// getRandom should return either 1 or 2 randomly.\n" +
                "randomSet.getRandom();\n" +
                "\n" +
                "// Removes 1 from the set, returns true. Set now contains [2].\n" +
                "randomSet.remove(1);\n" +
                "\n" +
                "// 2 was already in the set, so return false.\n" +
                "randomSet.insert(2);\n" +
                "\n" +
                "// Since 2 is the only number in the set, getRandom always return 2.\n" +
                "randomSet.getRandom();\n")
    }

    val map = HashMap<Int, Int>()
    val list = ArrayList<Int>()
    var count: Int = 0

    fun insert(value: Int): Boolean {
        if (!map.containsKey(value)) {
            list.add(count, value)
            map[value] = count
            count++
            return true
        }
        return false
    }

    fun remove(value: Int): Boolean {
        if (map.containsKey(value)) {
            val position = map.remove(value)
            if (position != count - 1) {
                map[list[count - 1]] = position!!
                list[position] = list[count - 1]
            }
            count --
            return true
        }
        return false
    }

    fun getRandom(): Int {
        if (count == 0) {
            return 0
        }

        val randIndex = (Math.random() * Int.MAX_VALUE).toInt() % count
        return list[randIndex]
    }
}
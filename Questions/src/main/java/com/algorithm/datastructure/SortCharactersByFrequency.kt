package com.algorithm.datastructure

import com.algorithm.AlgorithmQuestion
import java.util.*


class SortCharactersByFrequency : AlgorithmQuestion {
    override fun printDescription() {
        System.out.println("Given a string, sort it in decreasing order based on the frequency of characters.\n" +
                "\n" +
                "Example 1:\n" +
                "\n" +
                "Input:\n" +
                "\"tree\"\n" +
                "\n" +
                "Output:\n" +
                "\"eert\"\n" +
                "\n" +
                "Explanation:\n" +
                "'e' appears twice while 'r' and 't' both appear once.\n" +
                "So 'e' must appear before both 'r' and 't'. Therefore \"eetr\" is also a valid answer.\n" +
                "Example 2:\n" +
                "\n" +
                "Input:\n" +
                "\"cccaaa\"\n" +
                "\n" +
                "Output:\n" +
                "\"cccaaa\"\n" +
                "\n" +
                "Explanation:\n" +
                "Both 'c' and 'a' appear three times, so \"aaaccc\" is also a valid answer.\n" +
                "Note that \"cacaca\" is incorrect, as the same characters must be together.\n" +
                "Example 3:\n" +
                "\n" +
                "Input:\n" +
                "\"Aabb\"\n" +
                "\n" +
                "Output:\n" +
                "\"bbAa\"\n" +
                "\n" +
                "Explanation:\n" +
                "\"bbaA\" is also a valid answer, but \"Aabb\" is incorrect.\n" +
                "Note that 'A' and 'a' are treated as two different characters.")
    }

    fun frequencySort(s: String?): String? {
        if (s == null) {
            return null
        }
        val charArray = s.toCharArray()

        val map = HashMap<Char, Int>()
        for (i in charArray.indices) {
            map[charArray[i]] = (map as Map<Char, Int>).getOrDefault(charArray[i], 0) + 1
        }

        val arrayOfChar = charArray.toTypedArray()
        Arrays.sort(arrayOfChar) { i1, i2 ->
            val frequency = map[i2]!! - map[i1]!!
            if (frequency == 0) {
                i1!! - i2!!
            } else {
                frequency
            }
        }
        return String(arrayOfChar.toCharArray())
    }

    fun fromCharArray(cArray: CharArray): Array<Int> {
        val res = arrayOf<Int>(cArray.size)
        for (i in cArray.indices) {
            res[i] = cArray[i].toInt()
        }
        return res
    }

    fun fromIntArray(iArray: Array<Int>): CharArray {
        val res = CharArray(iArray.size)
        for (i in iArray.indices) {
            res[i] = iArray[i].toChar()
        }
        return res
    }
}
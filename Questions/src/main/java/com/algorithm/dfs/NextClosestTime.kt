package com.algorithm.dfs

import com.algorithm.AlgorithmQuestion
import java.util.ArrayList



class NextClosestTime : AlgorithmQuestion {
    override fun printDescription() {
        System.out.println("862. Next Closest Time\n" +
                "Given a time represented in the format \"HH:MM\", form the next closest time by reusing the current digits. There is no limit on how many times a digit can be reused.\n" +
                "\n" +
                "You may assume the given input string is always valid. For example, \"01:34\", \"12:09\" are all valid. \"1:34\", \"12:9\" are all invalid.\n" +
                "\n" +
                "Example\n" +
                "Given time = \"19:34\", return \"19:39\".\n" +
                "\n" +
                "Explanation: \n" +
                "The next closest time choosing from digits 1, 9, 3, 4, is 19:39, which occurs 5 minutes later.  It is not 19:33, because this occurs 23 hours and 59 minutes later.\n" +
                "Given time = \"23:59\", return \"22:22\".\n" +
                "\n" +
                "Explanation: \n" +
                "The next closest time choosing from digits 2, 3, 5, 9, is 22:22. It may be assumed that the returned time is next day's time since it is smaller than the input time numerically.")
    }

    /**
     * @param time: the given time
     * @return: the next closest time
     */
    fun nextClosestTime(time: String): String? {
        var time = time
        time = time.replace(":", "")
        val charArray = time.toCharArray()
        if (charArray.size != 4) {
            return null
        }

        val digitArray = ArrayList<Int>()
        var smallestInt = Integer.MAX_VALUE
        for (i in 0..3) {
            digitArray.add(charArray[i] - '0')
            smallestInt = Math.min(smallestInt, charArray[i] - '0')
        }
        val currentTime = timeToMinute(digitArray)
        val resultList = ArrayList<Int>()
        dfs(resultList, intArrayOf(Integer.MAX_VALUE), ArrayList(), currentTime, digitArray)
        val sb = StringBuilder()
        if (resultList.size != 4) {
            sb.append(smallestInt.toString())
            sb.append(smallestInt.toString())
            sb.append(":")
            sb.append(smallestInt.toString())
            sb.append(smallestInt.toString())
        } else {
            for (i in 0..3) {
                sb.append(resultList[i].toString())
                if (i == 1) {
                    sb.append(":")
                }
            }
        }
        return sb.toString()
    }

    private fun dfs(gResultDigits: MutableList<Int>, gResult: IntArray, digitArray: MutableList<Int>, compareTo: Int, choiceList: List<Int>) {
        if (digitArray.size == 4) {
            val result = timeToMinute(digitArray)

            if (result != -1 && result > compareTo && result < gResult[0]) {

                gResult[0] = result
                gResultDigits.clear()
                for (i in digitArray) {
                    gResultDigits.add(i)
                }
            }
            return
        }
        for (i in choiceList) {
            digitArray.add(i)
            dfs(gResultDigits, gResult, digitArray, compareTo, choiceList)
            digitArray.removeAt(digitArray.size - 1)
        }
    }

    private fun timeToMinute(list: List<Int>): Int {
        var result = -1
        if (list.size == 4) {
            val hour = list[0] * 10 + list[1]
            val minute = list[2] * 10 + list[3]
            result = if (hour >= 0 && hour < 24 && minute >= 0 && minute < 60) hour * 60 + minute else -1
        }
        return result
    }

}
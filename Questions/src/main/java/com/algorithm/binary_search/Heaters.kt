package com.algorithm.binary_search

import com.algorithm.AlgorithmQuestion
import java.util.Arrays



class Heaters : AlgorithmQuestion{
    override fun printDescription() {
        System.out.println("" +
                "Winter is coming! Your first job during the contest is to design a standard heater with fixed warm radius to warm all the houses.\n" +
                "\n" +
                "Now, you are given positions of houses and heaters on a horizontal line, find out minimum radius of heaters so that all houses could be covered by those heaters.\n" +
                "\n" +
                "So, your input will be the positions of houses and heaters seperately, and your expected output will be the minimum radius standard of heaters.\n" +
                "\n" +
                "Note:\n" +
                "Numbers of houses and heaters you are given are non-negative and will not exceed 25000.\n" +
                "Positions of houses and heaters you are given are non-negative and will not exceed 10^9.\n" +
                "As long as a house is in the heaters' warm radius range, it can be warmed.\n" +
                "All the heaters follow your radius standard and the warm radius will the same.\n" +
                "Example 1:\n" +
                "Input: [1,2,3],[2]\n" +
                "Output: 1\n" +
                "Explanation: The only heater was placed in the position 2, and if we use the radius 1 standard, then all the houses can be warmed.\n" +
                "Example 2:\n" +
                "Input: [1,2,3,4],[1,4]\n" +
                "Output: 1\n" +
                "Explanation: The two heater was placed in the position 1 and 4. We need to use radius 1 standard, then all the houses can be warmed.")
    }

    fun findRadius(houses: IntArray?, heaters: IntArray?): Int {
        if (houses == null || houses.isEmpty()) {
            return 0
        }
        if (heaters == null || heaters.isEmpty()) {
            return -1
        }
        Arrays.sort(houses)
        Arrays.sort(heaters)
        var left = 0
        var right = Math.max(houses[houses.size - 1], heaters[heaters.size - 1])

        while (left + 1 < right) {
            val mid = (right - left) / 2 + left
            var inRange = true
            for (house in houses) {
                if (!houseInRange(house, heaters, mid)) {
                    inRange = false
                    break
                }
            }
            if (inRange) {
                right = mid
            } else {
                left = mid
            }
        }
        for (house in houses) {
            if (!houseInRange(house, heaters, left)) {
                return right
            }
        }
        return left
    }

    private fun houseInRange(house: Int, heaters: IntArray, radius: Int): Boolean {
        if (house < heaters[0] - radius || house > heaters[heaters.size - 1] + radius) {
            return false
        }

        var l = 0
        var r = heaters.size - 1
        while (l + 1 < r) {
            val mid = (r - l) / 2 + l
            val heater = heaters[mid]
            if (house < heater - radius) {
                r = mid
            } else {
                l = mid
            }
        }

        if (house >= heaters[r] - radius && house <= heaters[r] + radius) {
            return true
        }
        return house >= heaters[l] - radius && house <= heaters[l] + radius
    }
}
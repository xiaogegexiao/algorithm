package com.algorithm.twoPointers

import com.algorithm.AlgorithmQuestion

class ContainerWithMostWater : AlgorithmQuestion {
    override fun printDescription() {
        System.out.println("Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis forms a container, such that the container contains the most water.\n" +
                "\n" +
                "Note: You may not slant the container and n is at least 2.\n" +
                "\n")
    }

    fun maxArea(heights: IntArray) : Int {
        if (heights.isEmpty()) {
            return 0
        }

        var l = 0
        var r = heights.size - 1
        var largest = 0
        while (l < r) {
            var size = Math.min(heights[l], heights[r]) * (r - l)
            largest = Math.max(largest, size)
            if (heights[l] > heights[r]) {
                r--
            } else {
                l++
            }
        }
        return largest
    }
}
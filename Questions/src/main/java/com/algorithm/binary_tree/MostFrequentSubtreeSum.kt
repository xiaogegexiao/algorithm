package com.algorithm.binary_tree

import com.algorithm.AlgorithmQuestion
import java.util.HashSet
import java.util.HashMap


class MostFrequentSubtreeSum : AlgorithmQuestion {
    override fun printDescription() {
        System.out.println("Given the root of a tree, you are asked to find the most frequent subtree sum. The subtree sum of a node is defined as the sum of all the node values formed by the subtree rooted at that node (including the node itself). So what is the most frequent subtree sum value? If there is a tie, return all the values with the highest frequency in any order.\n" +
                "\n" +
                "Examples 1\n" +
                "Input:\n" +
                "\n" +
                "  5\n" +
                " /  \\\n" +
                "2   -3\n" +
                "return [2, -3, 4], since all the values happen only once, return all of them in any order.\n" +
                "Examples 2\n" +
                "Input:\n" +
                "\n" +
                "  5\n" +
                " /  \\\n" +
                "2   -5\n" +
                "return [2], since 2 happens twice, however -5 only occur once.\n" +
                "Note: You may assume the sum of values in any subtree is in the range of 32-bit signed integer.\n" +
                "\n")
    }

    class TreeNode(var `val`: Int, var left: TreeNode?, var right: TreeNode?)

    var freqToValmap: MutableMap<Int, MutableSet<Int>> = HashMap()
    var valToFreqmap: MutableMap<Int, Int> = HashMap()

    var frequency = 0
    fun findFrequentTreeSum(root: TreeNode?): IntArray {
        if (root != null) {
            calcSumFrequency(root)
        }
        val set = freqToValmap.getOrDefault(frequency, HashSet())
        val res = IntArray(set.size)
        var index = 0
        for (key in set) {
            res[index++] = key
        }
        return res
    }

    private fun calcSumFrequency(root: TreeNode): Int {
        val `val` = root.`val`
        val leftVal = if (root.left != null) calcSumFrequency(root.left!!) else 0
        val rightVal = if (root.right != null) calcSumFrequency(root.right!!) else 0
        val sum = `val` + leftVal + rightVal
        var freq = valToFreqmap.getOrDefault(sum, 0)
        freqToValmap[freq]?.remove(sum)
        freq++
        if (freq > frequency) {
            frequency = freq
        }
        valToFreqmap[sum] = freq
        val set = freqToValmap.getOrDefault(freq, HashSet())
        set.add(sum)
        freqToValmap[freq] = set
        return sum
    }
}
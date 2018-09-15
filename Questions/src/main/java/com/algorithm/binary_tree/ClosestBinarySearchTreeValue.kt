package com.algorithm.binary_tree

import com.algorithm.AlgorithmQuestion

class ClosestBinarySearchTreeValue : AlgorithmQuestion {
    override fun printDescription() {
        System.out.println("Given a non-empty binary search tree and a target value, find the value in the BST that is closest to the target.\n" +
                "\n" +
                "Example\n" +
                "Given root = {1}, target = 4.428571, return 1.\n" +
                "\n" +
                "Notice\n" +
                "Given target value is a floating point.\n" +
                "You are guaranteed to have only one unique value in the BST that is closest to the target.")
    }

    class TreeNode(var `val`: Int, var left: TreeNode?, var right: TreeNode?)

    var closest = Integer.MAX_VALUE
    fun closestValue(root: TreeNode, target: Double): Int {
        calculateClosest(root, target)
        return closest
    }

    fun calculateClosest(root: TreeNode?, target: Double) {
        if (root == null) {
            return
        }
        if (closest == Integer.MAX_VALUE) {
            closest = root.`val`
        }
        if (Math.abs(root.`val` - target) < Math.abs(closest - target)) {
            closest = root.`val`
        }
        if (target == root.`val`.toDouble()) {
            return
        } else if (target > root.`val`) {
            calculateClosest(root.right, target)
        } else {
            calculateClosest(root.left, target)
        }
    }
}
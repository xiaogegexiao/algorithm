package com.algorithm.dfs

import com.algorithm.AlgorithmQuestion

class CloestInBST : AlgorithmQuestion {
    override fun printDescription() {
        System.out.println("Description\n" +
                "Given a non-empty binary search tree and a target value, find the value in the BST that is closest to the target.\n" +
                "\n" +
                "Given target value is a floating point.\n" +
                "You are guaranteed to have only one unique value in the BST that is closest to the target.\n" +
                "Have you met this question in a real interview?  \n" +
                "Example\n" +
                "Given root = {1}, target = 4.428571, return 1.")
    }

    /**
     * @param root: the given BST
     * @param target: the given target
     * @return: the value in the BST that is closest to the target
     */
    fun closestValue(root: TreeNode, target: Double): Int {
        val result = root.`val`
        var compareRes = root.`val`
        if (target > root.`val` && root.right != null) {
            compareRes = closestValue(root.right!!, target)
        } else if (target < root.`val` && root.left != null) {
            compareRes = closestValue(root.left!!, target)
        }
        return if (Math.abs(result - target) > Math.abs(compareRes - target)) compareRes else result
    }
    // int result = Integer.MAX_VALUE;
    // public int closestValue(TreeNode root, double target) {
    //     if (result == Integer.MAX_VALUE) {
    //         result = root.val;
    //     } else {
    //         result = Math.abs(result - target) > Math.abs(root.val - target) ? root.val : result;
    //     }
    //     if (target > root.val && root.right != null) {
    //         closestValue(root.right, target);
    //     } else if (target < root.val && root.left != null) {
    //         closestValue(root.left, target);
    //     }
    //     return result;
    // }

    inner class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null

        init {
            this.right = null
            this.left = null
        }
    }
}
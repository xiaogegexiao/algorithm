package com.algorithm.binary_search

import com.algorithm.AlgorithmQuestion


class CountCompleteTreeNodes : AlgorithmQuestion {
    override fun printDescription() {
        System.out.println("" +
                "Given a complete binary tree, count the number of nodes.\n" +
                "\n" +
                "Definition of a complete binary tree from Wikipedia:\n" +
                "In a complete binary tree every level, except possibly the last, is completely filled, and all nodes in the last level are as far left as possible. It can have between 1 and 2h nodes inclusive at the last level h.\n" +
                "\n" +
                "http://en.wikipedia.org/wiki/Binary_tree#Types_of_binary_trees")
    }

    /**
     * Definition for a binary tree node.
     */
    class TreeNode(var value: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }


    fun countNodes(root: TreeNode): Int {
        var depth = 0
        var curt: TreeNode? = root
        while (curt != null) {
            depth++
            curt = curt.left
        }
        return countNodes(root, depth)
    }

    fun countNodes(root: TreeNode?, depth: Int): Int {
        if (depth == 0) {
            return 0
        }
        if (depth == 1) {
            return if (root == null) 0 else 1
        }
        val leftInfo = checkFull(root?.left)
        val rightInfo = checkFull(root?.right)
        var result = 0
        if (leftInfo.full && rightInfo.full) {
            result = 1 + (1 shl leftInfo.depth) - 1 + (1 shl rightInfo.depth) - 1
        } else if (leftInfo.full) {
            result = 1 + (1 shl leftInfo.depth) - 1 + countNodes(root?.right, rightInfo.depth)
        } else {
            result = 1 + (1 shl rightInfo.depth) - 1 + countNodes(root?.left, leftInfo.depth)
        }
        return result
    }

    private fun checkFull(root: TreeNode?): TreeInfo {
        var left: TreeNode? = root
        var right: TreeNode? = root
        var depth = 0
        while (left != null && right != null) {
            left = left.left
            right = right.right
            depth++
        }
        val full = left == null && right == null
        while (left != null) {
            left = left.left
            depth++
        }
        return TreeInfo(full, depth)
    }

    inner class TreeInfo(var full: Boolean, var depth: Int)
}
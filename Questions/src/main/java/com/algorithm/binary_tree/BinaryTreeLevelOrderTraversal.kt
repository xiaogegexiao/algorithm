package com.algorithm.binary_tree

import com.algorithm.AlgorithmQuestion
import java.util.ArrayList
import java.util.LinkedList
import java.util.Queue



class BinaryTreeLevelOrderTraversal : AlgorithmQuestion {
    override fun printDescription() {
        System.out.println("Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).\n" +
                "\n" +
                "For example:\n" +
                "Given binary tree [3,9,20,null,null,15,7],\n" +
                "    3\n" +
                "   / \\\n" +
                "  9  20\n" +
                "    /  \\\n" +
                "   15   7\n" +
                "return its level order traversal as:\n" +
                "[\n" +
                "  [3],\n" +
                "  [9,20],\n" +
                "  [15,7]\n" +
                "]")
    }

    class TreeNode(var `val`: Int, var left: TreeNode?, var right: TreeNode?)

    fun levelOrder(root: TreeNode): List<List<Int>> {
        val res = ArrayList<List<Int>>()
        val queue = LinkedList<TreeNode>()
        queue.offer(root)

        while (!queue.isEmpty()) {
            val qSize = queue.size
            val level = ArrayList<Int>()
            var hasNonNull = false
            for (i in 0 until qSize) {
                val node = queue.poll()
                if (node != null) {
                    hasNonNull = true
                    level.add(node.`val`)
                    queue.offer(node.left)
                    queue.offer(node.right)
                }
            }
            if (hasNonNull) {
                res.add(level)
            }
        }
        return res
    }
}
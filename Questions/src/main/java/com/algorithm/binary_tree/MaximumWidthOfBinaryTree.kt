package com.algorithm.binary_tree

import com.algorithm.AlgorithmQuestion
import java.util.LinkedList
import java.util.Queue
import java.util.HashMap



class MaximumWidthOfBinaryTree : AlgorithmQuestion {
    override fun printDescription() {
        System.out.println("Given a binary tree, write a function to get the maximum width of the given tree. The width of a tree is the maximum width among all levels. The binary tree has the same structure as a full binary tree, but some nodes are null.\n" +
                "\n" +
                "The width of one level is defined as the length between the end-nodes (the leftmost and right most non-null nodes in the level, where the null nodes between the end-nodes are also counted into the length calculation.\n" +
                "\n" +
                "Example 1:\n" +
                "Input: \n" +
                "\n" +
                "           1\n" +
                "         /   \\\n" +
                "        3     2\n" +
                "       / \\     \\  \n" +
                "      5   3     9 \n" +
                "\n" +
                "Output: 4\n" +
                "Explanation: The maximum width existing in the third level with the length 4 (5,3,null,9).\n" +
                "Example 2:\n" +
                "Input: \n" +
                "\n" +
                "          1\n" +
                "         /  \n" +
                "        3    \n" +
                "       / \\       \n" +
                "      5   3     \n" +
                "\n" +
                "Output: 2\n" +
                "Explanation: The maximum width existing in the third level with the length 2 (5,3).\n" +
                "Example 3:\n" +
                "Input: \n" +
                "\n" +
                "          1\n" +
                "         / \\\n" +
                "        3   2 \n" +
                "       /        \n" +
                "      5      \n" +
                "\n" +
                "Output: 2\n" +
                "Explanation: The maximum width existing in the second level with the length 2 (3,2).\n" +
                "Example 4:\n" +
                "Input: \n" +
                "\n" +
                "          1\n" +
                "         / \\\n" +
                "        3   2\n" +
                "       /     \\  \n" +
                "      5       9 \n" +
                "     /         \\\n" +
                "    6           7\n" +
                "Output: 8\n" +
                "Explanation:The maximum width existing in the fourth level with the length 8 (6,null,null,null,null,null,null,7).\n" +
                "\n" +
                "\n" +
                "Note: Answer will in the range of 32-bit signed integer.")
    }

    inner class TreeNode(var `val`: Int, var left: TreeNode? = null, var right: TreeNode? = null)

    fun widthOfBinaryTree(root: TreeNode): Int {
        val levelIndexMap = HashMap<TreeNode, Int>()
        traversal(root, 0, true, levelIndexMap)
        val queue = LinkedList<TreeNode>()
        queue.offer(root)
        var res = Integer.MIN_VALUE
        while (!queue.isEmpty()) {
            val qSize = queue.size
            var start = -1
            var end = -1
            for (i in 0 until qSize) {
                val node = queue.poll()
                if (start == -1) {
                    start = levelIndexMap[node]!!
                    end = start
                } else {
                    end = levelIndexMap[node]!!
                }
                if (node!!.left != null) {
                    queue.offer(node.left)
                }
                if (node.right != null) {
                    queue.offer(node.right)
                }
            }
            if (end - start + 1 > res) {
                res = end - start + 1
            }
        }
        return res
    }

    fun traversal(root: TreeNode?, parentIndex: Int, fromParentLeft: Boolean, levelIndexMap: MutableMap<TreeNode, Int>) {
        if (root == null) {
            return
        }
        val currentIndex: Int
        if (fromParentLeft) {
            currentIndex = parentIndex * 2
        } else {
            currentIndex = parentIndex * 2 + 1
        }
        levelIndexMap[root] = currentIndex
        traversal(root.left, currentIndex, true, levelIndexMap)
        traversal(root.right, currentIndex, false, levelIndexMap)
    }
}
package com.algorithm.binary_tree

import com.algorithm.AlgorithmQuestion

class FlattenBinaryTree : AlgorithmQuestion {
    override fun printDescription() {
        System.out.println("Flatten a binary tree to a fake \"linked list\" in pre-order traversal.\n" +
                "\n" +
                "Here we use the right pointer in TreeNode as the next pointer in ListNode.\n" +
                "\n" +
                " Notice\n" +
                "Don't forget to mark the left child of each node to null. Or you will get Time Limit Exceeded or Memory Limit Exceeded.\n" +
                "\n" +
                "Have you met this question in a real interview? \n" +
                "Example\n" +
                "              1\n" +
                "               \\\n" +
                "     1          2\n" +
                "    / \\          \\\n" +
                "   2   5    =>    3\n" +
                "  / \\   \\          \\\n" +
                " 3   4   6          4\n" +
                "                     \\\n" +
                "                      5\n" +
                "                       \\\n" +
                "                        6\n" +
                "Challenge \n" +
                "Do it in-place without any extra memory.\n" +
                "\n")
    }

    inner class TreeNode(var value: Int, var left: TreeNode? = null, var right: TreeNode? = null)

    /**
     * @param root: a TreeNode, the root of the binary tree
     * @return: nothing
     */
    fun flatten(root: TreeNode?) {
        if (root == null) {
            return
        }
        val info = flattenInfo(root)
    }

    private fun flattenInfo(root: TreeNode?): TreeInfo? {
        if (root == null) {
            return null
        }
        val left = flattenInfo(root.left)
        val right = flattenInfo(root.right)
        val result = TreeInfo()
        if (left != null && right != null) {
            left.end!!.right = right.start
            root.right = left.start
            root.left = null
            result.start = root
            result.end = right.end
        } else if (left == null && right != null) {
            root.right = right.start
            result.start = root
            result.end = right.end
        } else if (left != null && right == null) {
            root.right = left.start
            root.left = null
            result.start = root
            result.end = left.end
        } else {
            result.end = root
            result.start = result.end
        }
        return result
    }

    internal inner class TreeInfo {
        var start: TreeNode? = null
        var end: TreeNode? = null
    }
}
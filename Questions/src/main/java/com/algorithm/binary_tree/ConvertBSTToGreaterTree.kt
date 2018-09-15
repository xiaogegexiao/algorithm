package com.algorithm.binary_tree

import com.algorithm.AlgorithmQuestion

class ConvertBSTToGreaterTree : AlgorithmQuestion {
    override fun printDescription() {
        System.out.println("Given a Binary Search Tree (BST), convert it to a Greater Tree such that every key of the original BST is changed to the original key plus sum of all keys greater than the original key in BST.\n" +
                "\n" +
                "Example:\n" +
                "\n" +
                "Input: The root of a Binary Search Tree like this:\n" +
                "              5\n" +
                "            /   \\\n" +
                "           2     13\n" +
                "\n" +
                "Output: The root of a Greater Tree like this:\n" +
                "             18\n" +
                "            /   \\\n" +
                "          20     13")
    }

    class TreeNode(var `val`: Int, var left: TreeNode?, var right: TreeNode?)

    fun convertBST(root: TreeNode): TreeNode {
        bottomUp(root)
        return root
    }

    private fun bottomUp(root: TreeNode?): Int {
        if (root == null) {
            return 0
        }
        val left = if (root.left == null) 0 else bottomUp(root.left)
        val right = if (root.right == null) 0 else bottomUp(root.right)
        val sum = left + right + root.`val`
        root.`val` = root.`val` + right
        topDown(root.left, root.`val`)
        return sum
    }

    private fun topDown(root: TreeNode?, extra: Int) {
        if (root == null) {
            return
        }
        root.`val` += extra
        topDown(root.left, extra)
        topDown(root.right, extra)
    }
}
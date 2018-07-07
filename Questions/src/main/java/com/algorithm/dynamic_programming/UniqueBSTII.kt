package com.algorithm.dynamic_programming

import com.algorithm.AlgorithmQuestion
import java.util.ArrayList



class UniqueBSTII : AlgorithmQuestion {
    override fun printDescription() {
        System.out.println("Given an integer n, generate all structurally unique BST's (binary search trees) that store values 1 ... n.\n" +
                "\n" +
                "Example:\n" +
                "\n" +
                "Input: 3\n" +
                "Output:\n" +
                "[\n" +
                "  [1,null,3,2],\n" +
                "  [3,2,null,1],\n" +
                "  [3,1,null,null,2],\n" +
                "  [2,1,3],\n" +
                "  [1,null,2,null,3]\n" +
                "]\n" +
                "Explanation:\n" +
                "The above output corresponds to the 5 unique BST's shown below:\n" +
                "\n" +
                "   1         3     3      2      1\n" +
                "    \\       /     /      / \\      \\\n" +
                "     3     2     1      1   3      2\n" +
                "    /     /       \\                 \\\n" +
                "   2     1         2                 3")
    }

    inner class TreeNode internal constructor(internal var `val`: Int) {
        internal var left: TreeNode? = null
        internal var right: TreeNode? = null
    }

    fun generateTrees(n: Int): List<TreeNode> {
        val list = ArrayList<TreeNode>()
        if (n == 0) {
            return list
        }
        if (n == 1) {
            val node = TreeNode(1)
            list.add(node)
            return list
        }
        val prev = generateTrees(n - 1)
        for (node in prev) {
            var parent: TreeNode? = null
            var curt: TreeNode? = node
            while (parent != null || curt != null) {
                list.add(insert(node, parent, curt, TreeNode(n)))
                parent = curt
                if (curt != null) {
                    curt = curt.right
                }
            }
        }
        return list
    }

    private fun insert(root: TreeNode, parent: TreeNode?, curt: TreeNode?, insertNode: TreeNode): TreeNode {
        if (parent != null) {
            parent.right = insertNode
        }
        insertNode.left = curt
        val res: TreeNode = if (parent != null) {
            copyTree(root)!!
        } else {
            copyTree(insertNode)!!
        }
        if (parent != null) {
            parent.right = curt
        }
        return res
    }

    private fun copyTree(root: TreeNode?): TreeNode? {
        if (root == null) {
            return null
        }
        val copy = TreeNode(root.`val`)
        copy.left = copyTree(root.left)
        copy.right = copyTree(root.right)
        return copy
    }
}
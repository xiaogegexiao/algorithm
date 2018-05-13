package com.algorithm.dfs

import com.algorithm.AlgorithmQuestion

class InorderPredecessorInBST : AlgorithmQuestion {
    override fun printDescription() {
        System.out.println("Description\n" +
                "Given a binary search tree and a node in it, find the in-order predecessor of that node in the BST.\n" +
                "\n" +
                "If the given node has no in-order predecessor in the tree, return null\n" +
                "\n" +
                "Have you met this question in a real interview?  \n" +
                "Example\n" +
                "Given root = {2,1,3}, p = 1, return null.")
    }

    /**
     * @param root: the given BST
     * @param p: the given node
     * @return: the in-order predecessor of the given node in the BST
     */
    fun inorderPredecessor(root: TreeNode?, p: TreeNode?): TreeNode? {
        if (root == null || p == null) {
            return null
        }
        if (root.`val` >= p.`val`) {
            return inorderPredecessor(root.left, p)
        } else {
            val pre = inorderPredecessor(root.right, p)
            return pre ?: root
        }
    }


    inner class TreeNode(var `val`: Int) {
        var left: TreeNode ? = null
        var right: TreeNode? = null

        init {
            this.right = null
            this.left = null
        }
    }
}
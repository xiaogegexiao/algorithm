package com.algorithm.binary_tree

import com.algorithm.AlgorithmQuestion

class LowestCommonAncestor : AlgorithmQuestion {
    override fun printDescription() {
        System.out.println("Given the root and two nodes in a Binary Tree. Find the lowest common ancestor(LCA) of the two nodes.\n" +
                "\n" +
                "The lowest common ancestor is the node with largest depth which is the ancestor of both nodes.\n" +
                "\n" +
                " Notice\n" +
                "Assume two nodes are exist in tree.\n" +
                "\n" +
                "Have you met this question in a real interview? \n" +
                "Example\n" +
                "For the following binary tree:\n" +
                "\n" +
                "  4\n" +
                " / \\\n" +
                "3   7\n" +
                "   / \\\n" +
                "  5   6\n" +
                "LCA(3, 5) = 4\n" +
                "\n" +
                "LCA(5, 6) = 7\n" +
                "\n" +
                "LCA(6, 7) = 7")
    }


    inner class TreeNode(var value: Int, var left: TreeNode? = null, var right: TreeNode? = null)

    /*
     * @param root: The root of the binary search tree.
     * @param A: A TreeNode in a Binary.
     * @param B: A TreeNode in a Binary.
     * @return: Return the least common ancestor(LCA) of the two nodes.
     */
    fun lowestCommonAncestor(root: TreeNode?, A: TreeNode, B: TreeNode) : TreeNode? {
        return root?.let {
            if (it == A || it == B) {
                it
            } else {
                var left = lowestCommonAncestor(root.left, A, B)
                var right = lowestCommonAncestor(root.right, A, B)
                if (left != null && right != null) {
                    return root
                } else if (left == null && right != null) {
                    return right
                } else if (left != null && right == null) {
                    return left
                } else {
                    return null
                }
            }
        } ?: kotlin.run {
            null
        }
    }
}
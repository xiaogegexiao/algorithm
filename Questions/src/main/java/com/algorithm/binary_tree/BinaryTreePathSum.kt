package com.algorithm.binary_tree

import com.algorithm.AlgorithmQuestion

class BinaryTreePathSum : AlgorithmQuestion {
    override fun printDescription() {
        System.out.println("Given a binary tree, find all paths that sum of the nodes in the path equals to a given number target.\n" +
                "\n" +
                "A valid path is from root node to any of the leaf nodes.\n" +
                "\n" +
                "Have you met this question in a real interview? \n" +
                "Example\n" +
                "Given a binary tree, and target = 5:\n" +
                "\n" +
                "     1\n" +
                "    / \\\n" +
                "   2   4\n" +
                "  / \\\n" +
                " 2   3\n" +
                "return\n" +
                "\n" +
                "[\n" +
                "  [1, 2, 2],\n" +
                "  [1, 4]\n" +
                "]")
    }

    inner class TreeNode(var value: Int, var left: TreeNode? = null, var right: TreeNode? = null)

    /*
     * @param root: the root of binary tree
     * @param target: An integer
     * @return: all valid paths
     */
    fun binaryTreePathSum(root: TreeNode?, target: Int): List<List<Int>> {
        var result = ArrayList<List<Int>>()
        return root?.let {
            var prefix = ArrayList<Int>()
            prefix.add(it.value)
            dfs(result, prefix, it, target - it.value)
            result
        } ?: kotlin.run {
            result
        }
    }

    fun dfs(result: MutableList<List<Int>>, prefix: MutableList<Int>, node: TreeNode, rest: Int) {
        if (node.left == null && node.right == null) {
            if (rest == 0) {
                result.add(ArrayList<Int>(prefix))
            }
            return
        }
        node.left?.let {
            prefix.add(it.value)
            dfs(result, prefix, it, rest - it.value)
            prefix.removeAt(prefix.size - 1)
        }
        node.right?.let {
            prefix.add(it.value)
            dfs(result, prefix, it, rest - it.value)
            prefix.removeAt(prefix.size - 1)
        }
    }
}
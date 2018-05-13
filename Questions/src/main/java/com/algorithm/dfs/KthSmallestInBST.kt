package com.algorithm.dfs

import com.algorithm.AlgorithmQuestion

class KthSmallestInBST : AlgorithmQuestion {
    override fun printDescription() {
        System.out.println("Description\n" +
                "Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.\n" +
                "\n" +
                "You may assume k is always valid, 1 ≤ k ≤ BST's total elements.\n" +
                "\n" +
                "Have you met this question in a real interview?  \n" +
                "Example\n" +
                "Given root = {1,#,2}, k = 2, return 2.\n" +
                "\n" +
                "Challenge\n" +
                "What if the BST is modified (insert/delete operations) often and you need to find the kth smallest frequently? How would you optimize the kthSmallest routine?")
    }

    /**
     * @param root: the given BST
     * @param k: the given k
     * @return: the kth smallest element in BST
     */
    fun kthSmallest(root: TreeNode, k: Int): Int {
        val index = intArrayOf(0)
        val result = IntArray(1)
        dfs(root, index, k, result)
        return result[0]
    }

    fun dfs(root: TreeNode?, index: IntArray, k: Int, result: IntArray) {
        if (root == null) {
            return
        }
        dfs(root.left, index, k, result)
        ++index[0]
        if (index[0] == k) {
            result[0] = root.`val`
            return
        }
        dfs(root.right, index, k, result)
    }

    // public int kthSmallest(TreeNode root, int k) {
    //     TreeNode curt = root;
    //     Stack<TreeNode> stack = new Stack<>();
    //     int index = 0;
    //     while (!stack.isEmpty() || curt != null) {
    //         while (curt != null) {
    //             stack.push(curt);
    //             curt = curt.left;
    //         }
    //         curt = stack.pop();
    //         if (++index == k) {
    //             break;
    //         }
    //         curt = curt.right;
    //     }
    //     return curt.val;
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
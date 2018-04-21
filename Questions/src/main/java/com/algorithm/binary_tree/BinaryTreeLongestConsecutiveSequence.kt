package com.algorithm.binary_tree

import com.algorithm.AlgorithmQuestion

class BinaryTreeLongestConsecutiveSequence : AlgorithmQuestion {
    override fun printDescription() {
        System.out.println("Given a binary tree, find the length of the longest consecutive sequence path.\n" +
                "\n" +
                "The path refers to any sequence of nodes from some starting node to any node in the tree along the parent-child connections. The longest consecutive path need to be from parent to child (cannot be the reverse).")
    }


    class TreeNode(var value: Int, var left: TreeNode? = null, var right: TreeNode? = null)

    inner class Solution {
        /**
         * @param root: the root of binary tree
         * @return: the length of the longest consecutive sequence path
         */
        internal var longest = 0

        fun longestConsecutive(root: TreeNode?): Int {
            return root?.let {
                lc(it)
                longest
            } ?: kotlin.run {
                0
            }
        }

        internal fun lc(root: TreeNode): Int {
            var newDown = 1
            root.left?.let {
                val left = lc(it)
                if (root.value + 1 == it.value) {
                    newDown = Math.max(newDown, left + 1)
                }
            }
            root.right?.let {
                val right = lc(it)
                if (root.value + 1 == it.value) {
                    newDown = Math.max(newDown, right + 1)
                }
            }
            longest = Math.max(longest, newDown)
            return newDown
        }

    }
}
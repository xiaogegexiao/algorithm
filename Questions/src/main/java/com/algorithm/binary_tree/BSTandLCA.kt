package com.algorithm.binary_tree

import com.algorithm.AlgorithmQuestion
import java.util.*

class BSTandLCA : AlgorithmQuestion {
    override fun printDescription() {
        System.out.println("iven a list of numbers, construct a BST from it and find the distance between two nodes.\n" +
                "int bstDistance(int[] values, int node1, int node2)\n" +
                "  Example [1,2,3,4,5,6,7,8] , 3, 4 \n" +
                " returns 3")
    }

    enum class TreeType {
        BST,
        CBT
    }

    class TreeNode(var value: Int, var left: TreeNode? = null, var right: TreeNode? = null)
    class TreeInfo(var lca: TreeNode? = null, var node1Depth: Int = -1, var node2Depth: Int = -1)

    private fun constructCompleteT(values: IntArray, node1: Int, node2: Int): Array<TreeNode> {
        var queue = LinkedList<TreeNode>()
        val root = TreeNode(values[0])
        var tNode1: TreeNode? = null
        var tNode2: TreeNode? = null
        queue.add(root)
        var valueIndex = 1
        while (queue.isNotEmpty()) {
            val size = queue.size
            for (i in 0..(size - 1)) {
                val treeNode = queue.poll()
                if (treeNode.value == node1) {
                    tNode1 = treeNode
                }
                if (treeNode.value == node2) {
                    tNode2 = treeNode
                }
                getTreeNode(values, valueIndex++)?.apply {
                    treeNode.left = this
                    queue.offer(this)
                }
                getTreeNode(values, valueIndex++)?.apply {
                    treeNode.right = this
                    queue.offer(this)
                }
            }
        }
        return arrayOf(root, tNode1!!, tNode2!!)
    }

    private fun constructBST(values: IntArray, node1: Int, node2: Int): Array<TreeNode> {
        var root = TreeNode(values[0])
        var tNode1: TreeNode? = null
        var tNode2: TreeNode? = null
        if (root.value == node1) {
            tNode1 = root
        }
        if (root.value == node2) {
            tNode2 = root
        }
        for (i in 1 until values.size) {
            val node = getTreeNode(values, i)!!
            if (node.value == node1) {
                tNode1 = node
            }
            if (node.value == node2) {
                tNode2 = node
            }
            insertNode(root, node)
        }
        return arrayOf(root, tNode1!!, tNode2!!)
    }

    private fun insertNode(root: TreeNode, node: TreeNode) {
        if (node.value > root.value) {
            if (root.right == null) {
                root.right = node
            } else {
                insertNode(root.right!!, node)
            }
        } else if (node.value < root.value) {
            if (root.left == null) {
                root.left = node
            } else {
                insertNode(root.left!!, node)
            }
        }
    }

    fun bstDistance(values: IntArray, node1: Int, node2: Int, treeType: TreeType): Int {
        if (values.isEmpty()) {
            return 0
        }
        val nodeArray = when (treeType) {
            TreeType.BST -> constructBST(values, node1, node2)
            else -> constructCompleteT(values, node1, node2)
        }

        return lca(nodeArray[0], nodeArray[1], nodeArray[2]).let {
            it.node1Depth + it.node2Depth
        }
    }

    private fun getTreeNode(values: IntArray, index: Int): TreeNode? {
        return if (index >= values.size) null else TreeNode(values[index])
    }

    private fun lca(root: TreeNode, node1: TreeNode, node2: TreeNode): TreeInfo {
        val treeInfo = TreeInfo()

        val leftLca = root.left?.let { lca(it, node1, node2) }
        val rightLca = root.right?.let { lca(it, node1, node2) }

        if (leftLca != null && leftLca.node1Depth != -1 && leftLca.node2Depth != -1) {
            return leftLca
        }

        if (rightLca != null && rightLca.node1Depth != -1 && rightLca.node2Depth != -1) {
            return rightLca
        }

        treeInfo.lca = root
        treeInfo.node1Depth = Math.max(leftLca?.node1Depth ?: -1, rightLca?.node1Depth ?: -1)
        treeInfo.node2Depth = Math.max(leftLca?.node2Depth ?: -1, rightLca?.node2Depth ?: -1)
        if (treeInfo.node1Depth != -1) {
            treeInfo.node1Depth++
        }
        if (treeInfo.node2Depth != -1) {
            treeInfo.node2Depth++
        }
        if (root === node1) {
            treeInfo.node1Depth = 0
        }
        if (root === node2) {
            treeInfo.node2Depth = 0
        }
        return treeInfo
    }
}
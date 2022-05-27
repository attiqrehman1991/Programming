package com.test.programming.faang

import java.util.*

class Solution {
    fun levelOrder(root: TreeNode?): List<List<Int>> {
        val output = mutableListOf<MutableList<Int>>()
        if (root == null) {
            return output
        }

        val queue = LinkedList<TreeNode>()
        queue.add(root)

        while (!queue.isEmpty()) {
            val list = mutableListOf<Int>()
            val size = queue.size
            for (index in 0 until size) {
                val tree = queue.remove()
                list.add(tree.`val`)
                if (tree.left != null) {
                    queue.add(tree.left!!)
                }
                if (tree.right != null) {
                    queue.add(tree.right!!)
                }
            }
            output.add(list)
        }
        return output
    }
}
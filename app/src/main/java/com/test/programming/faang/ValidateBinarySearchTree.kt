package com.test.programming.faang

fun main() {
    val root1 = TreeNode(2)
    root1.left = TreeNode(1)
    root1.right = TreeNode(3)
    if(validateBinarySearchTree(root1))
        println("Yes")
    else
        println("No")

    val root3 = TreeNode(2)
    root3.left = TreeNode(2)
    root3.right = TreeNode(2)
    if(validateBinarySearchTree(root3))
        println("Yes")
    else
        println("No")

    val root4 = TreeNode(2147483647)
    if(validateBinarySearchTree(root4))
        println("Yes")
    else
        println("No")

    val root2 = TreeNode(5)
    root2.left = TreeNode(1)
    root2.right = TreeNode(8)
    root2.right?.left = TreeNode(6)
    root2.right?.right = TreeNode(9)
    if(validateBinarySearchTree(root2))
        println("Yes")
    else
        println("No")
}

fun validateBinarySearchTree(root: TreeNode): Boolean {
    return isValidBST(root, null, null)
}

fun isValidBST(root: TreeNode?, left:Int?, right:Int?): Boolean {
    if(root == null) return true
    if(left != null &&  root.`val` <= left) return false
    if(right !=null && root.`val` >= right ) return false
    return isValidBST(root.left, left, root.`val`) &&  isValidBST(root.right, root.`val`, right)
}
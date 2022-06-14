package sorting

// first create binary search tree
// in-order traversal

class Node(var value: Int = 0, var left: Node? = null, var right: Node? = null)


fun main() {
    var root: Node? = null

    root = insertTree(50, root)
    root = insertTree(30, root)
    root = insertTree(20, root)
    root = insertTree(10, root)
    root = insertTree(70, root)
    root = insertTree(80, root)
    root = insertTree(40, root)
    root = insertTree(60, root)
    root = insertTree(90, root)

    inOrder(root);
}

fun insertTree(value: Int, node: Node?): Node {
    if (node == null)
        return Node(value)

    if (value > node.value)
        node.right = insertTree(value, node.right)
    else
        node.left = insertTree(value, node.left)
    return node
}

fun inOrder(node: Node?) {
    if (node != null) {
        inOrder(node.left)
        println(node.value)
        inOrder(node.right)
    }
}
public class BinaryTree_005_PreorderTreeTraversal {
    /*
     Unlike linked lists, one-dimensional arrays, and other linear data structures which are traversed in linear order,
    trees can be traversed in multiple ways in depth-first order(preorder, inorder, postorder) or breadth-first order
    (level order traversal). Beyond these basic traversals, various more complex or hybrid schemes are possible, such
    as depth-limited searches like iterative deepening depth-first search. In this page, preorder tree traversal is
    discussed in detail.

    Traversing a tree involves iterating over all nodes in some manner. As the tree is not a linear data structure,
    there can be more than one possible next node from a given node, so some nodes must be deferred, i.e., stored in
    some way for later visiting. The traversal can be done iteratively where the deferred nodes are stored in the stack,
    or it can be done by recursion, where the deferred nodes are stored implicitly in the call stack.

    For traversing a (non-empty) binary tree in an preorder fashion, we must do these three things for every node n
    starting from the tree's root:
        (N) Process n itself.
        (L) Recursively traverse its left subtree. When this step is finished, we are back at n again.
        (R) Recursively traverse its right subtree. When this step is finished, we are back at n again

    !!! INORDER -> n L R
     */

    // Recursive function to perform preorder traversal on the tree
    public static void preorder(Node root)
    {
        // return if the current node is empty
        if (root == null) {
            return;
        }

        // Display the data part of the root (or current node)
        System.out.print(root.data + " ");

        // Traverse the left subtree
        preorder(root.left);

        // Traverse the right subtree
        preorder(root.right);
    }

    public static void main(String[] args)
    {
        /* Construct the following tree
                   1
                 /   \
                /     \
               2       3
              /      /   \
             /      /     \
            4      5       6
                  / \
                 /   \
                7     8
        */

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.right.left = new Node(5);
        root.right.right = new Node(6);
        root.right.left.left = new Node(7);
        root.right.left.right = new Node(8);

        preorder(root);
    }
}


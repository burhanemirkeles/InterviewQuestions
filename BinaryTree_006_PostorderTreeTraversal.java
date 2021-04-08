public class BinaryTree_006_PostorderTreeTraversal {
    /*
    Unlike linked lists, one-dimensional arrays, and other linear data structures which are traversed in linear order,
    trees can be traversed in multiple ways in depth-first order(preorder, inorder, postorder) or breadth-first order
    (level order traversal). Beyond these basic traversals, various more complex or hybrid schemes are possible, such
    as depth-limited searches like iterative deepening depth-first search. In this page, postorder tree traversal is
    discussed in detail.

     Traversing a tree involves iterating over all nodes in some manner. As the tree is not a linear data structure,
    there can be more than one possible next node from a given node, so some nodes must be deferred, i.e., stored in
    some way for later visiting. The traversal can be done iteratively where the deferred nodes are stored in the stack,
    or it can be done by recursion, where the deferred nodes are stored implicitly in the call stack.

     For traversing a (non-empty) binary tree in an inorder fashion, we must do these three things for every node n
    starting from the tree's root:
        (L) Recursively traverse its left subtree. When this step is finished, we are back at n again.
        (R) Recursively traverse its right subtree. When this step is finished, we are back at n again.
        (N) Process n itself.

        !!! POSTORDER -> L R n

     */
    // Recursive function to perform postorder traversal on the tree
    public static void postorder(Node root)
    {
        // return if the current node is empty
        if (root == null) {
            return;
        }

        // Traverse the left subtree
        postorder(root.left);

        // Traverse the right subtree
        postorder(root.right);

        // Display the data part of the root (or current node)
        System.out.print(root.data + " ");
    }

    public static void main(String[] args)
    {

         /*
        Code below is a checker for my home exercise based on the book "Data Structures & Problem Solving Using Java, M.A. Weiss" page 682

        Node root = new Node(700);
        root.left = new Node(600);
        root.left.left= new Node(500);
        root.left.left.left = new Node(400);
        root.left.left.right = new Node(550);
        root.left.right = new Node(650);
        root.left.right.left= new Node(625);
        root.left.right.right =new Node(670);
        root.left.right.right.left = new Node(660);
        root.left.right.right.right = new Node(680);
        root.right = new Node(800);
        root.right.right = new Node(900);
        root.right.right.right = new Node(1000);
    */

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

        postorder(root);
    }
}

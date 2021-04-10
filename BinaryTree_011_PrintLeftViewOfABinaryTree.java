import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

public class BinaryTree_011_PrintLeftViewOfABinaryTree {
    /*
    Given a binary tree, write an efficient algorithm to print its left view.

    For example, the left view of the following binary tree is 1, 2, 4, 7:
                                             1
                                           /   \
                                          /     \
                                         2       3
                                          \      /\
                                           4    5  6
                                               / \
                                              7   8
     */
    // Iterative function to print the left view of a given binary tree
    public static void leftViewIterative(Node root)
    {
        // return if the tree is empty
        if (root == null) {
            return;
        }

        // create an empty queue and enqueue the root node
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(root);

        // to store the current node
        Node curr;

        // loop till queue is empty
        while (!queue.isEmpty())
        {
            // calculate the total number of nodes at the current level
            int size = queue.size();
            int i = 0;

            // process every node of the current level and enqueue their
            // non-empty left and right child
            while (i++ < size)
            {
                curr = queue.poll();

                // if this is the first node of the current level, print it
                if (i == 1) {
                    System.out.print(curr.key + " ");
                }

                if (curr.left != null) {
                    queue.add(curr.left);
                }

                if (curr.right != null) {
                    queue.add(curr.right);
                }
            }
        }
    }
    // Recursive function to traverse the nodes in a preorder fashion
    public static void leftViewRecursive(Node root, int level, Map<Integer, Integer> map)
    {
        // base case
        if (root == null) {
            return;
        }

        // if the level is visited for the first time, insert the current node
        // and level information into the map
        map.putIfAbsent(level, root.key);

        leftViewRecursive(root.left, level + 1, map);
        leftViewRecursive(root.right, level + 1, map);
    }

    // Function to print the left view of a given binary tree
    public static void leftView(Node root)
    {
        // create an empty HashMap to store the first node for each level
        Map<Integer, Integer> map = new HashMap<>();

        // traverse the tree and fill the map
        leftViewRecursive(root, 1, map);

        // iterate through the HashMap in sorted order of its keys
        // and print the left view
        for (int i = 1; i <= map.size(); i++) {
            System.out.print(map.get(i) + " ");
        }
    }

    public static void main(String[] args)
    {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.right = new Node(4);
        root.right.left = new Node(5);
        root.right.right = new Node(6);
        root.right.left.left = new Node(7);
        root.right.left.right = new Node(8);

        leftViewIterative(root);

    }
}

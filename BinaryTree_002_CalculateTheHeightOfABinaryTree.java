import java.util.ArrayDeque;
import java.util.Queue;

public class BinaryTree_002_CalculateTheHeightOfABinaryTree {
    /*
    Write an efficient algorithm to compute the binary tree's height. The height or depth is the total numbers of edges
    or nodes on the longest path from the root node to the leaf node.

    There is two ways to solve this problem which are iterative and recursive.

    Recursive Solution
    The idea is to traverse the tree in a postorder fashion and calculate the height of the left and right subtree.
    The height of a subtree rooted at any node will be more than the maximum height of its left and right subtree.
    Recursively apply this property to all tree nodes in a bottom-up manner(postorder fashion) and return the subtrees's
    maximum height rooted at that node.

    Iterative Solution
    In an iterative version, perform a level order traversal on the tree. Then the height of a tree is equal to the
    total number ıf levels in it.
    */

    // Recursive function to calculate the height of a given binary tree
    public static int heightRecursive(Node root)
    {
        // Base case: empty tree has a height of 0
        if (root == null) {
            return 0;
        }

        // recur for the left and right subtree and consider maximum depth
        return 1 + Math.max(heightRecursive(root.left), heightRecursive(root.right));
    }
    public static int heightIterative(Node root)
    {
        // empty tree has a height of 0
        if (root == null) {
            return 0;
        }

        // create an empty queue and enqueue the root node
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(root);

        Node front = null;
        int height = 0;

        // loop till queue is empty
        while (!queue.isEmpty())
        {
            // calculate the total number of nodes at the current level
            int size = queue.size();

            // process each node of the current level and enqueue their
            // non-empty left and right child
            while (size-- > 0)
            {
                front = queue.poll();

                if (front.left != null) {
                    queue.add(front.left);
                }

                if (front.right != null) {
                    queue.add(front.right);
                }
            }

            // increment height by 1 for each level
            height++;
        }

        return height;
    }

    public static void main(String[] args)
    {
        Node root = new Node(15);
        root.left = new Node(10);
        root.right = new Node(20);
        root.left.left = new Node(8);
        root.left.right = new Node(12);
        root.right.left = new Node(16);
        root.right.right = new Node(25);

        System.out.print("The height of the binary tree is " + heightRecursive(root));
        System.out.println(("The height of the binary tree is: " + heightIterative(root)));
    }
}
class Node{
    public String data;
    int key;
    Node left = null, right = null;
    Node(int key){
        this.key = key;
    }

}

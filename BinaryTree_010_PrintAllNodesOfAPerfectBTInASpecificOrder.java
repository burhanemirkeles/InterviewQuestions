import java.util.ArrayDeque;
import java.util.Queue;

public class BinaryTree_010_PrintAllNodesOfAPerfectBTInASpecificOrder {
    /*
    Given a binary tree, write an efficient algorithm to print all nodes in a specific order.We need to print nodes of
    every level in alternating left and right.

    For example, there are two ways to print the following tree:

    Variation 1: Print Top-Down
             (1, 2, 3, 4, 7, 5, 6, 8, 15, 9, 14, 10, 13, 11, 12)
    Variation 2: Print Bottom-Up
             (8, 15, 9, 14, 10, 13, 11, 12, 4, 7, 5, 6, 2, 3, 1)

                                             1
                                           /   \
                                          /     \
                                         2       3
                                        /\       /\
                                       /  \     /  \
                                      4    5   6    7
                                     /\    /\ /\   /\
                                    8  9  10 1112 13 14


     */

        // Function to print all nodes of a given binary tree in a specific
        // order from top to bottom
        public static void printNodes(Node root)
        {
            // return if the tree is empty
            if (root == null) {
                return;
            }

            // print the root node
            System.out.print(root.key + " ");

            // create two empty queues and enqueue root's left and
            // right child, respectively
            Queue<Node> first = new ArrayDeque<>();
            first.add(root.left);

            Queue<Node> second = new ArrayDeque<>();
            second.add(root.right);

            // loop till queue is empty
            while (!first.isEmpty())
            {
                // calculate the total number of nodes at the current level
                int n = first.size();

                // process every node of the current level
                while (n-- > 0)
                {
                    // dequeue front node from the first queue and print it
                    Node x = first.poll();

                    System.out.print(x.key + " ");

                    // enqueue left and right child of `x` to the first queue
                    if (x.left != null) {
                        first.add(x.left);
                    }

                    if (x.right != null) {
                        first.add(x.right);
                    }

                    // dequeue front node from the second queue and print it
                    Node y = second.poll();

                    System.out.print(y.key + " ");

                    // enqueue right and left child of `y` to the second queue
                    if (y.right != null) {
                        second.add(y.right);
                    }

                    if (y.left != null) {
                        second.add(y.left);
                    }
                }
            }
        }

        public static void main(String[] args)
        {
            Node root = new Node(1);
            root.left = new Node(2);
            root.right = new Node(3);
            root.left.left = new Node(4);
            root.left.right = new Node(5);
            root.right.left = new Node(6);
            root.right.right = new Node(7);
            root.left.left.left = new Node(8);
            root.left.left.right = new Node(9);
            root.left.right.left = new Node(10);
            root.left.right.right = new Node(11);
            root.right.left.left = new Node(12);
            root.right.left.right = new Node(13);
            root.right.right.left = new Node(14);
            root.right.right.right = new Node(15);

            printNodes(root);
        }
}
/*

Variation 2 is below:

// Utility function to add an element to the list corresponding to the given key
    // in `Map<Integer, List<Integer>>`.
    public static void insertIntoMultiMap(Map<Integer, List<Integer>> map,
                                        Integer key, Integer value) {
        map.putIfAbsent(key, new ArrayList<>());
        map.get(key).add(value);
    }

    // Function to print all nodes of a given binary tree in
    // a specific order from bottom to top
    public static void printNodes(Node root)
    {
        // return if the tree is empty
        if (root == null) {
            return;
        }

        // start with level 1 (of the root node)
        int level = 1;

        // create an empty multimap of integers (every key can be
        // associated with multiple values)
        Map<Integer, List<Integer>> map = new HashMap<>();

        // insert the root node at the first level
        insertIntoMultiMap(map, level, root.key);

        // create two empty queues and enqueue root's left and
        // right child, respectively
        Queue<Node> q1 = new ArrayDeque<>(), q2 = new ArrayDeque<>();
        q1.add(root.left);
        q2.add(root.right);

        // loop till queue is empty
        while (!q1.isEmpty())
        {
            // increment level by 1
            level++;

            // calculate the total number of nodes at the current level
            int n = q1.size();

            // process every node of the current level
            while (n-- > 0)
            {
                // dequeue front node from the first queue and insert it into the map
                Node x = q1.poll();
                insertIntoMultiMap(map, level, x.key);

                // enqueue left and right child of `x` to the first queue
                if (x.left != null) {
                    q1.add(x.left);
                }

                if (x.right != null) {
                    q1.add(x.right);
                }

                // dequeue front node from the second queue and insert it into the map
                Node y = q2.poll();

                map.get(level).add(y.key);

                // enqueue right and left child of `y` to the second queue
                if (y.right != null) {
                    q2.add(y.right);
                }

                if (y.left != null) {
                    q2.add(y.left);
                }
            }
        }

        // iterate through the HashMap and print all nodes present at every level
        for (int i = map.size(); i > 0; i--) {
            System.out.print(map.get(i));
        }
    }

    public static void main(String[] args)
    {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        root.left.left.left = new Node(8);
        root.left.left.right = new Node(9);
        root.left.right.left = new Node(10);
        root.left.right.right = new Node(11);
        root.right.left.left = new Node(12);
        root.right.left.right = new Node(13);
        root.right.right.left = new Node(14);
        root.right.right.right = new Node(15);

        printNodes(root);
    }
 */
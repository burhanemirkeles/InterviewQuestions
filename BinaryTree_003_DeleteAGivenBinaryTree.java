public class BinaryTree_003_DeleteAGivenBinaryTree {
    /*
    The algorithm have to deallocate every single node present in the tree, not just change the root node's reference
    to null.
    We can implement the solution recursively for this problem. The idea is to traverse the tree in a postorder fashion
    and delete the left and right subtree of a node before deleting the node itself. Note that we cannot traverse a tree
    in preorder or inorder fashion as we can't delete a parent before deleting its childeren.

    In Java it is enough to delete all tree to say root=null
    So codes below are implemented in C++
     */

    /*
#include <iostream>
using namespace std;

// Data structure to store a binary tree node
struct Node
{
    int key;
    Node *left, *right;

    Node(int key)
    {
        this->key = key;
        this->left = this->right = nullptr;
    }
};

// Recursive function to delete a given binary tree
void deleteBinaryTree(Node* &root)
{
    // Base case: empty tree
    if (root == nullptr) {
        return;
    }

    // delete left and right subtree first (Postorder)
    deleteBinaryTree(root->left);
    deleteBinaryTree(root->right);

    // delete the current node after deleting its left and right subtree
    delete root;

    // set root as null before returning
    root = nullptr;
}

int main()
{
    Node* root = new Node(15);
    root->left = new Node(10);
    root->right = new Node(20);
    root->left->left = new Node(8);
    root->left->right = new Node(12);
    root->right->left = new Node(16);
    root->right->right = new Node(25);

    // delete the entire tree
    deleteBinaryTree(root);

    if (root == nullptr) {
        cout << "Tree Successfully Deleted";
    }

    return 0;
}

    */
}



// Minimum in BST

// Given the root of a Binary Search Tree. Your task is to find the minimum element in this given BST.

// Examples
// Input: root = [5, 4, 6, 3, N, N, 7, 1]
// ex-1
// Output: 1
// Explanation: The minimum element in the given BST is 1.

// Input: root = [10, 5, 20, 2]
// ex-2
// Output: 2
// Explanation: The minimum element in the given BST is 2.

// Constraints:
// 0 ≤ number of nodes ≤ 105
// 0 ≤ node->data ≤ 105

// Expected Complexities
// Time Complexity: O(n)
// Auxiliary Space: O(1)


class Node {
    int data;
    Node left;
    Node right;
    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

class Solution {
    public int minValue(Node root) {
        while(root.left!=null) root=root.left;
        return root.data;
    }
    public int maxValue(Node root) {
        while(root.right!=null) root=root.right;
        return root.data;
    }
}
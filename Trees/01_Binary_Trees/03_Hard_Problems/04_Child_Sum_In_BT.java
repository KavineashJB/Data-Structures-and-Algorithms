// GFG Problem
// Children Sum in a Binary Tree

// Given the root of a binary tree, determine whether the tree satisfies the Children Sum Property. In this property, each non-leaf node must have a value equal to the sum of its left and right children's values. A NULL child is considered to have a value of 0, and all leaf nodes are considered valid by default.
// Return true if every node in the tree satisfies this condition, otherwise return false.

// Examples:

// Input: root = [35, 20, 15, 15, 5, 10, 5]
// Output: True
// Explanation: Here, every node is sum of its left and right child.

// Input: root = [1, 4, 3, 5]  
// Output: False
// Explanation: Here, 1 is the root node and 4, 3 are its child nodes. 4 + 3 = 7 which is not equal to the value of root node. Hence, this tree does not satisfy the given condition.

// Constraints:
// 1 ≤ number of nodes ≤ 105
// 0 ≤ node->data ≤ 105

// Expected Complexities
// Time Complexity: O(n)
// Auxiliary Space: O(h)


class Node{
    int data;
    Node left,right;

    Node(int key)
    {
        data = key;
        left = right = null;
    }
}

class Solution {
    public boolean isLeaf(Node node){
        return node!=null && node.left==null && node.right==null;
    }
    public int dfs(Node node){
        if(isLeaf(node)) return node.data;
        if(node==null) return 0;
        
        int ls=dfs(node.left);
        int rs=dfs(node.right);
        return ls+rs==node.data?node.data:(int)1e9;
    }
    public boolean isSumProperty(Node root) {
        return dfs(root)==root.data?true:false;
    }
}
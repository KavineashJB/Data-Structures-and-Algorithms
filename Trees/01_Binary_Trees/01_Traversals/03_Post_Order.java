// 145. Binary Tree Postorder Traversal

// Given the root of a binary tree, return the postorder traversal of its nodes' values.

 
// Example 1:
// Input: root = [1,null,2,3]
// Output: [3,2,1]
// Explanation:

// Example 2:
// Input: root = [1,2,3,4,5,null,8,null,null,6,7,9]
// Output: [4,6,7,5,2,9,8,3,1]

// Example 3:
// Input: root = []
// Output: []

// Example 4:
// Input: root = [1]
// Output: [1]

 
// Constraints:

// The number of the nodes in the tree is in the range [0, 100].
// -100 <= Node.val <= 100
 

// Follow up: Recursive solution is trivial, could you do it iteratively?

import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    List<Integer> l = new ArrayList<>();
    public List<Integer> postorderTraversalRec(TreeNode root) {
        if(root==null) return l;
        if(root.left!=null)  postorderTraversalRec(root.left);
        if(root.right!=null)  postorderTraversalRec(root.right);
        l.add(root.val);
        return l;
    }
    
    public List<Integer> postorderTraversalIterR(TreeNode root) {
        if(root==null) return l;
        return l;
    }
}
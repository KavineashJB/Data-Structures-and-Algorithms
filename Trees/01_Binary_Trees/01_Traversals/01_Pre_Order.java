// 144. Binary Tree Preorder Traversal

// Given the root of a binary tree, return the preorder traversal of its nodes' values.


// Example 1:
// Input: root = [1,null,2,3]
// Output: [1,2,3]

// Example 2:
// Input: root = [1,2,3,4,5,null,8,null,null,6,7,9]
// Output: [1,2,4,5,6,7,3,8,9]

// Example 3:
// Input: root = []
// Output: []

// Example 4:
// Input: root = [1]
// Output: [1]

 
// Constraints:
// The number of nodes in the tree is in the range [0, 100].
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

    public List<Integer> preOrderTraversalIter(TreeNode root){
        if(root==null) return l;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode node=stack.pop();
            if(node.right!=null) stack.push(node.right);
            if(node.left!=null) stack.push(node.left);
            l.add(node.val);
        }
        return l;
    }

    public List<Integer> preorderTraversalRec(TreeNode root) {
        if(root==null){
            return l;
        }
        l.add(root.val);
        if(root.left!=null){
            preorderTraversalRec(root.left);
        }
        if(root.right!=null){
            preorderTraversalRec(root.right);
        }
        return l;
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        // return preorderTraversalRec(root);

        return preOrderTraversalIter(root);
    }
}
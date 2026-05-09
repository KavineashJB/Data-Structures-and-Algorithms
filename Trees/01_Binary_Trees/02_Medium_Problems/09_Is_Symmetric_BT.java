// 101. Symmetric Tree

// Given the root of a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center).


// Example 1:
// Input: root = [1,2,2,3,4,4,3]
// Output: true

// Example 2:
// Input: root = [1,2,2,null,3,null,3]
// Output: false
 

// Constraints:

// The number of nodes in the tree is in the range [1, 1000].
// -100 <= Node.val <= 100
 

// Follow up: Could you solve it both recursively and iteratively?

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

class Solution_1 {
    public boolean isSym(TreeNode p, TreeNode q) {
        if(p==null && q==null) return true;
        if(p==null || q==null || p.val!=q.val) return false;
        boolean l = isSym(p.left, q.right);
        boolean r = isSym(p.right, q.left);
        return l && r;
    }
    public boolean isSymmetric(TreeNode root) {
        return isSym(root.left, root.right);
    }
}

class Solution_2 {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        
        Queue<TreeNode> q = new LinkedList<>();

        q.offer(root.left);
        q.offer(root.right);
        
        while (!q.isEmpty()) {

            TreeNode leftNode = q.poll();
            TreeNode rightNode = q.poll();
            
            if (leftNode == null && rightNode == null) continue;
            if (leftNode == null || rightNode == null || leftNode.val != rightNode.val) return false;
            
            q.offer(leftNode.left);
            q.offer(rightNode.right);

            q.offer(leftNode.right);
            q.offer(rightNode.left);
        }
        
        return true;
    }
}
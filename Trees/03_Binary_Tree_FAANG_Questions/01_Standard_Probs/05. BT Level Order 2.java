// 107. Binary Tree Level Order Traversal II

// Given the root of a binary tree, return the bottom-up level order traversal of its nodes' values. (i.e., from left to right, level by level from leaf to root).


// Example 1:
// Input: root = [3,9,20,null,null,15,7]
// Output: [[15,7],[9,20],[3]]

// Example 2:
// Input: root = [1]
// Output: [[1]]

// Example 3:
// Input: root = []
// Output: []
 

// Constraints:

// The number of nodes in the tree is in the range [0, 2000].
// -1000 <= Node.val <= 1000


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
    List<List<Integer>> res;
    public List<List<Integer>> bfs(TreeNode root){
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            int size = q.size();
            
            List<Integer> l = new ArrayList<>();
            for(int i=0; i<size; i++){
                TreeNode curr=q.poll();
                
                if(curr.left!=null) q.offer(curr.left);
                if(curr.right!=null) q.offer(curr.right);

                l.add(curr.val);
            }
            
            res.addFirst(l);
        }
        return res;
    }
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        res = new ArrayList<>();
        if(root==null) return res;
        return bfs(root);
    }
}
// 103. Binary Tree Zigzag Level Order Traversal

// Given the root of a binary tree, return the zigzag level order traversal of its nodes' values. (i.e., from left to right, then right to left for the next level and alternate between).

 
// Example 1:
// Input: root = [3,9,20,null,null,15,7]
// Output: [[3],[20,9],[15,7]]

// Example 2:
// Input: root = [1]
// Output: [[1]]

// Example 3:
// Input: root = []
// Output: []
 
// Constraints:

// The number of nodes in the tree is in the range [0, 2000].
// -100 <= Node.val <= 100

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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Deque<TreeNode> q = new ArrayDeque<>();
        List<List<Integer>> res = new ArrayList<>();
        if(root==null) return res;
        int zz=0;
        q.offer(root);
        // res.add(List.of(root.val));
        while(!q.isEmpty()){
            int size=q.size();
            List<Integer> l =  new ArrayList<>();
            for(int i=0; i<size; i++){
                if(zz==0){
                    TreeNode node=q.pollFirst();
                    if(node.left!=null) q.offerLast(node.left);
                    if(node.right!=null) q.offerLast(node.right);
                    l.add(node.val);
                } else {
                    TreeNode node=q.pollLast();
                    if(node.right!=null) q.offerFirst(node.right);
                    if(node.left!=null) q.offerFirst(node.left);
                    l.add(node.val);
                }
            }
            zz=zz==0?1:0;
            res.add(l);
        }
        return res;
    }
}
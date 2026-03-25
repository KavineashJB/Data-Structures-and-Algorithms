// 102. Binary Tree Level Order Traversal

// Given the root of a binary tree, return the level order traversal of its nodes values. (i.e., from left to right, level by level).


// Example 1:
// Input: root = [3,9,20,null,null,15,7]
// Output: [[3],[9,20],[15,7]]

// Example 2:
// Input: root = [1]
// Output: [[1]]

// Example 3:
// Input: root = []
// Output: []
 

// Constraints:
// The number of nodes in the tree is in the range [0, 2000].
// -1000 <= Node.val <= 1000


import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

// Definition for a binary tree node.
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
    public List<List<Integer>> levelOrderUsingQueue(TreeNode root){
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();

        if(root==null) return res;
        queue.offer(root);

        while(!queue.isEmpty()){
            int levelNum = queue.size();
            List<Integer> l = new ArrayList<>();
            for(int i=0; i<levelNum; i++){
                if(queue.peek().left!=null) queue.offer(queue.peek().left);
                if(queue.peek().right!=null) queue.offer(queue.peek().right);
                l.add(queue.poll().val);
            }
            res.add(l);
        }
        return res;
    }

    public void levelOrderUsingRec(TreeNode root, int level, List<List<Integer>> res){
        if(root==null) return;

        if(res.size()==level){
            List<Integer> l = new ArrayList<>();
            l.add(root.val);
            res.add(l);
        } else {
            res.get(level).add(root.val);
        }
        levelOrderUsingRec(root.left, level+1, res);
        levelOrderUsingRec(root.right, level+1, res);
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        // // Tradition method using Queue
        // return levelOrderUsingQueue(root);

        // Recursion method
        List<List<Integer>> res = new ArrayList<>();
        levelOrderUsingRec(root, 0, res);
        return res;
    }
}
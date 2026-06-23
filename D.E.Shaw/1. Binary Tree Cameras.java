// 968. Binary Tree Cameras

// You are given the root of a binary tree. We install cameras on the tree nodes where each camera at a node can monitor its parent, itself, and its immediate children.
// Return the minimum number of cameras needed to monitor all nodes of the tree.

// Example 1:
// Input: root = [0,0,null,0,0]
// Output: 1
// Explanation: One camera is enough to monitor all nodes if placed as shown.

// Example 2:
// Input: root = [0,0,null,0,null,0,null,null,0]
// Output: 2
// Explanation: At least two cameras are needed to monitor all nodes of the tree. The above image shows one of the valid configurations of camera placement.

// Constraints:
// The number of nodes in the tree is in the range [1, 1000].
// Node.val == 0

// Problem Link: https://leetcode.com/problems/binary-tree-cameras/?envType=problem-list-v2&envId=vdkmaovs

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
    private int cnt = 0;

    public int dfs(TreeNode node) {
        // 0 - no camera, not watching ==> so place camera here return 2;
        // 1 - no camera, watching ==> no need to place camera return 0;
        // 2 - camera, watching ==> no need to place camera and also for it's parent so
        // return 1;
        if (node == null)
            return 1;
        int l = dfs(node.left);
        int r = dfs(node.right);

        if (l == 0 || r == 0) {
            cnt++;
            return 2;
        } else if (l == 2 || r == 2) {
            return 1;
        }
        return 0;
    }

    public int minCameraCover(TreeNode root) {
        // edge case: if 0 then cnt+=1, this is due to at root if both (l,r)==1 then it
        // gives 0. so add 1 to result count. eg:[0,0,0,0,0,null,0,0,null,null,0]
        if (dfs(root) == 0) {
            cnt++;
        }
        return cnt;
    }
}
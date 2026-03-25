// 199. Binary Tree Right Side View

// Given the root of a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.


// Example 1:
// Input: root = [1,2,3,null,5,null,4]
// Output: [1,3,4]

// Example 2:
// Input: root = [1,2,3,4,null,null,null,5]
// Output: [1,3,4,5]

// Example 3:
// Input: root = [1,null,3]
// Output: [1,3]
// Example 4:
// Input: root = []
// Output: []

// Constraints:
// The number of nodes in the tree is in the range [0, 100].
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

// Better:
class Solution2 {
    Map<Integer, Integer> hm = new TreeMap<>();
    public void dfs(int row, TreeNode node){
        if(node==null) return;
        if(!hm.containsKey(row)){
            hm.put(row, node.val);
        } 
        dfs(row+1, node.right);
        dfs(row+1, node.left);
    }
    public List<Integer> rightSideView(TreeNode root) {
        dfs(0, root);
        return new ArrayList<Integer>(hm.values());
    }
}

// Optimal:
class Solution1 {
    List<Integer> res = new ArrayList<Integer>();
    public void dfs(int row, TreeNode node){
        if(node==null) return;
        if(row==res.size()){
            res.add(node.val);
        } 
        dfs(row+1, node.right);
        dfs(row+1, node.left);
    }
    public List<Integer> rightSideView(TreeNode root) {
        dfs(0, root);
        return res;
    }
}
// 226. Invert Binary Tree

// Given the root of a binary tree, invert the tree, and return its root.


// Example 1:
// Input: root = [4,2,7,1,3,6,9]
// Output: [4,7,2,9,6,3,1]

// Example 2:
// Input: root = [2,1,3]
// Output: [2,3,1]

// Example 3:
// Input: root = []
// Output: []
 

// Constraints:
// The number of nodes in the tree is in the range [0, 100].
// -100 <= Node.val <= 100


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
    public TreeNode dfs(TreeNode node) {
        if(node==null) return null;

        // like swapping - storing temp node 
        TreeNode curr = dfs(node.right);
        node.right = dfs(node.left);
        node.left = curr;
        return node;
    }
    public TreeNode invertTree(TreeNode root) {
        return dfs(root);
    }
}

class Solution_2 {
    public TreeNode invertTree(TreeNode root) {
        dfs(root);
        return root;
    }

    private void dfs(TreeNode root){
        if(root == null) return;

        TreeNode left = root.left;
        TreeNode right = root.right;

        root.left = right;
        root.right = left;

        dfs(root.left);
        dfs(root.right);
    }
}
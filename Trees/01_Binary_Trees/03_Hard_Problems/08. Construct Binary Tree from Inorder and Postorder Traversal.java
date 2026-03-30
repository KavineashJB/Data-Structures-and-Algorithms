// 106. Construct Binary Tree from Inorder and Postorder Traversal

// Given two integer arrays inorder and postorder where inorder is the inorder traversal of a binary tree and postorder is the postorder traversal of the same tree, construct and return the binary tree.


// Example 1:
// Input: inorder = [9,3,15,20,7], postorder = [9,15,7,20,3]
// Output: [3,9,20,null,null,15,7]

// Example 2:
// Input: inorder = [-1], postorder = [-1]
// Output: [-1]
 

// Constraints:

// 1 <= inorder.length <= 3000
// postorder.length == inorder.length
// -3000 <= inorder[i], postorder[i] <= 3000
// inorder and postorder consist of unique values.
// Each value of postorder also appears in inorder.
// inorder is guaranteed to be the inorder traversal of the tree.
// postorder is guaranteed to be the postorder traversal of the tree.


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
    Map<Integer, Integer> map;
    public TreeNode buildBT(int[] post, int ps, int pe, int[] in, int ins, int ine){
        if(pe<ps || ine<ins) return null;
        TreeNode root = new TreeNode(post[pe]);
        int inRoot = map.get(root.val);
        int numDiff = inRoot - ins;
        root.left = buildBT(post, ps, ps+numDiff-1, in, ins, inRoot-1);
        root.right = buildBT(post, ps+numDiff, pe-1, in, inRoot+1, ine);
        return root;
    }
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        map = new HashMap<>(); 
        int n=inorder.length;
        for(int i=0; i<n; i++){
            map.put(inorder[i],i);
        }

        return buildBT(postorder, 0, n-1, inorder, 0, n-1);
    }
}
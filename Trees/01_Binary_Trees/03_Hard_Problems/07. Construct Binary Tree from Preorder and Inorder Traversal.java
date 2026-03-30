// 105. Construct Binary Tree from Preorder and Inorder Traversal

// Given two integer arrays preorder and inorder where preorder is the preorder traversal of a binary tree and inorder is the inorder traversal of the same tree, construct and return the binary tree.


// Example 1:
// Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
// Output: [3,9,20,null,null,15,7]

// Example 2:
// Input: preorder = [-1], inorder = [-1]
// Output: [-1]
 

// Constraints:

// 1 <= preorder.length <= 3000
// inorder.length == preorder.length
// -3000 <= preorder[i], inorder[i] <= 3000
// preorder and inorder consist of unique values.
// Each value of inorder also appears in preorder.
// preorder is guaranteed to be the preorder traversal of the tree.
// inorder is guaranteed to be the inorder traversal of the tree.


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
    public TreeNode buildBT(int[] pre, int ps, int pe, int[] in, int ins, int ine){
        if(pe<ps || ine<ins) return null;
        TreeNode root = new TreeNode(pre[ps]);
        int inRoot = map.get(root.val);
        int numDiff = inRoot - ins;
        root.left = buildBT(pre, ps+1, ps+numDiff+1, in, ins, inRoot-1);
        root.right = buildBT(pre, ps+numDiff+1, pe, in, inRoot+1, ine);
        return root;
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        map = new HashMap<>(); 
        int n=inorder.length;
        for(int i=0; i<n; i++){
            map.put(inorder[i],i);
        }

        return buildBT(preorder, 0, n-1, inorder, 0, n-1);
    }
}
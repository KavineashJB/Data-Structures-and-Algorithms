// Check if there is a root to leaf path with given sequence

// Given a binary tree and an array, the task is to find if the given array sequence is present as a root-to-leaf path in given tree.


// Examples:
// root=[5,2,3,1,4,null,null,null,null,6,8]

// Input: arr=[5,2,4,8]
// output: True

// Input: [5,3,4,9]
// output: False

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val=val;
        this.left=this.right=null;
    }
}

class Solution {

    public boolean dfs(TreeNode root, int[] arr) {
        TreeNode curr=root;
        int ind=0;
        if(curr.val!=arr[ind++]) return false;
        while(curr!=null && ind<arr.length) {
            if(curr.left!=null && curr.left.val==arr[ind]){
                curr=curr.left;
            }
            else if(curr.right!=null &&curr.right.val==arr[ind]){
                curr=curr.right;
            } else {
                return false;
            }
            ind++;
        }
        return curr==null && ind==arr.length;
    }

    public boolean checkPathExist(TreeNode root, int[] arr) {
        return dfs(root, arr);
    }
}

// Eg: to diff better and Optimal Approach
// The Absolute Best Case — $O(1) Time
//                2
//              /   \
//             3     4
//            / \   / \
//          [MILLIONS OF NODES]

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

// Better: Best/Avg/Worst-O(N),O(N)
// My Approach : Using Long to overcoming int overflow (2^31-1) 
class Solution_1 {
    long f=Long.MAX_VALUE, s=Long.MAX_VALUE;
    boolean isIntMax=false;
    public void helper(TreeNode node){
        if(node==null) return;
        helper(node.left);
        if(node.val<f){
            s = f;
            f = (int)node.val;
        }
        else if(node.val<s && node.val!=f){
            s=(int)node.val;
        }
        helper(node.right);
    }

    public int findSecondMinimumValue(TreeNode root) {
        helper(root);
        
        return s==Long.MAX_VALUE?-1:(int)s;
        
        
    }
}

// Optimal: Best/Avg-O(H),Worst-O(N),O(N)
// Approach - using 
class Solution {
    public int helper(TreeNode node, int min1){
        if(node==null) return -1;

        if(node.val>min1){
            return node.val;
        }

        int l = helper(node.left,min1);
        int r = helper(node.right,min1);
        
        if(l!=-1 && r!=-1) return Math.min(l,r);
        return l==-1?r:l;
    }

    public int findSecondMinimumValue(TreeNode root) {
        if(root.left==null && root.right==null) return -1;
        return helper(root, root.val);   
    }
}


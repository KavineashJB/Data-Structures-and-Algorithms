// 662. Maximum Width of Binary Tree

// Given the root of a binary tree, return the maximum width of the given tree.
// The maximum width of a tree is the maximum width among all levels.
// The width of one level is defined as the length between the end-nodes (the leftmost and rightmost non-null nodes), where the null nodes between the end-nodes that would be present in a complete binary tree extending down to that level are also counted into the length calculation.
// It is guaranteed that the answer will in the range of a 32-bit signed integer.


// Example 1:
// Input: root = [1,3,2,5,3,null,9]
// Output: 4
// Explanation: The maximum width exists in the third level with length 4 (5,3,null,9).

// Example 2:
// Input: root = [1,3,2,5,null,null,9,6,null,7]
// Output: 7
// Explanation: The maximum width exists in the fourth level with length 7 (6,null,null,null,null,null,7).

// Example 3:
// Input: root = [1,3,2,5]
// Output: 2
// Explanation: The maximum width exists in the second level with length 2 (3,2).
 

// Constraints:
// The number of nodes in the tree is in the range [1, 3000].
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

class Pair {
    int ind;
    TreeNode node;
    public Pair(TreeNode node, int ind){
        this.node=node;
        this.ind=ind;
    }
 }
class Solution {
    public int levelOrder(TreeNode node){
        Queue<Pair> q = new LinkedList<>();
        int maxiW=0;
        q.offer(new Pair(node, 0));
        while(!q.isEmpty()){
            int len=q.size();
            int first, last;
            first = last = q.peek().ind;
            for(int i=0; i<len; i++){
                Pair curr=q.poll();
                TreeNode currNode=curr.node;
                last=curr.ind;
                if(currNode.left!=null) q.offer(new Pair(currNode.left, 2*last+1));
                if(currNode.right!=null) q.offer(new Pair(currNode.right, 2*last+2));
            }
            maxiW=Math.max(maxiW, last-first+1);
        }
        return maxiW;
    }
    public int widthOfBinaryTree(TreeNode root) {
        return levelOrder(root);
    }
}
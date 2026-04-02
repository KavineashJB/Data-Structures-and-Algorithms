// Find the Level Order Successor of a Node in a Binary Tree
// Given the root of a binary tree and a target node, return the level order successor of the given node in the tree.

// The level order successor of a node is the node that appears immediately after the given node in the level order traversal (breadth-first traversal) of the tree.

// If the given node is the last node in the level order traversal, return null.

// Example 1:

//               20            
//            /      \         
//          10        26       
//         /  \      /  \      
//        4    18  24    27    
//            /  \
//           14   19
//          /  \
//         13  15

// Input: root = [20,10,26,4,18,24,27,null,null,14,19,null,null,null,null,13,15], target = 24
// Output: 27
// Explanation: The level order traversal of the tree is [20, 10, 26, 4, 18, 24, 27, 14, 19, 13, 15]. The node immediately following 24 is 27.


// Example 2:
// Input: root = [20,10,26,4,18,24,27,null,null,14,19,null,null,null,null,13,15], target = 18
// Output: 24

// Example 3:
// Input: root = [20,10,26,4,18,24,27,null,null,14,19,null,null,null,null,13,15], target = 27
// Output: 14
// Explanation: While 27 is a last node in its level, so the immediate successor is the first node of next level

// Example 4:
// Input: root = [20,10,26,4,18,24,27,null,null,14,19,null,null,null,null,13,15], target = 15
// Output: null
// Explanation: since no immediate successor then return null

// Constraints:
// The number of nodes in the tree is in the range [1, 10^4].
// -10^5 <= Node.val <= 10^5
// All Node.val are unique.
// The target node is guaranteed to exist in the tree.

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
    public TreeNode bfs(TreeNode node, int target) {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(node);
        
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0; i<size; i++){
                TreeNode curr = q.poll();
                if(curr.left!=null) q.offer(curr.left);
                if(curr.right!=null) q.offer(curr.right);
                if(curr.val==target){
                    return q.isEmpty()?null:q.peek();
                }
            }
        }
        return null;
    }
    
    public TreeNode LevelOrderSuccessor(TreeNode root, int target) {
        if(root==null) return null;
        return bfs(root,target);
    }
}
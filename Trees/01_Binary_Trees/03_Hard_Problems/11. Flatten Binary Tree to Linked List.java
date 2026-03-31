// 114. Flatten Binary Tree to Linked List


// Given the root of a binary tree, flatten the tree into a "linked list":

// The "linked list" should use the same TreeNode class where the right child pointer points to the next node in the list and the left child pointer is always null.
// The "linked list" should be in the same order as a pre-order traversal of the binary tree.
 

// Example 1:
// Input: root = [1,2,5,3,4,null,6]
// Output: [1,null,2,null,3,null,4,null,5,null,6]

// Example 2:
// Input: root = []
// Output: []

// Example 3:
// Input: root = [0]
// Output: [0]
 

// Constraints:
// The number of nodes in the tree is in the range [0, 2000].
// -100 <= Node.val <= 100
 

// Follow up: Can you flatten the tree in-place (with O(1) extra space)?


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


// Better - O(N), O(N)
// Recursive Approach - reverse preorder (RLD)
class Solution_1 {
    TreeNode prev=null;
    public void flatten(TreeNode root) {
        if(root==null) return;
        flatten(root.right);
        flatten(root.left);
        root.right=prev;
        root.left=null;
        prev=root;
    }
}

// Better - O(N), O(N)
// My Approach: Using Stack
class Solution_2 {
    Stack<TreeNode> st;
    public void buildList(TreeNode root) {
        st.push(root);
        while(!st.isEmpty()){
            TreeNode curr = st.pop();
            if(curr.right!=null)  st.push(curr.right);
            if(curr.left!=null)  st.push(curr.left);
            if(!st.isEmpty()) curr.right=st.peek();
            curr.left=null;
        }
    }
    public void flatten(TreeNode root) {
        st=new Stack<>();
        if(root==null) return;
        buildList(root);
    }
}

// Optimal - O(N),O(1)
// Morris Traveral - connecting curr left node's rightmost child to the curr right node @ each traversal
class Solution_3 {
    public void flatten(TreeNode root) {
        while(root!=null){
            if(root.left==null){
                root=root.right;
                continue;
            }
            TreeNode currRight = root.right;
            TreeNode currLeft = root.left;
            TreeNode prev = currLeft;
            while(prev.right!=null) prev=prev.right;
            prev.right=currRight;
            root.right=currLeft;
            root.left=null;
            root=root.right;
        }
    }
}
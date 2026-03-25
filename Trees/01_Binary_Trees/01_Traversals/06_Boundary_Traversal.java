// // Geeks For Geeks Problem
// Tree Boundary Traversal
// Given a root of a Binary Tree, return its boundary traversal in the following order:

// Left Boundary: Nodes from the root to the leftmost non-leaf node, preferring the left child over the right and excluding leaves.

// Leaf Nodes: All leaf nodes from left to right, covering every leaf in the tree.

// Reverse Right Boundary: Nodes from the root to the rightmost non-leaf node, preferring the right child over the left, excluding leaves, and added in reverse order.

// Note: The root is included once, leaves are added separately to avoid repetition, and the right boundary follows traversal preference not the path from the rightmost leaf.

// Examples:

// Input: root = [1, 2, 3, 4, 5, 6, 7, N, N, 8, 9, N, N, N, N]
// Output: [1, 2, 4, 8, 9, 6, 7, 3]

// Input: root = [1, N, 2, N, 3, N, 4, N, N] 
// Output: [1, 4, 3, 2]
// Explanation:
// Left boundary: [1] (as there is no left subtree)
// Leaf nodes: [4]
// Right boundary: [3, 2] (in reverse order)
// Final traversal: [1, 4, 3, 2]

// Constraints:
// 1 ≤ number of nodes ≤ 105
// 1 ≤ node->data ≤ 105


import java.util.*;
class Node {
    int data;
    Node left, right;

    public Node(int d) {
        data = d;
        left = right = null;
    }
}

class Solution {
    ArrayList<Integer> res = new ArrayList<>();
    boolean isLeaf(Node node){
        if(node!=null && node.left==null && node.right==null) return true;
        else return false;
    }
    
    void addLeft(Node  node){
        Node curr = node.left;
        while(curr != null){
            if(isLeaf(curr)==false) res.add(curr.data);
            if(curr.left!=null) curr=curr.left;
            else curr=curr.right;
        }
    }
    
    void addRight(Node node){
        Node curr = node.right;
        List<Integer> temp = new ArrayList<>();
        while(curr != null){
            if(isLeaf(curr)==false) temp.add(curr.data);
            if(curr.right!=null) curr=curr.right;
            else curr=curr.left;
        }
        
        for(int i=temp.size()-1; i>=0; i--){
            res.add(temp.get(i));
        }
    }
    
    void addLeaf(Node root){
        if(root==null) return;
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        
        while(!stack.isEmpty()) {
            Node node=stack.pop();
            if(isLeaf(node)) res.add(node.data);
            else {
                if(node.right!=null) stack.push(node.right);
                if(node.left!=null) stack.push(node.left);
            }
        }
    }
    
    ArrayList<Integer> boundaryTraversal(Node root) {
        if(root!=null) res.add(root.data);
        if(isLeaf(root)) return res;
        addLeft(root);
        addLeaf(root);
        addRight(root);
        return res;
    }
}
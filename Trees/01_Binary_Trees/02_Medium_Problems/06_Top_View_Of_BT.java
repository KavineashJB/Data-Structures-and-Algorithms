// // GFG Problem
// Top View of Binary Tree

// You are given the root of a binary tree, and your task is to return its top view. The top view of a binary tree is the set of nodes visible when the tree is viewed from the top.

// Note:

// Return the nodes from the leftmost node to the rightmost node.
// If multiple nodes overlap at the same horizontal position, only the topmost (closest to the root) node is included in the view. 

// Examples:
// Input: root = [1, 2, 3]
// Output: [2, 1, 3]
// Explanation: The Green colored nodes represents the top view in the below Binary tree.
 
// Input: root = [10, 20, 30, 40, 60, 90, 100]
// Output: [40, 20, 10, 30, 100]
// Explanation: The Green colored nodes represents the top view in the below Binary tree.


// Constraints:
// 1 ≤ number of nodes ≤ 105
// 1 ≤ node->data ≤ 105

// Expected Complexities
// Time Complexity: O(n)
// Auxiliary Space: O(n)

import java.util.*;

class Node {
    int data;
    Node left, right;

    Node(int val) {
        this.data = val;
        this.left = null;
        this.right = null;
    }
}

class Solution {
    Map<Integer, int[]> hm = new TreeMap<>();
    public void dfs(int col, int row, Node node){
        if(node==null) return;
        if(!hm.containsKey(col)){
            hm.put(col, new int[]{row, node.data});
        } else {
            if(hm.get(col)[0]>row){
                hm.put(col, new int[]{row, node.data});
            }
        }
        dfs(col-1, row+1, node.left);
        dfs(col+1, row+1, node.right);
    }
    
    public ArrayList<Integer> topView(Node root) {
        dfs(0, 0, root);
        ArrayList<Integer> res = new ArrayList<Integer>();
        for(int[] arr:hm.values()){
            res.add(arr[1]);
        }
        return res;
    }
}
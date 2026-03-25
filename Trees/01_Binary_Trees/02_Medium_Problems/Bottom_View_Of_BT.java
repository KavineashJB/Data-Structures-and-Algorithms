// Bottom View of Binary Tree

// You are given the root of a binary tree, and your task is to return its bottom view. The bottom view of a binary tree is the set of nodes visible when the tree is viewed from the bottom.

// Note: If there are multiple bottom-most nodes for a horizontal distance from the root, then the latter one in the level order traversal is considered.

// Examples :

// Input: root = [1, 2, 3, 4, 5, N, 6]
// Output: [4, 2, 5, 3, 6]
// Explanation: The Green nodes represent the bottom view of below binary tree.
    
// Input: root = [20, 8, 22, 5, 3, 4, 25, N, N, 10, 14, N, N, 28, N]
// Output: [5, 10, 4, 28, 25]
// Explanation: The Green nodes represent the bottom view of below binary tree.
    
// Constraints:
// 1 ≤ number of nodes ≤ 105
// 1 ≤ node->data ≤ 105

// Expected Complexities
// Time Complexity: O(n)
// Auxiliary Space: O(n)

import java.util.*;
class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

class Solution {
    Map<Integer, int[]> hm = new TreeMap<>();
    public void dfs(int col, int row, Node node){
        if(node==null) return;
        if(!hm.containsKey(col)){
            hm.put(col, new int[]{row, node.data});
        } else {
            if(hm.get(col)[0]<=row){
                hm.put(col, new int[]{row, node.data});
            }
        }
        dfs(col-1, row+1, node.left);
        dfs(col+1, row+1, node.right);
    }
    public ArrayList<Integer> bottomView(Node root) {
        dfs(0, 0, root);
        ArrayList<Integer> res = new ArrayList<Integer>();
        for(int[] arr:hm.values()){
            res.add(arr[1]);
        }
        return res;
    }
}
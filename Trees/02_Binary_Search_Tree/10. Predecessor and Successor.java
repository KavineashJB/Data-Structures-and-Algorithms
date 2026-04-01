// Predecessor and Successor

// You are given the root of a BST and an integer key. You need to find the inorder predecessor and successor of the given key. If either predecessor or successor is not found, then set it to NULL.

// Note: In an inorder traversal the number just smaller than the target is the predecessor and the number just greater than the target is the successor. 

// Examples :

// Input: root = [50, 30, 70, 20, 40, 60, 80], key = 65
// Output: [60, 70]
// Explanation: In the given BST the inorder predecessor of 65 is 60 and inorder successor of 65 is 70.

// Input: root = [8, 1, 9, N, 4, N, 10, 3], key = 8
// Output: [4, 9]
// Explanation: In the given BST the inorder predecessor of 8 is 4 and inorder successor of 8 is 9.

// Input: root = [2, 1, 3], key = 3
// Output: [2, -1]
// Explanation: In the given BST the inorder predecessor of 3 is 2 and inorder successor of 8 is null.


// Constraints: 
// 1 ≤ no. of nodes ≤ 105
// 0 ≤ node->data ≤ 106
// 1 ≤ key ≤ 106

// Expected Complexities
// Time Complexity: O(Height of the BST)
// Auxiliary Space: O(1)

import java.util.*;
class Node {
    int data;
    Node left, right;
    Node(int x) {
        data = x;
        left = right = null;
    }
}

class Solution {
    public ArrayList<Node> findPreSuc(Node root, int key) {
        ArrayList<Node> res = new ArrayList<>();
        Node pred, succ;
        pred=succ= null;
        
        Node curr=root;
        while(curr!=null){
            if(key==curr.data){
                Node l = curr.left;
                while(l!=null && l.right!=null) l=l.right;
                pred=l==null?pred:l;
                Node r = curr.right;
                while(r!=null && r.left!=null) r=r.left;
                succ=r==null?succ:r;
                break;
            } else if(key>curr.data){
                pred=curr;
                curr=curr.right;
            } else {
                succ=curr;
                curr=curr.left;
            }
        }
        res.add(pred);
        res.add(succ);
        return res;
    }
}

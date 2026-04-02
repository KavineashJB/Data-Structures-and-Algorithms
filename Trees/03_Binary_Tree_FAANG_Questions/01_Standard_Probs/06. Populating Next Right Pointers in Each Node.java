// 116. Populating Next Right Pointers in Each Node

// You are given a perfect binary tree where all leaves are on the same level, and every parent has two children. The binary tree has the following definition:

// struct Node {
//   int val;
//   Node *left;
//   Node *right;
//   Node *next;
// }
// Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.

// Initially, all next pointers are set to NULL.

 

// Example 1:
// Input: root = [1,2,3,4,5,6,7]
// Output: [1,#,2,3,#,4,5,6,7,#]
// Explanation: Given the above perfect binary tree (Figure A), your function should populate each next pointer to point to its next right node, just like in Figure B. The serialized output is in level order as connected by the next pointers, with '#' signifying the end of each level.

// Example 2:
// Input: root = []
// Output: []
 

// Constraints:
// The number of nodes in the tree is in the range [0, 212 - 1].
// -1000 <= Node.val <= 1000
 

// Follow-up:

// You may only use constant extra space.
// The recursive approach is fine. You may assume implicit stack space does not count as extra space for this problem.


import java.util.*;
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};

// Better Approach: O(N),O(N)
// Using level order Queue

class Solution_1 {
    public Node bfs(Node node) {
        Queue<Node> q = new LinkedList<>();
        q.offer(node);
        while(!q.isEmpty()) {
            int size=q.size();
            for(int i=0; i<size; i++){
                Node curr=q.poll();
                if(curr.left!=null) q.offer(curr.left);
                if(curr.right!=null) q.offer(curr.right);
                if(i!=size-1) curr.next=q.peek();
            }
        }
        return node;
    }
    public Node connect(Node root) {
        if(root==null) return null;
        return bfs(root);
    }
}




// Optimal Approach: O(N),O(1)-since recusrion stack is used but no other auxiliary space like queue, list,..
// using the next pointer itself to traverse after assigned to the node
// but shows TLE for some large testcases

class Solution_2 {
    public void bfs(Node node) {
        if(node==null) return;
        if(node.left!=null){
            node.left.next=node.right;
            if(node.next!=null){
                node.right.next = node.next.left;
            }
        }
        bfs(node.left);
        bfs(node.next);
    }
    public Node connect(Node root) {
        bfs(root);
        return root;
    }
}


// Best Optimal Approach: O(N),O(1)-since recusrion stack is used but no other auxiliary space like queue, list,..
// using the next pointer itself to traverse after assigned to the node

class Solution_3 {
    public void bfs(Node node,int n) {
        if(node.left==null) return;
        Node curr=node;
        for(int i=0; i<n; i++){
            if(curr.left!=null){
                curr.left.next=curr.right;
                if(curr.next!=null){
                    curr.right.next = curr.next.left;
                }
            }
            curr=curr.next;
        }
        
        bfs(node.left,n<<1);
    }
    public Node connect(Node root) {
        if(root==null) return null;
        bfs(root,1);
        return root;
    }
}
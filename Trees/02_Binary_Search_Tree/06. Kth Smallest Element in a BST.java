// 230. Kth Smallest Element in a BST

// Given the root of a binary search tree, and an integer k, return the kth smallest value (1-indexed) of all the values of the nodes in the tree.

 

// Example 1:
// Input: root = [3,1,4,null,2], k = 1
// Output: 1

// Example 2:
// Input: root = [5,3,6,2,4,null,null,1], k = 3
// Output: 3
 

// Constraints:
// The number of nodes in the tree is n.
// 1 <= k <= n <= 104
// 0 <= Node.val <= 104
 

// Follow up: If the BST is modified often (i.e., we can do insert and delete operations) and you need to find the kth smallest frequently, how would you optimize?

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

class Solution_Min {
    int mini=0, res=-1;
    public void build(TreeNode node, int k){
        if(node==null || mini>=k) return;
        build(node.left,k);
        mini++;
        if(mini==k) {
            res=node.val;
            return;
        }
        build(node.right,k);
    }
    public int kthSmallest(TreeNode root, int k) {
        build(root, k);
        return res;
    }
}


// Kth largest element in BST

// Given a Binary Search Tree. Your task is to complete the function which will return the kth largest element without doing any modification in the Binary Search Tree.

// Examples:

// Input:
//       4
//     /   \
//    2     9
// k = 2 
// Output: 4
// Explanation: 2nd Largest element in BST is 4
// Input:
//        9
//         \ 
//           10
// k = 1
// Output: 10
// Explanation: 1st Largest element in BST is 10
// Input:
//       4
//     /   \
//    2     9
// k = 3 
// Output: 2
// Explanation: 3rd Largest element in BST is 2
// Constraints:
// 1 <= number of nodes <= 105
// 1 <= node->data <= 105
// 1 <= k <= number of nodes

// Expected Complexities
// Time Complexity: O(n)
// Auxiliary Space: O(Height of BST)


class Node
{
    int data;
    Node left;
    Node right;
    Node(int data)
    {
        this.data = data;
        left=null;
        right=null;
    }
}

class Solution_Max {
    int maxi=0, res=0;
    public void dfs(Node node, int k) {
        if(node==null || maxi>=k) return;
        dfs(node.right, k);
        maxi++;
        if(maxi==k){
            res=node.data;
            return;
        }
        dfs(node.left, k);
    }
    public int kthLargest(Node root, int k) {
        dfs(root,k);
        return res;
    }
}
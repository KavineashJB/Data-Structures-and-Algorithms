// 2385. Amount of Time for Binary Tree to Be Infected

// You are given the root of a binary tree with unique values, and an integer start. At minute 0, an infection starts from the node with value start.

// Each minute, a node becomes infected if:

// The node is currently uninfected.
// The node is adjacent to an infected node.
// Return the number of minutes needed for the entire tree to be infected.


// Example 1:
// Input: root = [1,5,3,null,4,10,6,9,2], start = 3
// Output: 4
// Explanation: The following nodes are infected during:
// - Minute 0: Node 3
// - Minute 1: Nodes 1, 10 and 6
// - Minute 2: Node 5
// - Minute 3: Node 4
// - Minute 4: Nodes 9 and 2
// It takes 4 minutes for the whole tree to be infected so we return 4.

// Example 2:
// Input: root = [1], start = 1
// Output: 0
// Explanation: At minute 0, the only node in the tree is infected so we return 0.
 

// Constraints:

// The number of nodes in the tree is in the range [1, 105].
// 1 <= Node.val <= 105
// Each node has a unique value.
// A node with a value of start exists in the tree.


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


// My Solution: Better Approach
class Solution_1 {
    TreeNode tar = null;
    Queue<TreeNode> q = new LinkedList<>();
    Map<TreeNode, TreeNode> par =new HashMap<>();

    public void level(TreeNode node, int start) {
        q.offer(node);
        while(!q.isEmpty()){
            int len=q.size();
            for(int i=0; i<len; i++){
                TreeNode curr = q.poll();
                if(curr.val==start) tar=curr;
                if(curr.left!=null){
                    q.offer(curr.left);
                    par.put(curr.left, curr);
                }
                if(curr.right!=null){
                    q.offer(curr.right);
                    par.put(curr.right, curr);
                }
            }
        }
    }
    public int time(){
        int start=0;
        q.offer(tar);
        Set<TreeNode> vis = new HashSet<>();
        
        while(!q.isEmpty()) {
            int len = q.size();
            for(int i=0; i<len; i++){
                TreeNode curr = q.poll();
                vis.add(curr);
                if(par.containsKey(curr) && !vis.contains(par.get(curr))){
                    q.offer(par.get(curr));
                    vis.add(par.get(curr));
                }
                if(curr.left!=null && !vis.contains(curr.left)){
                    q.offer(curr.left);
                    vis.add(curr.left);
                }
                if(curr.right!=null && !vis.contains(curr.right)){
                    q.offer(curr.right);
                    vis.add(curr.right);
                }
            }
            start++;
        }
        return start;
    }

    public int amountOfTime(TreeNode root, int start) {
        level(root,start);
        return time()-1;
    }
}

// Optimal Approach
class Solution_2 {
    int maxDepth=0;
    public int helper(TreeNode node, int start){
        if(node==null) return 0;
        
        int leftDepth = helper(node.left, start);
        int rightDepth = helper(node.right, start);
        int depth=0;
        if(node.val==start){
            maxDepth = Math.max(leftDepth, rightDepth);
            depth=-1;
        } else if(leftDepth>=0 && rightDepth>=0) {
            depth=Math.max(leftDepth, rightDepth)+1;
        } else{
            int dist = Math.abs(leftDepth)+Math.abs(rightDepth);
            maxDepth = Math.max(maxDepth, dist);
            depth = Math.min(leftDepth, rightDepth)-1;
        }
        return depth;
    }
    public int amountOfTime(TreeNode root, int start) {
        helper(root, start);
        return maxDepth;
    }
}
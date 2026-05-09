// 199. Binary Tree Right Side View

// Given the root of a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.


// Example 1:
// Input: root = [1,2,3,null,5,null,4]
// Output: [1,3,4]

// Example 2:
// Input: root = [1,2,3,4,null,null,null,5]
// Output: [1,3,4,5]

// Example 3:
// Input: root = [1,null,3]
// Output: [1,3]
// Example 4:
// Input: root = []
// Output: []

// Constraints:
// The number of nodes in the tree is in the range [0, 100].
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

// Better: O(N), O(H)

// TreeMap:
// TreeMap is implemented as a Red-Black Tree (a self-balancing binary search tree)
//  calling hm.containsKey(row) takes $O(log H) time.
class Solution_1 {
    Map<Integer, Integer> hm = new LinkedHashMap<>();
    public void dfs(int row, TreeNode node){
        if(node==null) return;
        if(!hm.containsKey(row)){
            hm.put(row, node.val);
        } 
        dfs(row+1, node.right);
        dfs(row+1, node.left);
    }
    public List<Integer> rightSideView(TreeNode root) {
        dfs(0, root);
        return new ArrayList<Integer>(hm.values());
    }
}

// Better 2: O(N), O(W)-max width of tree
class Solution_2 {
    List<Integer> res;
    public void dfs(TreeNode node){
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(node);
        while(!q.isEmpty()){
            int size=q.size();
            res.add(q.peek().val);
            while(size-->0){
                TreeNode curr=q.poll();
                if(curr.right!=null) q.offer(curr.right);
                if(curr.left!=null) q.offer(curr.left);
            }
        }
    }
    public List<Integer> rightSideView(TreeNode root) {
        res=new ArrayList<>();
        if(root==null) return res;
        dfs(root);
        return res;
    }
}

// Optimal: O(N),O(H)/O(logN)-> H-height of tree and can be traverse in logN (for recursion stack)
class Solution_3 {
    List<Integer> res = new ArrayList<Integer>();
    public void dfs(int row, TreeNode node){
        if(node==null) return;
        if(row==res.size()){
            res.add(node.val);
        } 
        dfs(row+1, node.right);
        dfs(row+1, node.left);
    }
    public List<Integer> rightSideView(TreeNode root) {
        dfs(0, root);
        return res;
    }
}


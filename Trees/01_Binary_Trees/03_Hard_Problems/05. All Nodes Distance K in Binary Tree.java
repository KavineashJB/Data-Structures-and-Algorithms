// 863. All Nodes Distance K in Binary Tree

// Given the root of a binary tree, the value of a target node target, and an integer k, return an array of the values of all nodes that have a distance k from the target node.

// You can return the answer in any order.

// Example 1:
// Input: root = [3,5,1,6,2,0,8,null,null,7,4], target = 5, k = 2
// Output: [7,4,1]
// Explanation: The nodes that are a distance 2 from the target node (with value 5) have values 7, 4, and 1.

// Example 2:
// Input: root = [1], target = 1, k = 3
// Output: []
 

// Constraints:

// The number of nodes in the tree is in the range [1, 500].
// 0 <= Node.val <= 500
// All the values Node.val are unique.
// target is the value of one of the nodes in the tree.
// 0 <= k <= 1000

import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}



class Solution {
    TreeNode tar=null;
    Queue<TreeNode> q = new LinkedList<>();
    Map<TreeNode, TreeNode> par = new HashMap<>();
    Set<TreeNode> vis = new HashSet<>();
    public void level(TreeNode node, TreeNode target){
        q.offer(node);
        while(!q.isEmpty()){
            int len = q.size();
            for(int i=0; i<len; i++){
                TreeNode curr=q.poll();
                if(curr==target) tar=curr;
                if(curr.left!=null) {
                    q.offer(curr.left);
                    par.put(curr.left, curr);
                }
                if(curr.right!=null) {
                    q.offer(curr.right);
                    par.put(curr.right, curr);
                }
                // System.out.println(curr.val);
            }
        }
    }
    public void dist(int k){
        q.offer(tar);
        while(k!=0){
            int len = q.size();
            for(int i=0; i<len; i++){
                TreeNode curr=q.poll();
                vis.add(curr);
                if(par.containsKey(curr) && !vis.contains(par.get(curr))){
                    q.offer(par.get(curr));
                    vis.add(par.get(curr));
                }
                if(curr.left!=null && !vis.contains(curr.left)) {
                    q.offer(curr.left);
                    vis.add(curr.left);
                }
                if(curr.right!=null && !vis.contains(curr.right)) {
                    q.offer(curr.right);
                    vis.add(curr.right);
                }
                System.out.println(curr.val);
            }
            k--;
        }
    }

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        level(root, target);
        dist(k);
        List<Integer> res = new ArrayList<>();
        while(!q.isEmpty()){
            res.add(q.poll().val);
        }
        return res;
    }

    // static {
    //     Runtime.getRuntime().gc();
    //     Runtime.getRuntime().addShutdownHook(new Thread(() -> {
    //         try (FileWriter writer = new FileWriter("display_runtime.txt")) {
    //             writer.write("0");
    //         } catch (IOException e) {
    //             e.printStackTrace();
    //         }
    //     }));
    // }
}

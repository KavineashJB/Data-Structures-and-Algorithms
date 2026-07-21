// Undirected Graph Cycle

// Given an undirected graph with V vertices and E edges, represented as a 2D vector edges[][], where each entry edges[i] = [u, v] denotes an edge between vertices u and v, determine whether the graph contains a cycle or not.

// Note: The graph can have multiple component.

// Examples:

// Input: V = 4, E = 4, edges[][] = [[0, 1], [0, 2], [1, 2], [2, 3]]
// Output: true
// Explanation: 
 
// 1 -> 2 -> 0 -> 1 is a cycle.
// Input: V = 4, E = 3, edges[][] = [[0, 1], [1, 2], [2, 3]]
// Output: false
// Explanation: 
 
// No cycle in the graph.
// Constraints:
// 1 ≤ V, E ≤ 105
// 0 ≤ edges[i][0], edges[i][1] < V

// Expected Complexities
// Time Complexity: O(V + E)
// Auxiliary Space: O(V)


// Problem Link: https://www.geeksforgeeks.org/problems/detect-cycle-in-an-undirected-graph/1
import java.util.*;
class Solution {
    public boolean bfs(int src, ArrayList<ArrayList<Integer>> adj, boolean[] vis){
        Queue<int[]> q=new LinkedList<>();
        q.offer(new int[]{src,-1});
        vis[src]=true;
        
        while(!q.isEmpty()){
            int[] curr=q.poll();
            int node=curr[0];
            int parent = curr[1];
            
            for(int num: adj.get(node)){
                if(!vis[num]){
                    vis[num]=true;
                    q.offer(new int[]{num, node});
                } else if(parent != num){
                    return true;
                }
            }
        }
        return false;
    }
    public boolean dfs(int src, int parent, ArrayList<ArrayList<Integer>> adj, boolean[] vis){
        vis[src]=true;
        
        for(int num: adj.get(src)){
            if(!vis[num]){
                if(dfs(num, src, adj, vis)) return true;
            } else if(num!=parent){
                return true;
            }
        }
        return false;
    }
    public boolean isCycle(int V, int[][] edges) {
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        
        for(int i=0;i<edges.length;i++){
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.get(edges[i][1]).add(edges[i][0]);
        }
        
        boolean[] vis=new boolean[V];
        
        for(int i=0;i<V;i++){
            if(!vis[i]){
                // if(bfs(i, adj, vis)) return true;
                if(dfs(i, -1, adj, vis)) return true;
            }
        }
        return false;
    }
}
// 547. Number of Provinces

// There are n cities. Some of them are connected, while some are not. If city a is connected directly with city b, and city b is connected directly with city c, then city a is connected indirectly with city c.

// A province is a group of directly or indirectly connected cities and no other cities outside of the group.

// You are given an n x n matrix isConnected where isConnected[i][j] = 1 if the ith city and the jth city are directly connected, and isConnected[i][j] = 0 otherwise.

// Return the total number of provinces.

 

// Example 1:
// Input: isConnected = [[1,1,0],[1,1,0],[0,0,1]]
// Output: 2

// Example 2:
// Input: isConnected = [[1,0,0],[0,1,0],[0,0,1]]
// Output: 3
 

// Constraints:

// 1 <= n <= 200
// n == isConnected.length
// n == isConnected[i].length
// isConnected[i][j] is 1 or 0.
// isConnected[i][i] == 1
// isConnected[i][j] == isConnected[j][i]

// Problem Link: https://leetcode.com/problems/number-of-provinces/description/
import java.util.*;
class Solution1 {
    public void dfs(int node, boolean[] vis, ArrayList<ArrayList<Integer>> adj){
        vis[node]=true;

        for(int num: adj.get(node)){
            if(!vis[num]){
                dfs(num,vis,adj);
            }
        }
    }
    public int findCircleNum(int[][] isConnected) {
        int V=isConnected.length;
        boolean[] vis=new boolean[V];
        int c=0;
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();

        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }

        for(int i=0; i<V;i++){
            for(int j=0;j<V;j++){
                if(isConnected[i][j]==1 && i!=j){
                    adj.get(i).add(j);
                    adj.get(j).add(i);
                }
            }
        }
        for(int i=0; i<V; i++){
            if(!vis[i]){
                dfs(i,vis,adj);
                c++;
            }
        }
        return c;
    }
}

// No need to create AdjList - but little tricky
class Solution2 {
    public void dfs(int node, boolean[] vis, int[][] isConnected){
        vis[node]=true;
        int n=isConnected[node-1].length;
        
        for(int i=0; i<n; i++){
            if(!vis[i+1] && isConnected[node-1][i]==1){
                dfs(i+1, vis, isConnected);
            }
        }
    }
    
    public int findCircleNum(int[][] isConnected) {
        int n=isConnected.length;
        boolean vis[]=new boolean[n+1];
        int cnt=0;
        for(int i=1;i<=n;i++){
            if(!vis[i]){
                dfs(i, vis, isConnected);
                cnt++;
            }
        }
        return cnt;
    }
}
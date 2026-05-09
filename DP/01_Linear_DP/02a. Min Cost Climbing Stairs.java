// 746. Min Cost Climbing Stairs

// You are given an integer array cost where cost[i] is the cost of ith step on a staircase. Once you pay the cost, you can either climb one or two steps.

// You can either start from the step with index 0, or the step with index 1.

// Return the minimum cost to reach the top of the floor.


// Example 1:
// Input: cost = [10,15,20]
// Output: 15
// Explanation: You will start at index 1.
// - Pay 15 and climb two steps to reach the top.
// The total cost is 15.

// Example 2:
// Input: cost = [1,100,1,1,1,100,1,1,100,1]
// Output: 6
// Explanation: You will start at index 0.
// - Pay 1 and climb two steps to reach index 2.
// - Pay 1 and climb two steps to reach index 4.
// - Pay 1 and climb two steps to reach index 6.
// - Pay 1 and climb one step to reach index 7.
// - Pay 1 and climb two steps to reach index 9.
// - Pay 1 and climb one step to reach the top.
// The total cost is 6.
 

// Constraints:
// 2 <= cost.length <= 1000
// 0 <= cost[i] <= 999

import java.util.*;
class Solution {
    int[] dp;
    public int rec(int n, int[] cost) {
        if(n<=1) return cost[n];
        return cost[n]+Math.min(rec(n-1,cost),rec(n-2,cost));
    }
    public int mem(int n, int[] cost) {
        if(n<=1) return cost[n];
        if(dp[n]!=-1) return dp[n];
        return dp[n]=cost[n]+Math.min(mem(n-1,cost),mem(n-2,cost));
    }
    public int tab(int n, int[] cost) {
        dp[0]=cost[0];
        dp[1]=cost[1];
        for(int i=2; i<=n; i++){
            dp[i]=cost[i]+Math.min(dp[i-1],dp[i-2]);
        }
        return dp[n];
    }
    public int tabSpace(int n, int[] cost) {
        int prev1, prev2;
        prev2=cost[0];
        prev1=cost[1];
        for(int i=2; i<cost.length; i++){
            int curr=cost[i]+Math.min(prev1, prev2);
            prev2=prev1;
            prev1=curr;
        }
        return Math.min(prev1,prev2);
    }

    public int minCostClimbingStairs(int[] cost) {
        int n=cost.length;
        dp =new int[n];
        Arrays.fill(dp,-1);
        // return Math.min(rec(n-1, cost), rec(n-2, cost));
        // return Math.min(mem(n-1, cost), mem(n-2, cost));
        // return Math.min(tab(n-1, cost), tab(n-2, cost));
        return tabSpace(n-1,cost);
    }
}
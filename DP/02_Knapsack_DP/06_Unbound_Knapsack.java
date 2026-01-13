// Unbounded Knapsack

// You are given ‘n’ items with certain ‘profit’ and ‘weight’ and a knapsack with weight capacity ‘w’.

// You need to fill the knapsack with the items in such a way that you get the maximum profit. You are allowed to take one item multiple times.


// Example:
// Input: 
// 'n' = 3, 'w' = 10, 
// 'profit' = [5, 11, 13]
// 'weight' = [2, 4, 6]

// Output: 27

// Explanation:
// We can fill the knapsack as:

// 1 item of weight 6 and 1 item of weight 4.
// 1 item of weight 6 and 2 items of weight 2.
// 2 items of weight 4 and 1 item of weight 2.
// 5 items of weight 2.

// The maximum profit will be from case 3 = 11 + 11 + 5 = 27. Therefore maximum profit = 27.


// Detailed explanation ( Input/output format, Notes, Images )
// Sample Input 1:
// 3 15
// 7 2 4
// 5 10 20
// Expected Answer: 21
// Output on console: 21
// Explanation of Sample Input 1
// The given knapsack capacity is 15. We can fill the knapsack as [1, 1, 1] giving us profit 21 and as [1,2] giving us profit 9. Thus maximum profit will be 21.


// Sample Input 2
// 2 3
// 6 12
// 4 17
// Expected Answer: 0
// Output on console: 0
// Explanation of Sample Input 2:
// We can clearly see that no item has weight less than knapsack capacity. Therefore we can not fill knapsack with any item.


// Expected Time Complexity:
// Try to solve this in O(n*w).

// Constraints
// 1 <= n <= 10^3
// 1 <= w <= 10^3
// 1 <= profit[i] , weight[i] <= 10^8

// Time Limit: 1 sec

import java.util.Arrays;
class Solution {

    // Time Complexity - O(2^n)
    // Space Complexity - O(n) -> stack for recursion
    public static int rec(int n, int W, int[] profit, int[] weight) {
        if(n==0) {
            return (W/weight[n])*profit[n];
        }
        int nt = 0 + rec(n-1, W, profit, weight);
        int t = Integer.MIN_VALUE;
        if(weight[n]<=W) {
            t = profit[n]+rec(n, W-weight[n], profit, weight);
        }
        return Math.max(nt, t);
    }

    // Time Complexity - O(n)
    // Space Complexity - O(n) -> stack for recursion, O(n) -> dp
    public static int mem(int n, int W, int[] profit, int[] weight, int[][] dp) {
        if(n==0) {
            return (W/weight[n])*profit[n];
        }
        if(dp[n][W]!=-1) return dp[n][W];
        int nt = 0 + mem(n-1, W, profit, weight, dp);
        int t = Integer.MIN_VALUE;
        if(weight[n]<=W) {
            t = profit[n]+mem(n, W-weight[n], profit, weight, dp);
        }
        return dp[n][W]=Math.max(nt, t);
    }

    // Time Complexity - O(n)
    // Space Complexity - O(n) -> dp
    public static int tab(int n, int W, int[] profit, int[] weight, int[][] dp) {
        // for (n==0), the w from 0 to W
        for(int i=0; i<=W; i++) {
            dp[0][i]=(i/weight[0])*profit[0];
        }

        for(int i=1; i<=n; i++) {
            for(int w=0; w<=W; w++) {
                int nt = 0 + dp[i-1][w];
                int t = Integer.MIN_VALUE;
                if(weight[i]<=w) {
                    t = profit[i]+dp[i][w-weight[i]];
                }
                dp[i][w]=Math.max(nt, t);
            }
        }
        return dp[n][W];
    }

    public static int unboundedKnapsack(int n, int w, int[] profit, int[] weight) {
        int[][] dp=new int[n][w+1];
        for(int[] row: dp) {
            Arrays.fill(row, -1);
        }
        // return rec(n-1, w, profit, weight);
        // return mem(n-1, w, profit, weight, dp);
        return tab(n-1, w, profit, weight, dp);
    }
}

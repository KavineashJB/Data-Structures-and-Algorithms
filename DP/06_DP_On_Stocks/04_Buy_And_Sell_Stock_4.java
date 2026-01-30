// 188. Best Time to Buy and Sell Stock IV

// You are given an integer array prices where prices[i] is the price of a given stock on the ith day, and an integer k.
// Find the maximum profit you can achieve. You may complete at most k transactions: i.e. you may buy at most k times and sell at most k times.
// Note: You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).

 
// Example 1:
// Input: k = 2, prices = [2,4,1]
// Output: 2
// Explanation: Buy on day 1 (price = 2) and sell on day 2 (price = 4), profit = 4-2 = 2.

// Example 2:
// Input: k = 2, prices = [3,2,6,5,0,3]
// Output: 7
// Explanation: Buy on day 2 (price = 2) and sell on day 3 (price = 6), profit = 6-2 = 4. Then buy on day 5 (price = 0) and sell on day 6 (price = 3), profit = 3-0 = 3.
 

// Constraints:

// 1 <= k <= 100
// 1 <= prices.length <= 1000
// 0 <= prices[i] <= 1000

// Solution:

import java.util.Arrays;
class Solution {
    public int rec(int ind, int trans, int[] prices) {
        if(ind==prices.length || trans==0) return 0;

        boolean canBuy = trans%2==0;
        if(canBuy) {
            return Math.max(-1*prices[ind]+rec(ind+1, trans-1, prices), rec(ind+1, trans, prices));
        } else {
            return Math.max(prices[ind] + rec(ind+1, trans-1, prices), rec(ind+1, trans, prices));
        }
    }

    public int mem(int ind, int trans, int[] prices, int[][] dp) {
        if(ind==prices.length || trans==0) return 0;
        if(dp[ind][trans]!=-1) return dp[ind][trans];

        boolean canBuy = trans%2==0;
        if(canBuy) {
            return dp[ind][trans]=Math.max(-1*prices[ind]+mem(ind+1, trans-1, prices, dp), mem(ind+1, trans, prices, dp));
        } else {
            return dp[ind][trans]=Math.max(prices[ind] + mem(ind+1, trans-1, prices, dp), mem(ind+1, trans, prices, dp));
        }
    }

    public int tab(int ind, int trans, int[] prices, int[][] dp) {
        for(int j=0; j<=trans; j++) dp[prices.length][j]=0;
        for(int i=0; i<=prices.length; i++) dp[i][0]=0;

        for(int i=prices.length-1; i>=0; i--) {
            for(int j=1; j<=trans; j++) {
                boolean canBuy = j%2==0;
                if(canBuy) {
                    dp[i][j]=Math.max(-1*prices[i]+dp[i+1][j-1], dp[i+1][j]);
                } else {
                    dp[i][j]=Math.max(prices[i] + dp[i+1][j-1], dp[i+1][j]);
                }
            }
        }
        return dp[ind][trans];
    }

    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n+1][(k*2)+1];
        for(int[] row: dp) {
            Arrays.fill(row, -1);
        }
        // return rec(0, k*2, prices);
        // return mem(0, k*2, prices, dp);
        return tab(0, k*2, prices, dp);
    }
}
// 309. Best Time to Buy and Sell Stock with Cooldown

// You are given an array prices where prices[i] is the price of a given stock on the ith day.
// Find the maximum profit you can achieve. You may complete as many transactions as you like (i.e., buy one and sell one share of the stock multiple times) with the following restrictions:
// After you sell your stock, you cannot buy stock on the next day (i.e., cooldown one day).

// Note: You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).

 
// Example 1:
// Input: prices = [1,2,3,0,2]
// Output: 3
// Explanation: transactions = [buy, sell, cooldown, buy, sell]

// Example 2:
// Input: prices = [1]
// Output: 0
 

// Constraints:

// 1 <= prices.length <= 5000
// 0 <= prices[i] <= 1000


// Solution:
import java.util.Arrays;
class Solution {
    public int rec(int ind, int canBuy, int[] prices) {
        if(ind>=prices.length) return 0;
        if(canBuy==1) {
            return Math.max(-1*prices[ind] + rec(ind+1, 0, prices), rec(ind+1, 1, prices));
        } else {
            return Math.max(prices[ind] + rec(ind+2, 1, prices), rec(ind+1, 0, prices));
        }
    }

    public int mem(int ind, int canBuy, int[] prices, int[][] dp) {
        if(ind>=prices.length) return 0;
        if(dp[ind][canBuy]!=-1) return dp[ind][canBuy];

        if(canBuy==1) {
            return dp[ind][canBuy]=Math.max(-1*prices[ind] + mem(ind+1, 0, prices, dp), mem(ind+1, 1, prices, dp));
        } else {
            return dp[ind][canBuy]=Math.max(prices[ind] + mem(ind+2, 1, prices, dp), mem(ind+1, 0, prices, dp));
        }
    }

    public int tab(int ind, int canBuy, int[] prices, int[][] dp) {
        for(int j=0; j<2; j++) {
            dp[prices.length][j]=dp[prices.length+1][j]=0;
        }

        for(int i=prices.length-1; i>=0; i--) {
            for(int j=0; j<2; j++) {
                if(j==1) {
                    dp[i][j]=Math.max(-1*prices[i] + dp[i+1][0], dp[i+1][1]);
                } else {
                    dp[i][j]=Math.max(prices[i] + dp[i+2][1], dp[i+1][0]);
                }
            }
        }
        return dp[ind][canBuy];
    }

    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n+2][2];
        for(int[] row: dp) Arrays.fill(row, -1);

        // return rec(0, 1, prices);
        // return mem(0, 1, prices, dp);
        return tab(0, 1, prices, dp);
    }
}
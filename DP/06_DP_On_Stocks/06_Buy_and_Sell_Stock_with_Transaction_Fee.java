// 714. Best Time to Buy and Sell Stock with Transaction Fee

// You are given an array prices where prices[i] is the price of a given stock on the ith day, and an integer fee representing a transaction fee.
// Find the maximum profit you can achieve. You may complete as many transactions as you like, but you need to pay the transaction fee for each transaction.

// Note:
// You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).
// The transaction fee is only charged once for each stock purchase and sale.
 

// Example 1:
// Input: prices = [1,3,2,8,4,9], fee = 2
// Output: 8
// Explanation: The maximum profit can be achieved by:
// - Buying at prices[0] = 1
// - Selling at prices[3] = 8
// - Buying at prices[4] = 4
// - Selling at prices[5] = 9
// The total profit is ((8 - 1) - 2) + ((9 - 4) - 2) = 8.

// Example 2:
// Input: prices = [1,3,7,5,10,3], fee = 3
// Output: 6
 

// Constraints:
// 1 <= prices.length <= 5 * 104
// 1 <= prices[i] < 5 * 104
// 0 <= fee < 5 * 104


// Solution:
import java.util.Arrays;
class Solution {
    public int rec(int ind, int canBuy, int fee, int[] prices) {
        if(ind==prices.length) return 0;
        if(canBuy==1) {
            return Math.max(-1*prices[ind] + rec(ind+1, 0, fee, prices), rec(ind+1, 1, fee, prices));
        } else {
            return Math.max(prices[ind]-fee + rec(ind+1, 1, fee, prices), rec(ind+1, 0, fee, prices));
        }
    }

    public int mem(int ind, int canBuy, int fee, int[] prices, int[][] dp) {
        if(ind>=prices.length) return 0;
        if(dp[ind][canBuy]!=-1) return dp[ind][canBuy];

        if(canBuy==1) {
            return dp[ind][canBuy]=Math.max(-1*prices[ind] + mem(ind+1, 0, fee, prices, dp), mem(ind+1, 1, fee, prices, dp));
        } else {
            return dp[ind][canBuy]=Math.max(prices[ind]-fee + mem(ind+1, 1, fee, prices, dp), mem(ind+1, 0, fee, prices, dp));
        }
    }

    public int tab(int ind, int canBuy, int fee, int[] prices, int[][] dp) {
        for(int j=0; j<2; j++) {
            dp[prices.length][j]=0;
        }

        for(int i=prices.length-1; i>=0; i--) {
            for(int j=0; j<2; j++) {
                if(j==1) {
                    dp[i][j]=Math.max(-1*prices[i] + dp[i+1][0], dp[i+1][1]);
                } else {
                    dp[i][j]=Math.max(prices[i]-fee + dp[i+1][1], dp[i+1][0]);
                }
            }
        }
        return dp[ind][canBuy];
    }

    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        int[][] dp = new int[n+1][2];
        for(int[] row: dp) Arrays.fill(row, -1);

        // return rec(0, 1, fee, prices);
        // return mem(0, 1, fee, prices, dp);
        return tab(0, 1, fee, prices, dp);

    }
}
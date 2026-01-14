// 518. Coin Change II

// You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.

// Return the number of combinations that make up that amount. If that amount of money cannot be made up by any combination of the coins, return 0.

// You may assume that you have an infinite number of each kind of coin.

// The answer is guaranteed to fit into a signed 32-bit integer.

 
// Example 1:
// Input: amount = 5, coins = [1,2,5]
// Output: 4
// Explanation: there are four ways to make up the amount:
// 5=5
// 5=2+2+1
// 5=2+1+1+1
// 5=1+1+1+1+1

// Example 2:
// Input: amount = 3, coins = [2]
// Output: 0
// Explanation: the amount of 3 cannot be made up just with coins of 2.

// Example 3:
// Input: amount = 10, coins = [10]
// Output: 1
 

// Constraints:

// 1 <= coins.length <= 300
// 1 <= coins[i] <= 5000
// All the values of coins are unique.
// 0 <= amount <= 5000

// Solution:

import java.util.Arrays;
class Solution {

    // Time Complexity - O(2^n)
    // Space Complexity - O(n) -> stack for recursion
    public int rec(int n, int sum, int[] coins) {
        if(sum==0) return 1;
        if(n==0) {
            return (sum%coins[0]==0)?1:0;
        }
        int nt = 0 + rec(n-1, sum, coins);
        int t = 0;
        if(coins[n]<=sum) {
            t = rec(n, sum-coins[n], coins);
        }
        return t+nt;
    }
    
    // Time Complexity - O(n)
    // Space Complexity - O(n) -> stack for recursion, O(n) -> dp
    public int mem(int n, int sum, int[] coins, int[][] dp) {
        if(sum==0) return 1;
        if(n==0) {
            return (sum%coins[0]==0)?1:0;
        }
        if(dp[n][sum]!=-1) return dp[n][sum];
        int nt = 0 + mem(n-1, sum, coins, dp);
        int t = 0;
        if(coins[n]<=sum) {
            t = mem(n, sum-coins[n], coins, dp);
        }
        return dp[n][sum]=t+nt;
    }

    // Time Complexity - O(n)
    // Space Complexity - O(n) -> dp
    public int tab(int n, int sum, int[] coins, int[][] dp) {
        // (sum==0)
        for(int i=0; i<=n; i++) {
            dp[i][0] = 1;
        }

        // (n==0)
        for(int i=0; i<=sum; i++) {
            dp[0][i] =  i%coins[0]==0 ? 1 : 0;
        }

        for(int i=1; i<=n; i++) {
            for(int s=1; s<=sum; s++) {
                int nt = 0 + dp[i-1][s];
                int t = 0;
                if(coins[i]<=s) {
                    t = dp[i][s-coins[i]];
                }
                dp[i][s]=t+nt;
            }
        }
        return dp[n][sum];
    }

    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[][] dp=new int[n][amount+1];
        for(int[] row: dp) {
            Arrays.fill(row, -1);
        }

        // return rec(n-1, amount, coins);
        // return mem(n-1, amount, coins, dp);
        return tab(n-1, amount, coins, dp);
    }
}
// 322. Coin Change

// You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.

// Return the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.

// You may assume that you have an infinite number of each kind of coin.

 

// Example 1:
// Input: coins = [1,2,5], amount = 11
// Output: 3
// Explanation: 11 = 5 + 5 + 1

// Example 2:
// Input: coins = [2], amount = 3
// Output: -1

// Example 3:
// Input: coins = [1], amount = 0
// Output: 0
 
// Example 4:
// Input: coins = [1,3], amount = 3
// Output: 2
 

// Constraints:

// 1 <= coins.length <= 12
// 1 <= coins[i] <= 231 - 1
// 0 <= amount <= 104

// Solution:

import java.util.Arrays;
class Solution {

    // Time Complexity - O(2^n)
    // Space Complexity - O(n) -> stack for recursion
    public int rec(int n, int sum, int[] coins) {
        if (sum == 0) return 0;
        if (n == 0) {
            return (sum % coins[0] == 0) ? sum / coins[0] : (int)1e9;
        }
        int nt = rec(n - 1, sum, coins);
        int t = (int)1e9;
        if (coins[n] <= sum) {
            t = 1 + rec(n, sum - coins[n], coins);
        }
        return Math.min(nt, t);
    }

    // Time Complexity - O(n)
    // Space Complexity - O(n) -> stack for recursion, O(n) -> dp
    public int mem(int n, int sum, int[] coins, int[][] dp) {
        if (sum == 0) return 0;
        if (n == 0) {
            return (sum % coins[0] == 0) ? sum / coins[0] : (int)1e9;
        }
        if(dp[n][sum]!=-1) return dp[n][sum];
        int nt = mem(n - 1, sum, coins, dp);
        int t = (int)1e9;
        if (coins[n] <= sum) {
            t = 1 + mem(n, sum - coins[n], coins, dp);
        }
        return dp[n][sum]=Math.min(nt, t);
    }

    // Time Complexity - O(n)
    // Space Complexity - O(n) -> dp
    public int tab(int n, int sum, int[] coins, int[][] dp) {
        // (sum == 0)
        for(int i=0; i<=n; i++) {
            dp[i][0] = 0;
        }
        // (n == 0)
        for(int i=0; i<=sum; i++) {
            dp[0][i] = (i%coins[0]==0)?i/coins[0] : (int)1e9;
        }

        for(int i=1; i<=n; i++) {
            for(int s=1; s<=sum; s++) {
                int nt = dp[i-1][s];
                int t = (int)1e9;
                if (coins[i] <= s) {
                    t = 1 + dp[i][s-coins[i]];
                }
                dp[i][s]=Math.min(nt, t);
            }
        }
        return dp[n][sum];
    }

    public int coinChange(int[] coins, int amount) {
        int n=coins.length;
        int[][] dp = new int[n][amount+1];
        for(int[] row: dp) {
            Arrays.fill(row, -1);
        }

        // int ans = rec(n - 1, amount, coins);
        // int ans = mem(n - 1, amount, coins, dp);
        int ans = tab(n - 1, amount, coins, dp);
        return ans >= (int)1e9 ? -1 : ans;

    }
}

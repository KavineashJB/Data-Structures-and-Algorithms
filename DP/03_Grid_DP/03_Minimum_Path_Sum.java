// 64. Minimum Path Sum

// Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right, which minimizes the sum of all numbers along its path.

// Note: You can only move either down or right at any point in time.

// Example 1:
// Input: grid = [[1,3,1],[1,5,1],[4,2,1]]
// Output: 7
// Explanation: Because the path 1 → 3 → 1 → 1 → 1 minimizes the sum.

// Example 2:
// Input: grid = [[1,2,3],[4,5,6]]
// Output: 12

// Constraints:
// m == grid.length
// n == grid[i].length
// 1 <= m, n <= 200
// 0 <= grid[i][j] <= 200

// Solution:

import java.util.Arrays;
class Solution {

    // Time Complexity - O(2^n)
    // Space Complexity - O(n) -> stack for recursion
    public int rec(int i, int j, int[][] grid) {
        if (i == 0 && j == 0) return grid[0][0];
        if (i < 0 || j < 0) return (int)1e9;
        int up = rec(i - 1, j, grid);
        int left = rec(i, j - 1, grid);
        return grid[i][j] + Math.min(up, left);
    }

    // Time Complexity - O(n)
    // Space Complexity - O(n) -> stack for recursion, O(n) -> dp
    public int mem(int i, int j, int[][] grid, int[][] dp) {
        if (i == 0 && j == 0) return grid[0][0];
        if (i < 0 || j < 0) return (int)1e9;
        if(dp[i][j]!=-1) return dp[i][j];
        int up = mem(i - 1, j, grid, dp);
        int left = mem(i, j - 1, grid, dp);
        return dp[i][j] = grid[i][j] + Math.min(up, left);
    }

    // Time Complexity - O(n)
    // Space Complexity - O(n) -> dp
    public int tab(int i, int j, int[][] grid, int[][] dp) {
        // (i == 0 && j == 0) 
        dp[0][0]=grid[0][0];
        // (i < 0 || j < 0)
        for(int x=1; x<=i; x++) dp[x][0]=dp[x-1][0]+grid[x][0];
        for(int y=1; y<=j; y++) dp[0][y]=dp[0][y-1]+grid[0][y];

        for(int x=1; x<=i; x++) {
            for(int y=1; y<=j; y++) {
                int up = dp[x - 1][y];
                int left = dp[x][y-1];
                dp[x][y] = grid[x][y] + Math.min(up, left);
            }
        }
        return dp[i][j];
    }

    public int minPathSum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] dp = new int[n][m+1];
        for(int[] row: dp) {
            Arrays.fill(row, -1);
        }

        // return rec(n-1, m-1, grid);
        // return mem(n-1, m-1, grid, dp);
        return tab(n-1, m-1, grid, dp);
    }
}
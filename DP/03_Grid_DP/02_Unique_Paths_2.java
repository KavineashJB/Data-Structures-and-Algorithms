// 63. Unique Paths II

// You are given an m x n integer array grid. There is a robot initially located at the top-left corner (i.e., grid[0][0]). The robot tries to move to the bottom-right corner (i.e., grid[m - 1][n - 1]). The robot can only move either down or right at any point in time.

// An obstacle and space are marked as 1 or 0 respectively in grid. A path that the robot takes cannot include any square that is an obstacle.

// Return the number of possible unique paths that the robot can take to reach the bottom-right corner.

// The testcases are generated so that the answer will be less than or equal to 2 * 109.

 
// Example 1:
// Input: obstacleGrid = [[0,0,0],[0,1,0],[0,0,0]]
// Output: 2
// Explanation: There is one obstacle in the middle of the 3x3 grid above.
// There are two ways to reach the bottom-right corner:
// 1. Right -> Right -> Down -> Down
// 2. Down -> Down -> Right -> Right

// Example 2:
// Input: obstacleGrid = [[0,1],[0,0]]
// Output: 1
 
// Example 3:
// Input: obstacleGrid = [[0,1,0,0]]
// Output: 0
 

// Constraints:

// m == obstacleGrid.length
// n == obstacleGrid[i].length
// 1 <= m, n <= 100
// obstacleGrid[i][j] is 0 or 1.

// Solution:

import java.util.Arrays;
class Solution {

    // Time Complexity - O(2^n)
    // Space Complexity - O(n) -> stack for recursion
    public int rec(int i, int j, int[][] obstacleGrid) {
        if(i==0 && j==0) return 1;
        if(i<0 || j<0 || obstacleGrid[i][j] == 1) return 0;
        int moveTop = rec(i-1, j, obstacleGrid);
        int moveLeft = rec(i, j-1, obstacleGrid);
        return moveTop + moveLeft;
    }

    // Time Complexity - O(n)
    // Space Complexity - O(n) -> stack for recursion, O(n) -> dp
    public int mem(int i, int j, int[][] obstacleGrid, int[][] dp) {
        if(i==0 && j==0) return 1;
        if(i<0 || j<0 || obstacleGrid[i][j] == 1) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        int moveTop = mem(i-1, j, obstacleGrid, dp);
        int moveLeft = mem(i, j-1, obstacleGrid, dp);
        return dp[i][j]=moveTop + moveLeft;
    }

    // Time Complexity - O(n)
    // Space Complexity - O(n) -> dp
    public int tab(int i, int j, int[][] obstacleGrid, int[][] dp) {
        // (i==0 && j==0)
        dp[0][0]=obstacleGrid[0][0]==1?0:1;
        // if(i<0 || j<0 || obstacleGrid[i][j] == 1)
        for(int x=1; x<=i; x++) dp[x][0]=obstacleGrid[x][0]==1?0:dp[x-1][0];
        for(int y=1; y<=j; y++) dp[0][y]=obstacleGrid[0][y]==1?0:dp[0][y-1];

        for(int x=1; x<=i; x++) {
            for(int y=1; y<=j; y++) {
                if(obstacleGrid[x][y]==1) {
                    dp[x][y] = 0;
                } else {
                    int moveTop = dp[x-1][y];
                    int moveLeft = dp[x][y-1];
                    dp[x][y]=moveTop + moveLeft;
                }
            }
        }
        return dp[i][j];
    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        // n -> no.of rows, m -> no.of cols
        int n = obstacleGrid.length;
        int m = obstacleGrid[0].length;
        if(obstacleGrid[n-1][m-1]==1 || obstacleGrid[0][0]==1) return 0;
        int[][] dp = new int[n][m];
        for(int[] row: dp) {
            Arrays.fill(row, -1);
        }
        // return rec(n-1, m-1, obstacleGrid);
        // return mem(n-1, m-1, obstacleGrid, dp);
        return tab(n-1, m-1, obstacleGrid, dp);
    }
}
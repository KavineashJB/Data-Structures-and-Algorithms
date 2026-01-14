// 62. Unique Paths

// There is a robot on an m x n grid. The robot is initially located at the top-left corner (i.e., grid[0][0]). The robot tries to move to the bottom-right corner (i.e., grid[m - 1][n - 1]). The robot can only move either down or right at any point in time.

// Given the two integers m and n, return the number of possible unique paths that the robot can take to reach the bottom-right corner.

// The test cases are generated so that the answer will be less than or equal to 2 * 109.

 

// Example 1:
// Input: m = 3, n = 7
// Output: 28

// Example 2:
// Input: m = 3, n = 2
// Output: 3
// Explanation: From the top-left corner, there are a total of 3 ways to reach the bottom-right corner:
// 1. Right -> Down -> Down
// 2. Down -> Down -> Right
// 3. Down -> Right -> Down
 

// Constraints:
// 1 <= m, n <= 100

// Solution 1:

// import java.util.Arrays;
// class Solution {
//     public int rec(int i, int j, int m, int n) {
//         if(j==n-1) return 1;
//         if(i==m-1) return 1;
//         int moveRight = rec(i, j+1, m, n);
//         int moveDown = rec(i+1, j, m, n);
//         return moveRight + moveDown;
//     }

//     public int mem(int i, int j, int m, int n, int[][] dp) {
//         if(j==n-1) return 1;
//         if(i==m-1) return 1;
//         if(dp[i][j]!=-1) return dp[i][j];
//         int moveRight = mem(i, j+1, m, n, dp);
//         int moveDown = mem(i+1, j, m, n, dp);
//         return dp[i][j]=moveRight + moveDown;
//     }


//     public int uniquePaths(int m, int n) {
//         // m -> no.of rows, n -> no.of cols
//         int[][] dp = new int[m][n];
//         for(int[] row: dp) {
//             Arrays.fill(row, -1);
//         } 
//         // return rec(0, 0, m, n);
//         return mem(0, 0, m, n, dp);

//         // for recursion i used bottom up but we've to use top down (n-1 to 0) but the code rec and mem are right? but to follow the structure and pattern we need to do it in the top down for rec, mem and bottom up for tab
//     }
// }


// Solution 2:

import java.util.Arrays;
class Solution {
    public int rec(int i, int j) {
        if(i==0) return 1;
        if(j==0) return 1;
        int moveLeft = rec(i, j-1);
        int moveTop = rec(i-1, j);
        return moveLeft + moveTop;
    }

    public int mem(int i, int j, int[][] dp) {
        if(i==0) return 1;
        if(j==0) return 1;
        if(dp[i][j]!=-1) return dp[i][j];
        int moveLeft = mem(i, j-1, dp);
        int moveTop = mem(i-1, j, dp);
        return dp[i][j]=moveLeft + moveTop;
    }

    public int tab(int i, int j, int[][] dp) {
        // (i==0)
        for(int x=0; x<=j; x++) dp[0][x] = 1;
        // (j==0)
        for(int x=0; x<=i; x++) dp[x][0] = 1;

        for(int x=1; x<=i; x++) {
            for(int y=1; y<=j; y++) {
                int moveLeft = dp[x][y-1];
                int moveTop = dp[x-1][y];
                dp[x][y]=moveLeft + moveTop;
            }
        }
        return dp[i][j];        
    }

    public int uniquePaths(int m, int n) {
        // m -> no.of rows, n -> no.of cols
        int[][] dp = new int[m][n];
        for(int[] row: dp) {
            Arrays.fill(row, -1);
        } 
        // return rec(m-1, n-1);
        // return mem(m-1, n-1, dp);
        return tab(m-1, n-1, dp);
    }
}
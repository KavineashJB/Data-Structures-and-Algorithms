// 931. Minimum Falling Path Sum

// Given an n x n array of integers matrix, return the minimum sum of any falling path through matrix.

// A falling path starts at any element in the first row and chooses the element in the next row that is either directly below or diagonally left/right. Specifically, the next element from position (row, col) will be (row + 1, col - 1), (row + 1, col), or (row + 1, col + 1).


// Example 1:
// Input: matrix = [[2,1,3],[6,5,4],[7,8,9]]
// Output: 13
// Explanation: There are two falling paths with a minimum sum as shown.

// Example 2:
// Input: matrix = [[-19,57],[-40,-5]]
// Output: -59
// Explanation: The falling path with a minimum sum is shown.
 

// Constraints:

// n == matrix.length == matrix[i].length
// 1 <= n <= 100
// -100 <= matrix[i][j] <= 100

// Solution:

import java.util.Arrays;
class Solution {
    // Time Complexity - O(2^n)
    // Space Complexity - O(n) -> stack for recursion
    public int rec(int i, int j, int n, int m, int[][] matrix) {
        if(i==n) return matrix[i][j];
        if(j<0 || j>m ) return (int)1e9;
        int moveDiagLeft =  rec(i+1, j-1, n, m, matrix);
        int moveDown = rec(i+1, j, n, m, matrix);
        int moveDiagRight = rec(i+1, j+1, n, m, matrix);
        return matrix[i][j] + Math.min(moveDiagLeft, Math.min(moveDown, moveDiagRight));
    }

    // Time Complexity - O(n)
    // Space Complexity - O(n) -> stack for recursion, O(n) -> dp
    public int mem(int i, int j, int n, int m, int[][] matrix, int[][] dp) {
        if(i==n) return matrix[i][j];
        if(j<0 || j>m ) return (int)1e9;
        if(dp[i][j]!=-1) return dp[i][j];
        int moveDiagLeft =  mem(i+1, j-1, n, m, matrix, dp);
        int moveDown = mem(i+1, j, n, m, matrix, dp);
        int moveDiagRight = mem(i+1, j+1, n, m, matrix, dp);
        return dp[i][j]=matrix[i][j] + Math.min(moveDiagLeft, Math.min(moveDown, moveDiagRight));
    }

    // Time Complexity - O(n)
    // Space Complexity - O(n) -> dp
    public int tab(int i, int j, int n, int m, int[][] matrix, int[][] dp) {
        for(int y=0;y<=m;y++) {
            dp[n][y] = matrix[n][y];
        }

        for(int x=n-1; x>=0; x--) {
            for(int y=0; y<=m; y++) {
                int moveDiagLeft = y<=0 ? (int)1e9 : dp[x+1][y-1];
                int moveDown = dp[x+1][y];
                int moveDiagRight = y>=m ? (int)1e9 : dp[x+1][y+1];
                dp[x][y]=matrix[x][y] + Math.min(moveDiagLeft, Math.min(moveDown, moveDiagRight));
            }
        }
        return dp[i][j];
    }

    public int minFallingPathSum(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        int[][] dp = new int[row][col];

        for(int[] rowDp: dp) {
            Arrays.fill(rowDp, -1);
        }

        int ans = Integer.MAX_VALUE;
        for(int j=0; j<col; j++) {
            // ans = Math.min(ans, rec(0, j, row-1, col-1, matrix));
            // ans = Math.min(ans, mem(0, j, row-1, col-1, matrix, dp));
            ans = Math.min(ans, tab(0, j, row-1, col-1, matrix, dp));
        }
        return ans;
    }
}
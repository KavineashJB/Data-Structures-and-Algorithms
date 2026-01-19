// 120. Triangle

// Given a triangle array, return the minimum path sum from top to bottom.

// For each step, you may move to an adjacent number of the row below. More formally, if you are on index i on the current row, you may move to either index i or index i + 1 on the next row.


// Example 1:
// Input: triangle = [[2],[3,4],[6,5,7],[4,1,8,3]]
// Output: 11
// Explanation: The triangle looks like:
//    2
//   3 4
//  6 5 7
// 4 1 8 3
// The minimum path sum from top to bottom is 2 + 3 + 5 + 1 = 11 (underlined above).

// Example 2:
// Input: triangle = [[-10]]
// Output: -10
 

// Constraints:

// 1 <= triangle.length <= 200
// triangle[0].length == 1
// triangle[i].length == triangle[i - 1].length + 1
// -104 <= triangle[i][j] <= 104
 

// Follow up: Could you do this using only O(n) extra space, where n is the total number of rows in the triangle?

// Solution:

import java.util.List;
import java.util.Arrays;
class Solution {
    // Time Complexity - O(2^n)
    // Space Complexity - O(n) -> stack for recursion
    public int rec(int i, int j, int n, List<List<Integer>> tri) {
        if(i==n) return tri.get(i).get(j); 
        int down = rec(i+1, j, n, tri);
        int diag = rec(i+1, j+1, n, tri);
        return tri.get(i).get(j) + Math.min(down, diag);
    }

    // Time Complexity - O(n)
    // Space Complexity - O(n) -> stack for recursion, O(n) -> dp
    public int mem(int i, int j, int n, List<List<Integer>> tri, int[][] dp) {
        if(i==n) return tri.get(i).get(j); 
        if(dp[i][j]!=-1) return dp[i][j];
        int down = mem(i+1, j, n, tri, dp);
        int diag = mem(i+1, j+1, n, tri, dp);
        return dp[i][j] = tri.get(i).get(j) + Math.min(down, diag);
    }

    // Time Complexity - O(n)
    // Space Complexity - O(n) -> dp
    public int tab(int i, int j, int n, List<List<Integer>> tri, int[][] dp) {
        for(int y=0; y<tri.get(n).size(); y++) {
            dp[n][y] = tri.get(n).get(y);
        }

        for(int x=n-1; x>=0; x--) {
            for(int y=0; y<tri.get(x).size(); y++) {
                int down = dp[x+1][y];
                int diag = dp[x+1][y+1];
                dp[x][y] = tri.get(x).get(y) + Math.min(down, diag);
            }
        }
        return dp[i][j];
    }

    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] dp = new int[n][n+1];
        for(int[] row: dp) {
            Arrays.fill(row, -1);
        }

        // return rec(0, 0, n-1, triangle);
        // return mem(0, 0, n-1, triangle, dp);
        return tab(0, 0, n-1, triangle, dp);
    }
}
// 994. Rotting Oranges

// You are given an m x n grid where each cell can have one of three values:

// 0 representing an empty cell,
// 1 representing a fresh orange, or
// 2 representing a rotten orange.
// Every minute, any fresh orange that is 4-directionally adjacent to a rotten orange becomes rotten.

// Return the minimum number of minutes that must elapse until no cell has a fresh orange. If this is impossible, return -1.

 

// Example 1:
// Input: grid = [[2,1,1],[1,1,0],[0,1,1]]
// Output: 4

// Example 2:
// Input: grid = [[2,1,1],[0,1,1],[1,0,1]]
// Output: -1
// Explanation: The orange in the bottom left corner (row 2, column 0) is never rotten, because rotting only happens 4-directionally.

// Example 3:
// Input: grid = [[0,2]]
// Output: 0
// Explanation: Since there are already no fresh oranges at minute 0, the answer is just 0.

// Constraints:
// m == grid.length
// n == grid[i].length
// 1 <= m, n <= 10
// grid[i][j] is 0, 1, or 2.



// Problem Link: https://leetcode.com/problems/rotting-oranges/
import java.util.*;
class Solution {
    // Overall Space Complexity - O(N*M)=> for Queue
    // Overall Time Complexity - O(N*M) + 4*O(N*M)
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int freshOranges = 0;

        // Space - O(N*M)
        Queue<int[]> q = new LinkedList<>();

        // Time - O(N*M)
        // for multiple rotten oranges
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    freshOranges++;
                } else if (grid[i][j] == 2) {
                    q.offer(new int[] { i, j, 0 });
                }
            }
        }

        int minLevel = 0;

        // directions={top, right, bottom, left}
        int[][] dirs = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };

        // Time - 4*O(N*M) => for each vertex take 4 dir fresh oranges
        while (!q.isEmpty()) {
            int i = q.peek()[0];
            int j = q.peek()[1];
            int level = q.peek()[2];
            q.poll();

            minLevel = level;

            // // top
            // if (i > 0 && grid[i - 1][j] == 1) {
            //     q.offer(new int[] { i - 1, j, level + 1 });
            //     grid[i - 1][j] = 2;
            // }

            // // right
            // if (j < grid[0].length - 1 && grid[i][j + 1] == 1) {
            //     q.offer(new int[] { i, j + 1, level + 1 });
            //     grid[i][j + 1] = 2;
            // }

            // // bottom
            // if (i < grid.length - 1 && grid[i + 1][j] == 1) {
            //     q.offer(new int[] { i + 1, j, level + 1 });
            //     grid[i + 1][j] = 2;
            // }

            // // left
            // if (j > 0 && grid[i][j - 1] == 1) {
            //     q.offer(new int[] { i, j - 1, level + 1 });
            //     grid[i][j - 1] = 2;
            // }

            for (int[] dir : dirs) {
                int nrow = i + dir[0];
                int ncol = j + dir[1];

                if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && grid[nrow][ncol] == 1) {
                    q.offer(new int[] { nrow, ncol, level + 1 });
                    grid[nrow][ncol] = 2;
                    freshOranges--;
                }
            }
        }

        // if no fresh oranges return minLevel 
        return freshOranges == 0 ? minLevel : -1;
    }
}
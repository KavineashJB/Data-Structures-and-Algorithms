// 3546. Equal Sum Grid Partition I

// You are given an m x n matrix grid of positive integers. Your task is to determine if it is possible to make either one horizontal or one vertical cut on the grid such that:

// Each of the two resulting sections formed by the cut is non-empty.
// The sum of the elements in both sections is equal.
// Return true if such a partition exists; otherwise return false.


// Example 1:
// Input: grid = [[1,4],[2,3]]
// Output: true
// Explanation: A horizontal cut between row 0 and row 1 results in two non-empty sections, each with a sum of 5. Thus, the answer is true.

// Example 2:
// Input: grid = [[1,3],[2,4]]
// Output: false
// Explanation: No horizontal or vertical cut results in two non-empty sections with equal sums. Thus, the answer is false.

// Constraints:
// 1 <= m == grid.length <= 105
// 1 <= n == grid[i].length <= 105
// 2 <= m * n <= 105
// 1 <= grid[i][j] <= 105

// Better:
class Solution1 {
    public boolean canPartitionGrid(int[][] grid) {
        int n=grid.length, m=grid[0].length;
        long[][] pre=new long[n][m];
        for(int i=0;i<n; i++){
            for(int j=0; j<m; j++){
                long t=i>0?pre[i-1][j]:0;
                long l=j>0?pre[i][j-1]:0;
                long c=(i>0 && j>0)? pre[i-1][j-1]:0;

                pre[i][j] = grid[i][j]+t+l-c;
            }
        }
        if(pre[n-1][m-1]%2==1) return false;
        long sum=pre[n-1][m-1]/2;
        for(int i=0;i<n; i++){
            for(int j=0; j<m; j++){
                if(pre[i][j]==sum) return true;
            }
        }
        return false;
    }
}

// optimal:
class Solution {
    public boolean canPartitionGrid(int[][] grid) {
        final long[] rowSum = new long[grid.length];
        long sum = 0;
        for (int i = 0; i < rowSum.length; ++i) {
            for (final int n : grid[i]) {
                rowSum[i] += n;
            }
            sum += rowSum[i];
        }
        // if sum is odd then there is no 2 equal parts 
        if ((sum % 2) != 0) {
            return false;
        }
        sum /= 2;

        // check Horizontal(row) cut
        long total = 0;
        for (int i = 0; i < rowSum.length - 1 && total < sum; ++i) {
            total += rowSum[i];
        }
        if (total == sum) {
            return true;
        }

        // check vertical(column) cut
        total = 0;
        for (int j = 0; j < grid[0].length - 1 && total < sum; ++j) {
            for (int i = 0; i < grid.length; ++i) {
                total += grid[i][j];
            }
        }
        return total == sum;
    }
}
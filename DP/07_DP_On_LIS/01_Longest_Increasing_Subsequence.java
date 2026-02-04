// 300. Longest Increasing Subsequence

// Given an integer array nums, return the length of the longest strictly increasing subsequence.


// Example 1:
// Input: nums = [10,9,2,5,3,7,101,18]
// Output: 4
// Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.

// Example 2:
// Input: nums = [0,1,0,3,2,3]
// Output: 4

// Example 3:
// Input: nums = [7,7,7,7,7,7,7]
// Output: 1
 

// Constraints:

// 1 <= nums.length <= 2500
// -104 <= nums[i] <= 104
 

// Follow up: Can you come up with an algorithm that runs in O(n log(n)) time complexity?

// Solution:
import java.util.Arrays;
class Solution {
    static int[][] dp;
    public int rec(int prev, int curr, int[] nums) {
        if (curr < 0) return 0;

        int skip = rec(prev, curr - 1, nums);
        int take = 0;
        if (prev == -1 || nums[curr] < nums[prev]) {
            take = 1 + rec(curr, curr - 1, nums);
        }
        return Math.max(take, skip);
    }

    public int mem(int prev, int curr, int[] nums) {
        if (curr < 0) return 0;
        if(dp[prev+1][curr]!=-1) return dp[prev+1][curr];
        int skip = mem(prev, curr - 1, nums);
        int take = 0;
        if (prev == -1 || nums[curr] < nums[prev]) {
            take = 1 + mem(curr, curr - 1, nums);
        }
        return dp[prev+1][curr]=Math.max(take, skip);
    }

    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        dp = new int[n+1][n];
        for(int[] row: dp) Arrays.fill(row, -1);

        // return rec(-1, nums.length-1, nums);
        return mem(-1, nums.length-1, nums);
    }
}
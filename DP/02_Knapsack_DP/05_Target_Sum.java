// 494. Target Sum

// You are given an integer array nums and an integer target.
// You want to build an expression out of nums by adding one of the symbols '+' and '-' before each integer in nums and then concatenate all the integers.

// For example, if nums = [2, 1], you can add a '+' before 2 and a '-' before 1 and concatenate them to build the expression "+2-1".
// Return the number of different expressions that you can build, which evaluates to target.

 

// Example 1:
// Input: nums = [1,1,1,1,1], target = 3
// Output: 5
// Explanation: There are 5 ways to assign symbols to make the sum of nums be target 3.
// -1 + 1 + 1 + 1 + 1 = 3
// +1 - 1 + 1 + 1 + 1 = 3
// +1 + 1 - 1 + 1 + 1 = 3
// +1 + 1 + 1 - 1 + 1 = 3
// +1 + 1 + 1 + 1 - 1 = 3

// Example 2:
// Input: nums = [1], target = 1
// Output: 1

// Example 3:
// Input: nums = [1000], target = -1000
// Output: 1
 

// Constraints:

// 1 <= nums.length <= 20
// 0 <= nums[i] <= 1000
// 0 <= sum(nums[i]) <= 1000
// -1000 <= target <= 1000

// Solution:

import java.util.Arrays;
class Solution {

    // Time Complexity - O(2^n)
    // Space Complexity - O(n) -> stack for recursion
    public int rec(int n, int sum, int[] nums) {
        if(n<0) {
            return sum==0?1:0;
        }
        int sub = rec(n-1, sum+nums[n], nums);
        int add = rec(n-1, sum-nums[n], nums);;
        
        return add+sub;
    }

    // Time Complexity - O(n)
    // Space Complexity - O(n) -> stack for recursion, O(n) -> dp
    public int mem(int n, int sum, int[] nums, int[][] dp) {
         if(n<0) {
            return sum==0?1:0;
        }
        if(dp[n][sum]!=-1) return dp[n][sum];
        int sub = rec(n-1, sum+nums[n], nums);
        int add = rec(n-1, sum-nums[n], nums);;
        
        return dp[n][sum]=add+sub;
    }

    public int findTargetSumWays(int[] nums, int target) {
        int n=nums.length;
        target = Math.abs(target);
        int[][] dp=new int[n][target+1];
        for(int[] row:dp) Arrays.fill(row, -1);
        // return rec(n-1, target, nums);
        return mem(n-1, target, nums, dp);
    }
}
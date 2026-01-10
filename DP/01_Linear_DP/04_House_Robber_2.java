// 213. House Robber II

// You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed. All houses at this place are arranged in a circle. That means the first house is the neighbor of the last one. Meanwhile, adjacent houses have a security system connected, and it will automatically contact the police if two adjacent houses were broken into on the same night.

// Given an integer array nums representing the amount of money of each house, return the maximum amount of money you can rob tonight without alerting the police.

 

// Example 1:
// Input: nums = [2,3,2]
// Output: 3
// Explanation: You cannot rob house 1 (money = 2) and then rob house 3 (money = 2), because they are adjacent houses.

// Example 2:
// Input: nums = [1,2,3,1]
// Output: 4
// Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
// Total amount you can rob = 1 + 3 = 4.

// Example 3:
// Input: nums = [1,2,3]
// Output: 3
 
// Example 4:
// Input: nums = [6, 5]
// Output: 6
 
// Example 3:
// Input: nums = [2]
// Output: 2
 

// Constraints:

// 1 <= nums.length <= 100
// 0 <= nums[i] <= 1000

// Solution:

import java.util.Arrays;
class Solution {

    // Time Complexity - O(2^n)
    // Space COmplexity - O(n) -> stack for recursion 
    public int rec(int start, int n, int[] nums) {
        if(n==start) return nums[n];
        if(n<start) return 0;
        int pick = nums[n] + rec(start, n-2, nums);
        int notPick = 0 + rec(start, n-1, nums);
        return Math.max(pick, notPick);
    }

    // Time Complexity - O(n)
    // Space COmplexity - O(n) -> stack for recursion, O(n) -> dp
    public int mem(int start, int n, int[] nums, int[] dp) {
        if(n==start) return nums[n];
        if(n<start) return 0;
        if(dp[n]!=-1) return dp[n];
        int p = nums[n] + mem(start, n-2, nums, dp);
        int np = 0 + mem(start, n-1, nums, dp);
        return dp[n] = Math.max(p, np);
    }

    // Time Complexity - O(n)
    // Space COmplexity - O(n) -> dp
    public int tab(int start, int n, int[] nums, int[] dp) {
        if(n==start) return nums[n];
        dp[start]=nums[start];
        dp[start+1]=Math.max(nums[start], nums[start+1]);
        for(int i=start+2; i<=n; i++) {
            int p = nums[i] + dp[i-2];
            int np = 0 + dp[i-1];
            dp[i] = Math.max(p, np);
        }
        return dp[n];
    }

    public int tabSpace(int start, int n, int[] nums) {
        if(n==start) return nums[n];
        int prev2 = nums[start];
        int prev1 = Math.max(nums[start], nums[start+1]);
        for(int i=start+2; i<=n; i++) {
            int p = nums[i] + prev2;
            int np = 0 + prev1;
            int curr = Math.max(p, np);
            prev2 = prev1;
            prev1 = curr;
        }
        return prev1;
    }

    public int rob(int[] nums) {
        int n=nums.length;
        int[] dp = new int[n];
        // length of first and last arr is n-1
        if(n==1) return nums[0];
        Arrays.fill(dp, -1);
        int first, last;

        // first = rec(0, n-2, nums);
        // Arrays.fill(dp, -1);
        // last = rec(1, n-1, nums);
        // return Math.max(first, last); 
        
        // first = mem(0, n-2, nums, dp);
        // Arrays.fill(dp, -1);
        // last = mem(1, n-1, nums, dp);
        // return Math.max(first, last); 

        // first = tab(0, n-2, nums, dp);
        // Arrays.fill(dp, -1);
        // last = tab(1, n-1, nums, dp);
        // return Math.max(first, last); 

        first = tabSpace(0, n-2, nums);
        Arrays.fill(dp, -1);
        last = tabSpace(1, n-1, nums);
        return Math.max(first, last); 

    }
}

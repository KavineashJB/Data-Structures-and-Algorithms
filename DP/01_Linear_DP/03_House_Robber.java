// 198. House Robber

// You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security systems connected and it will automatically contact the police if two adjacent houses were broken into on the same night.

// Given an integer array nums representing the amount of money of each house, return the maximum amount of money you can rob tonight without alerting the police.

 

// Example 1:

// Input: nums = [1,2,3,1]
// Output: 4
// Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
// Total amount you can rob = 1 + 3 = 4.

// Example 2:

// Input: nums = [2,7,9,3,1]
// Output: 12
// Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 (money = 1).
// Total amount you can rob = 2 + 9 + 1 = 12.
 
// Example 3:

// Input: nums = [2,1,1,2]
// Output: 4

// Example 4:

// Input: nums = [2,1]
// Output: 2


// Constraints:

// 1 <= nums.length <= 100
// 0 <= nums[i] <= 400

// Solution:

import java.util.Arrays;
class Solution {

    // Time Complexity - O(2^n)
    // Space COmplexity - O(n) -> stack for recursion 
    public int rec(int n, int[] nums) {
        if(n==0) return nums[0];
        if(n<0) return 0;
        int pick = nums[n] + rec(n-2, nums);
        int notPick = 0 + rec(n-1, nums);
        return Math.max(pick, notPick);
    }

    // Time Complexity - O(n)
    // Space COmplexity - O(n) -> stack for recursion, O(n) -> dp
    public int mem(int n, int[] nums, int[] dp) {
        if(n==0) return nums[0];
        if(n<0) return 0;
        if(dp[n]!=-1) return dp[n];
        int p = nums[n] + mem(n-2, nums, dp);
        int np = 0 + mem(n-1, nums, dp);
        return dp[n] = Math.max(p, np);
    }

    // Time Complexity - O(n)
    // Space COmplexity - O(n) -> dp
    public int tab(int n, int[] nums, int[] dp) {
        if(n==0) return nums[0];
        dp[0]=nums[0];
        dp[1]=Math.max(nums[0], nums[1]);
        for(int i=2; i<=n; i++) {
            int p = nums[i] + dp[i-2];
            int np = 0 + dp[i-1];
            dp[i] = Math.max(p, np);
        }
        return dp[n];
    }

    public int tabSpace(int n, int[] nums) {
        if(n==0) return nums[0];
        int prev2 = nums[0];
        int prev1 = Math.max(nums[0], nums[1]);
        for(int i=2; i<=n; i++) {
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
        Arrays.fill(dp, -1);
        // return rec(n-1, nums);
        // return mem(n-1, nums, dp);
        // return tab(n-1, nums, dp);
        return tabSpace(n-1, nums);
    }
}
// 45. Jump Game II

// You are given a 0-indexed array of integers nums of length n. You are initially positioned at index 0.
// Each element nums[i] represents the maximum length of a forward jump from index i. In other words, if you are at index i, you can jump to any index (i + j) where:
// 0 <= j <= nums[i] and
// i + j < n
// Return the minimum number of jumps to reach index n - 1. The test cases are generated such that you can reach index n - 1.

// Example 1:
// Input: nums = [2,3,1,1,4]
// Output: 2
// Explanation: The minimum number of jumps to reach the last index is 2. Jump 1 step from index 0 to 1, then 3 steps to the last index.

// Example 2:
// Input: nums = [2,3,0,1,4]
// Output: 2
 
// Constraints:
// 1 <= nums.length <= 104
// 0 <= nums[i] <= 1000
// It's guaranteed that you can reach nums[n - 1].

// Problem Link: https://leetcode.com/problems/jump-game-ii/
class Solution {

    // TC: O(n^2)
    // SC: O(n^2)
    // int dp[];
    // public int mem(int ind, int[] nums){
    //     if(ind==nums.length-1) return dp[ind]=1;
    //     if(dp[ind]!=-1) return dp[ind];

    //     dp[ind]=Integer.MAX_VALUE;
    //     for(int i=1; ind<nums.length && i<=nums[ind];i++){
    //         dp[ind]=Math.min(dp[ind], 1+mem(ind+i, nums));
    //     }
    //     return dp[ind];
    // }
    // public int jump(int[] nums) {
    //     int n=nums.length;
    //     dp=new int[n+1];
    //     Arrays.fill(dp,-1);
    //     return mem(0,nums);
    // }

    public int jump(int[] nums) {
        int n=nums.length;
        int jumps=0;
        int l=0, r=0;
        while(r<n-1){
            int maxi=0;
            for(int i=l;i<=r;i++){
                maxi=Math.max(maxi, i+nums[i]);
            }
            l=r+1;
            r=maxi;
            jumps++;
        }
        return jumps;
    }
}
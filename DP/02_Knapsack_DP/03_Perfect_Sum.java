// Perfect Sum Problem

// Given an array arr of non-negative integers and an integer target, the task is to count all subsets of the array whose sum is equal to the given target.

// Examples:

// Input: arr[] = [5, 2, 3, 10, 6, 8], target = 10
// Output: 3
// Explanation: The subsets {5, 2, 3}, {2, 8}, and {10} sum up to the target 10.

// Input: arr[] = [2, 5, 1, 4, 3], target = 10
// Output: 3
// Explanation: The subsets {2, 1, 4, 3}, {5, 1, 4}, and {2, 5, 3} sum up to the target 10.

// Input: arr[] = [5, 7, 8], target = 3
// Output: 0
// Explanation: There are no subsets of the array that sum up to the target 3.

// Input: arr[] = [35, 2, 8, 22], target = 0
// Output: 1
// Explanation: The empty subset is the only subset with a sum of 0.


// Constraints:
// 1 ≤ arr.size() ≤ 103
// 0 ≤ arr[i] ≤ 103
// 0 ≤ target ≤ 103

// Solution:

class Solution {
    // Time Complexity - O(2^n)
    // Space Complexity - O(n) -> stack for recursion
    public int rec(int n, int sum, int[] nums) {
        if(n==0) {
            if(sum==0 && nums[n]==0) return 2;
            if(sum==0 || nums[n]==sum) return 1;
            return 0;
        }
        
        int nt=rec(n-1, sum, nums);
        int t=0;
        if(nums[n]<=sum) {
            t = rec(n-1, sum-nums[n], nums);
        }
        return t+nt;
    }
    
    // Time Complexity - O(n)
    // Space Complexity - O(n) -> stack for recursion, O(n) -> dp
    public int mem(int n, int sum, int[] nums, int[][] dp) {
        if(n==0) {
            if(sum==0 && nums[n]==0) return 2;
            if(sum==0 || nums[n]==sum) return 1;
            return 0;
        }
        if(dp[n][sum]!=-1) return dp[n][sum];
        
        int nt=mem(n-1, sum, nums, dp);
        int t=0;
        if(nums[n]<=sum) {
            t = mem(n-1, sum-nums[n], nums, dp);
        }
        return dp[n][sum]=t+nt;
    }
    
    // Time Complexity - O(n)
    // Space Complexity - O(n) -> dp
    public int tab(int n, int sum, int[] nums, int[][] dp) {
        
        if(nums[0]==0) {
            dp[0][0]=2;
        } else {
            dp[0][0]=1;
        }
        
        // nums[n]==sum
        if(nums[0]!=0 && nums[0]<=sum) {
            dp[0][nums[0]]=1;
        }
        
        for(int i=1; i<=n; i++) {
            for(int s=0; s<=sum; s++) {
                int nt=dp[i-1][s];
                int t=0;
                if(nums[i]<=s) {
                    t = dp[i-1][s-nums[i]];
                }
                dp[i][s]=t+nt;
            }
        }
        return dp[n][sum];
    }
    
    public int perfectSum(int[] nums, int target) {
        int n = nums.length;
        int[][] dp = new int[n][target+1];
        // for(int[] row: dp){
        //     Arrays.fill(row, -1);
        // }
        
        // return rec(n-1, target, nums);
        // return mem(n-1, target, nums, dp);
        return tab(n-1, target, nums, dp);
    }
}
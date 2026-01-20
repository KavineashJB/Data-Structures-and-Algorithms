// 416. Partition Equal Subset Sum

// Given an integer array nums, return true if you can partition the array into two subsets such that the sum of the elements in both subsets is equal or false otherwise.

 
// Example 1:
// Input: nums = [1,5,11,5]
// Output: true
// Explanation: The array can be partitioned as [1, 5, 5] and [11].

// Example 2:
// Input: nums = [1,2,3,5]
// Output: false
// Explanation: The array cannot be partitioned into equal sum subsets.
 

// Constraints:

// 1 <= nums.length <= 200
// 1 <= nums[i] <= 100

// Solution:

class Solution {
    
    // Time Complexity - O(2^n)
    // Space Complexity - O(n) -> stack for recursion
    public boolean rec(int n, int sum, int[] nums) {
        if(sum==0) return true;
        if(n==0) return nums[n]==sum;
        boolean nt = rec(n-1, sum, nums);
        boolean t = false;
        if(nums[n]<=sum) {
            t = rec(n-1, sum-nums[n], nums);
        }
        return t || nt;
    }

    // Time Complexity - O(n)
    // Space Complexity - O(n) -> stack for recursion, O(n) -> dp
    public boolean mem(int n, int sum, int[] nums, Boolean[][] dp) {
        if(sum==0) return true;
        if(n==0) return nums[n]==sum;
        if(dp[n][sum] != null) return dp[n][sum];
        boolean nt = mem(n-1, sum, nums, dp);
        boolean t = false;
        if(nums[n]<=sum) {
            t = mem(n-1, sum-nums[n], nums, dp);
        }
        return dp[n][sum] = t || nt;
    }

    // Time Complexity - O(n)
    // Space Complexity - O(n) -> dp
    public boolean tab(int n, int sum, int[] nums, boolean[][] dp) {
        for(int i=0; i<=n; i++) dp[i][0] = true;

        if(nums[0]<=sum) dp[0][nums[0]]=true;

        for(int i=1; i<=n; i++){
            for(int s=1; s<=sum; s++) {
                boolean nt = dp[i-1][s];
                boolean t = false;
                if(nums[i]<=s) {
                    t = dp[i-1][s-nums[i]];
                }
                dp[i][s]=t||nt;
            }
        }
        return dp[n][sum];
    }

    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum=0;
        for(int i:nums) sum+=i;
        if(sum%2==1) return false;

        Boolean[][] memDp = new Boolean[n][sum+1];
        boolean[][] tabDp = new boolean[n][sum+1];

        // return rec(n-1, sum/2, nums);
        return mem(n-1, sum/2, nums, memDp);
        // return tab(n-1, sum/2, nums, tabDp);
    }
}
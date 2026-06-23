// 55. Jump Game

// You are given an integer array nums. You are initially positioned at the array's first index, and each element in the array represents your maximum jump length at that position.
// Return true if you can reach the last index, or false otherwise.

// Example 1:
// Input: nums = [2,3,1,1,4]
// Output: true
// Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.

// Example 2:
// Input: nums = [3,2,1,0,4]
// Output: false
// Explanation: You will always arrive at index 3 no matter what. Its maximum jump length is 0, which makes it impossible to reach the last index.
 
// Constraints:
// 1 <= nums.length <= 104
// 0 <= nums[i] <= 10555.


// Problem Link: https://leetcode.com/problems/jump-game/
class Solution {
    // TC: O(n^2); - due to the inner for loop
    // SC: O(n);
    // for memoization
    // Boolean dp[];
    // public boolean mem(int ind, int[] nums){
    //     if(ind==nums.length-1) return dp[ind]=true;
    //     if(nums[ind]==0) return dp[ind]=false;
    //     if(dp[ind]!=null) return dp[ind];
        
    //     dp[ind]=false;
    //     for(int i=1;i<=nums[ind];i++){
    //         dp[ind]=dp[ind]|| mem(ind+i, nums);
    //     }
    //     return dp[ind];
    // }
    // public boolean canJump(int[] nums) {
    //     dp=new Boolean[nums.length];
    //     Arrays.fill(dp, null);
    //     return mem(0, nums);
    // }

    // TC=O(n^2)
    // SC=O(n)
    // public boolean canJump(int[] nums) {
    //     int n=nums.length;
    //     boolean vis[]=new boolean[n];
    //     if(nums[0]==0) return false;

    //     vis[0]=true;
    //     for(int i=0;i<n;i++){
    //         if(nums[i]==0) continue;
    //         for(int j=i+1;j<=i+nums[i] && j<n;j++){
    //             vis[j]=true;
    //         }
    //     }

    //     for(int i=0;i<n;i++){
    //         if(!vis[i]) return false;
    //     }
    //     return true;
    // }

    // TC: O(n)
    // SC: O(1)
    public boolean canJump(int[] nums) {
        int n=nums.length;
        int maxInd=0;

        for(int i=0;i<=maxInd;i++){
            if(maxInd>=n-1) return true;
            maxInd=Math.max(maxInd, i+nums[i]);
        }
        return maxInd>=n-1;
    }
}
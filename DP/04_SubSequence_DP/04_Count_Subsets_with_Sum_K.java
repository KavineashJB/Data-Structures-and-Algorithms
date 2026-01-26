// Count Subsets with Sum K

// You are given an array 'arr' of size 'n' containing positive integers and a target sum 'k'.
// Find the number of ways of selecting the elements from the array such that the sum of chosen elements is equal to the target 'k'.
// Since the number of ways can be very large, print it modulo 10 ^ 9 + 7.


// Example:
// Input: 'arr' = [1, 1, 4, 5]
// Output: 3
// Explanation: The possible ways are:
// [1, 4]
// [1, 4]
// [5]
// Hence the output will be 3. Please note that both 1 present in 'arr' are treated differently.
// Detailed explanation ( Input/output format, Notes, Images )
// Sample Input 1 :
// 4 5
// 1 4 4 5

// Sample Output 1 :
//  3

// The possible ways are:
// [1, 4]
// [1, 4]
// [5]
// Hence the output will be 3. Please note that both 1 present in 'arr' are treated differently.

// Sample Input 2 :
// 3 2
// 1 1 1

// Sample Output 2 :
// 3
// There are three 1 present in the array. Answer is the number of ways to choose any two of them.

// Sample Input 3 :
// 3 40
// 2 34 5

// Sample Output 3 :
// 0

// Expected time complexity :
// The expected time complexity is O('n' * 'k').


// Constraints:
// 1 <= 'n' <= 100
// 0 <= 'arr[i]' <= 1000
// 1 <= 'k' <= 1000

// Time limit: 1 sec

// Solution:

import java.util.Arrays;
class Solution {
    static int mod = 1000000007;
    // Time Complexity - O(2^n)
    // Space Complexity - O(n) -> stack for recursion
    public static int rec(int n, int sum, int[] nums) {
        if(n==0) {
            if(sum==0 && nums[0]==0) return 2;
            if(sum==0 || nums[0]==sum) return 1;
            return 0;
        }
        int nt = rec(n-1, sum, nums);
        int t = 0;
        if(sum>=nums[n]) {
            t = rec(n-1, sum-nums[n], nums);
        }
        return nt + t;
    }

    // Time Complexity - O(n)
    // Space Complexity - O(n) -> stack for recursion, O(n) -> dp
    public static int mem(int n, int sum, int[] nums, int[][] dp) {
        if(n == 0) {
            if(sum == 0 && nums[0] == 0) return 2;
            if(sum == 0 || nums[0] == sum) return 1;
            return 0;
        }
        if(dp[n][sum] != -1) return dp[n][sum];
        int nt = mem(n-1, sum, nums, dp);
        int t = 0;
        if(sum >= nums[n]) {
            t = mem(n-1, sum - nums[n], nums, dp);
        }
        return dp[n][sum] = (nt + t) % mod;
    }

    // Time Complexity - O(n)
    // Space Complexity - O(n) -> dp
    public static int tab(int n, int sum, int[] nums, int[][] dp) {
        // Initialize base cases
        if(nums[0] == 0) {
            dp[0][0] = 2;  // Two ways: take or not take 0
        } else {
            dp[0][0] = 1;  // Only one way: don't take nums[0]
        }
        // Initialize for sum = nums[0] (if it's not 0)
        if(nums[0]!=0 && sum>=nums[0]) dp[0][nums[0]]=1;

        for(int i=1; i<=n; i++) {
            for(int s=0; s<=sum; s++) {
                int nt = dp[i-1][s];
                int t = 0;
                if(s >= nums[i]) {
                    t = dp[i-1][s-nums[i]];
                }
                
                dp[i][s] = (nt + t) % mod;
            }
        }
        return dp[n][sum];
    }
    public static int findWays(int num[], int tar) {
        int n = num.length;
        int[][] dp = new int[n][tar+1];
        
        for(int[] row: dp) {
            Arrays.fill(row, -1);
        }

        // return rec(n-1, tar, num);
        // return mem(n-1, tar, num, dp);
        return tab(n-1, tar, num, dp);
    }
}
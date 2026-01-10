// Subset Sum Problem

// Given an array of positive integers arr[] and a value sum, determine if there is a subset of arr[] with sum equal to given sum. 

// Examples:

// Input: arr[] = [3, 34, 4, 12, 5, 2], sum = 9
// Output: true 
// Explanation: Here there exists a subset with target sum = 9, 4+3+2 = 9.

// Input: arr[] = [3, 34, 4, 12, 5, 2], sum = 30
// Output: false
// Explanation: There is no subset with target sum 30.

// Input: arr[] = [1, 2, 3], sum = 6
// Output: true
// Explanation: The entire array can be taken as a subset, giving 1 + 2 + 3 = 6.


// Constraints:
// 1 <= arr.size() <= 200
// 1<= arr[i] <= 200
// 1<= sum <= 104


// Solution:

class Solution {
    
    // Time Complexity - O(2^n)
    // Space Complexity - O(n) -> stack for recursion
    static Boolean rec(int n, int[] arr, int sum) {
        if(n == 0) return arr[n]==sum;
        if(sum==0) return true;
        Boolean nt = rec(n-1, arr, sum);
        Boolean t = false;
        if(arr[n]<=sum) {
            t = rec(n-1, arr, sum-arr[n]);
        }
        return t || nt;
    }
    
    // Time Complexity - O(n)
    // Space Complexity - O(n) -> stack for recursion, O(n) -> dp
    static Boolean mem(int n, int[] arr, int sum, Boolean[][] dp) {
        if(sum == 0) return true;
        if(n == 0) return arr[n]==sum;
        if(dp[n][sum] != null) return dp[n][sum];
        Boolean nt = mem(n-1, arr, sum, dp);
        Boolean t = false;
        if(arr[n]<=sum) {
            t = mem(n-1, arr, sum-arr[n], dp);
        }
        return dp[n][sum]= t || nt;
    }
    
    // Time Complexity - O(n)
    // Space Complexity - O(n) -> dp
    static boolean tab(int n, int[] arr, int sum, boolean[][] dp) {
        // sum==0 return true;
        for(int i=0; i<=n; i++) dp[i][0]=true;
        
        // n==0 return arr[n]==sum
        if(arr[0]<=sum) dp[0][arr[0]] = true;
        
        for(int i=1; i<=n; i++) {
            for(int s=1; s<=sum; s++){
                Boolean nt = dp[i-1][s];
                Boolean t = false;
                if(arr[i]<=s) {
                    t = dp[i-1][s-arr[i]];
                }
                dp[i][s]= t || nt;
            }
        }
        return dp[n][sum];
    }
    
    
    static Boolean isSubsetSum(int arr[], int sum) {
        int n=arr.length;
        // Boolean[][] memDp=new Boolean[n][sum+1];
        
        // creating bool DP instead of Bool DP due to the Bool can have null values 
        // which can be allowed in memoization but not in tabulation
        boolean[][] tabDp=new boolean[n][sum+1];
        
        // return rec(n-1, arr, sum);
        // return mem(n-1, arr, sum, memDp);
        return tab(n-1, arr, sum, tabDp);
    }
}
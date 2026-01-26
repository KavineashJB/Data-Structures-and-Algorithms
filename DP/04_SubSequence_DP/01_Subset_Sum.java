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
    static Boolean rec(int n, int sum, int[] arr) {
        if(sum==0) return true;
        if(n==0) return arr[0]==sum;
        
        boolean nt = rec(n-1, sum, arr);
        boolean t = false;
        if(sum>=arr[n]) {
            t = rec(n-1, sum-arr[n], arr);
        }
        return nt || t;
    }
    
    // Time Complexity - O(n)
    // Space Complexity - O(n) -> stack for recursion, O(n) -> dp
    static Boolean mem(int n, int sum, int[] arr, Boolean[][] dp) {
        if(sum==0) return true;
        if(n==0) return arr[0]==sum;
        if(dp[n][sum] != null) return dp[n][sum];
        boolean nt = mem(n-1, sum, arr, dp);
        boolean t = false;
        if(sum>=arr[n]) {
            t = mem(n-1, sum-arr[n], arr, dp);
        }
        return dp[n][sum]=nt || t;
    }
    
    // Time Complexity - O(n)
    // Space Complexity - O(n) -> dp
    static boolean tab(int n, int sum, int[] arr, boolean[][] dp) {
        for(int i=0; i<=n; i++) {
            dp[i][0] = true;
        }
        if(sum>=arr[0]) dp[0][arr[0]]=true;
        
        for(int i=1; i<=n; i++) {
            for(int s=1; s<=sum; s++) {
                boolean nt = dp[i-1][s];
                boolean t = false;
                if(s>=arr[i]) {
                    t = dp[i-1][s-arr[i]];
                }
                dp[i][s]=nt || t;
            }
        }
        return dp[n][sum];
    }
    
    static Boolean isSubsetSum(int arr[], int sum) {
        int n = arr.length;
        // Boolean[][] memDp = new Boolean[n][sum+1];
        boolean[][] tabDp = new boolean[n][sum+1];
        // return rec(n-1, sum, arr);
        // return mem(n-1, sum, arr, memDp);
        return tab(n-1, sum, arr, tabDp);
    }
}
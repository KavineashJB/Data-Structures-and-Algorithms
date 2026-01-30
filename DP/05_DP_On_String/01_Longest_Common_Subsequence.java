// 1143. Longest Common Subsequence

// Given two strings text1 and text2, return the length of their longest common subsequence. If there is no common subsequence, return 0.
// A subsequence of a string is a new string generated from the original string with some characters (can be none) deleted without changing the relative order of the remaining characters.

// For example, "ace" is a subsequence of "abcde".
// A common subsequence of two strings is a subsequence that is common to both strings.

 

// Example 1:
// Input: text1 = "abcde", text2 = "ace" 
// Output: 3  
// Explanation: The longest common subsequence is "ace" and its length is 3.

// Example 2:
// Input: text1 = "abc", text2 = "abc"
// Output: 3
// Explanation: The longest common subsequence is "abc" and its length is 3.

// Example 3:
// Input: text1 = "abc", text2 = "def"
// Output: 0
// Explanation: There is no such common subsequence, so the result is 0.
 

// Constraints:

// 1 <= text1.length, text2.length <= 1000
// text1 and text2 consist of only lowercase English characters.

// Solution:

import java.util.Arrays;
class Solution {
    // Time Complexity - O(2^n)
    // Space Complexity - O(n) -> stack for recursion
    public int rec(int n1, int n2, String s1, String s2) {
        if(n1<0 || n2<0) return 0;
        if(s1.charAt(n1)==s2.charAt(n2)) {
            return 1 + rec(n1-1, n2-1, s1, s2);
        }
        return Math.max(rec(n1-1, n2, s1, s2), rec(n1, n2-1, s1, s2));
    }

    // Time Complexity - O(n)
    // Space Complexity - O(n) -> stack for recursion, O(n) -> dp
    public int mem(int n1, int n2, String s1, String s2, int[][] dp) {
        if(n1<0 || n2<0) return 0;
        if(dp[n1][n2]!=-1) return dp[n1][n2];

        if(s1.charAt(n1)==s2.charAt(n2)) {
            return dp[n1][n2]=1 + mem(n1-1, n2-1, s1, s2, dp);
        }
        return dp[n1][n2]=Math.max(mem(n1-1, n2, s1, s2, dp), mem(n1, n2-1, s1, s2, dp));
    }

    // Time Complexity - O(n)
    // Space Complexity - O(n) -> dp
    public int tab(int n1, int n2, String s1, String s2, int[][] dp) {
        for(int i=0; i<=n1+1; i++) {
            dp[i][0]=0;
        }
        for(int j=0; j<=n2+1; j++) {
            dp[0][j]=0;
        }
        // i-1 -> represent length not index
        for(int i=1; i<=n1+1; i++) {
            for(int j=1; j<=n2+1; j++) {
                if(s1.charAt(i-1)==s2.charAt(j-1)){
                    dp[i][j]=1+dp[i-1][j-1];
                } else {
                    dp[i][j]=Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[n1+1][n2+1];
    }

    public int longestCommonSubsequence(String text1, String text2) {
        int n1=text1.length(), n2=text2.length();
        // n1+1 also for empty string
        int[][] dp = new int[n1+1][n2+1];
        for(int[] row: dp) {
            Arrays.fill(row, -1);
        }
        // return rec(n1-1, n2-1, text1, text2);
        // return mem(n1-1, n2-1, text1, text2, dp);
        return tab(n1-1, n2-1, text1, text2, dp);
    }
}
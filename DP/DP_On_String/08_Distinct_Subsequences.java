// 115. Distinct Subsequences

// Given two strings s and t, return the number of distinct subsequences of s which equals t.
// The test cases are generated so that the answer fits on a 32-bit signed integer.


// Example 1:
// Input: s = "rabbbit", t = "rabbit"
// Output: 3
// Explanation:
// As shown below, there are 3 ways you can generate "rabbit" from s.
// rabbbit
// rabbbit
// rabbbit

// Example 2:
// Input: s = "babgbag", t = "bag"
// Output: 5
// Explanation:
// As shown below, there are 5 ways you can generate "bag" from s.
// babgbag
// babgbag
// babgbag
// babgbag
// babgbag
 

// Constraints:

// 1 <= s.length, t.length <= 1000
// s and t consist of English letters.

// Solution:

import java.util.Arrays;
class Solution {
    public int rec(int i, int j, String s, String t) {
        if(j<0) return 1;
        if(i<0) return 0;
        if(s.charAt(i)==t.charAt(j)) {
            return rec(i-1, j-1, s, t) + rec(i-1, j, s, t);
        } else {
            return rec(i-1, j, s, t);
        }
    }

    public int mem(int i, int j, String s, String t, int[][] dp) {
        if(j<0) return 1;
        if(i<0) return 0;
        if(dp[i][j]!=-1) return dp[i][j];

        if(s.charAt(i)==t.charAt(j)) {
            return dp[i][j]=mem(i-1, j-1, s, t, dp) + mem(i-1, j, s, t, dp);
        } else {
            return dp[i][j]=mem(i-1, j, s, t, dp);
        }
    }

    public int tab(int i, int j, String s, String t, int[][] dp) {
        for(int x=0; x<=i; x++) dp[x][0]=1;
        for(int y=1; y<=j; y++) dp[0][y]=0;

        for(int x=1; x<=i; x++) {
            for(int y=1; y<=j; y++) {
                if(s.charAt(x-1)==t.charAt(y-1)){
                    dp[x][y]=dp[x-1][y-1]+dp[x-1][y];
                } else {
                    dp[x][y]=dp[x-1][y];
                }
            }
        }
        return dp[i][j];
    }

    public int numDistinct(String s, String t) {
        int i = s.length();
        int j = t.length();
        int[][] dp = new int[i+1][j+1];
        for(int[] row: dp) {
            Arrays.fill(row, -1);
        }

        // return rec(i-1, j-1, s, t);
        // return mem(i-1, j-1, s, t, dp);
        return tab(i, j, s, t, dp);
    }
}
// 516. Longest Palindromic Subsequence

// Given a string s, find the longest palindromic subsequence's length in s.
// A subsequence is a sequence that can be derived from another sequence by deleting some or no elements without changing the order of the remaining elements.


// Example 1:
// Input: s = "bbbab"
// Output: 4
// Explanation: One possible longest palindromic subsequence is "bbbb".

// Example 2:
// Input: s = "cbbd"
// Output: 2
// Explanation: One possible longest palindromic subsequence is "bb".
 

// Constraints:

// 1 <= s.length <= 1000
// s consists only of lowercase English letters.

// Solution:

class Solution {
    public int tab(int n1, int n2, String s1, String s2, int[][] dp) {
        for(int i=0; i<=n1; i++) dp[i][0]=0;
        for(int j=0; j<=n2; j++) dp[0][j]=0;
        
        for(int i=1; i<=n1; i++) {
            for(int j=1; j<=n2; j++) {
                if(s1.charAt(i-1)==s2.charAt(j-1)) {
                    dp[i][j]=1+dp[i-1][j-1];
                } else {
                    dp[i][j]=Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[n1][n2];
    }
    public int longestPalindromeSubseq(String s) {
        String s1 = s;
        String s2 = new StringBuilder(s).reverse().toString();
        int n1=s1.length(), n2=s2.length();
        int[][] dp = new int[n1+1][n2+1];
        return tab(n1, n2, s1, s2, dp);
    }
}
// 44. Wildcard Matching

// Given an input string (s) and a pattern (p), implement wildcard pattern matching with support for '?' and '*' where:
// '?' Matches any single character.
// '*' Matches any sequence of characters (including the empty sequence).
// The matching should cover the entire input string (not partial).

 
// Example 1:
// Input: s = "aa", p = "a"
// Output: false
// Explanation: "a" does not match the entire string "aa".

// Example 2:
// Input: s = "aa", p = "*"
// Output: true
// Explanation: '*' matches any sequence.

// Example 3:
// Input: s = "cb", p = "?a"
// Output: false
// Explanation: '?' matches 'c', but the second letter is 'a', which does not match 'b'.

// Example 4:
// Input: s = "zacabz", p = "*a?b*"
// Output: false

// Example 5:
// Input: s = "mississippi", p = "m??*ss*?i*pi"
// Output: false


// Constraints:

// 0 <= s.length, p.length <= 2000
// s contains only lowercase English letters.
// p contains only lowercase English letters, '?' or '*'.

// Solution:

class Solution {
    public boolean rec(int n1, int n2, String s1, String s2) {
        if(n1<0 && n2<0) return true;
        if(n2<0 && n1>=0) return false;
        if(n1<0 && n2>=0) {
            for(int i=0; i<=n2; i++) {
                if(s2.charAt(i)!='*') return false;
            }
            return true;
        }
        
        if(s1.charAt(n1)==s2.charAt(n2) || s2.charAt(n2)=='?') {
            return rec(n1-1, n2-1, s1, s2);
        } else {
            if(s2.charAt(n2)=='*') {
                return rec(n1-1, n2, s1, s2) || rec(n1, n2-1, s1, s2);
            } else {
                return false;
            }
        }
    }

    public boolean mem(int n1, int n2, String s1, String s2, Boolean[][] dp) {
        if(n1<0 && n2<0) return true;
        if(n1<0 && n2>=0) {
            for(int i=0; i<=n2; i++) {
                if(s2.charAt(i)!='*') return false;
            }
            return true;
        }
        if(n2<0 && n1>=0) return false;
        if(dp[n1][n2]!=null) return dp[n1][n2];

        if(s1.charAt(n1)==s2.charAt(n2) || s2.charAt(n2)=='?') {
            return dp[n1][n2]=mem(n1-1, n2-1, s1, s2, dp);
        } else {
            if(s2.charAt(n2)=='*') {
                return dp[n1][n2]=mem(n1-1, n2, s1, s2, dp) || mem(n1, n2-1, s1, s2, dp);
            } else {
                return false;
            }
        }
    }

    public boolean tab(int n1, int n2, String s1, String s2, boolean[][] dp) {
        
        // base 1:
        dp[0][0]=true;

        // base 2:
        for(int i=1; i<=n1; i++) dp[i][0]=false;
        
        // base :3
        for(int j=1; j<=n2; j++) {
            if(s2.charAt(j-1)=='*') dp[0][j]=dp[0][j-1];
            else dp[0][j]=false;
        }

        for(int i=1; i<=n1; i++) {
            for(int j=1; j<=n2; j++) {
                if(s1.charAt(i-1)==s2.charAt(j-1) || s2.charAt(j-1)=='?') {
                    dp[i][j]=dp[i-1][j-1];
                } else {
                    if(s2.charAt(j-1)=='*') {
                        dp[i][j]=dp[i-1][j] || dp[i][j-1];
                    } else {
                        dp[i][j] = false;
                    }
                }
            }
        }
        return dp[n1][n2];
    }
    public boolean isMatch(String s, String p) {
        int n1 = s.length();
        int n2 = p.length();
        // Boolean[][] memDp = new Boolean[n1+1][n2+1];
        boolean[][] tabDp = new boolean[n1+1][n2+1];

        // return rec(n1-1, n2-1, s, p);
        // return mem(n1-1, n2-1, s, p, memDp);
        return tab(n1, n2, s, p, tabDp);
    }
}
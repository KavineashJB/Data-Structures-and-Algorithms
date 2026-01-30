// 72. Edit Distance

// Given two strings word1 and word2, return the minimum number of operations required to convert word1 to word2.
// You have the following three operations permitted on a word:

// Insert a character
// Delete a character
// Replace a character
 

// Example 1:
// Input: word1 = "horse", word2 = "ros"
// Output: 3
// Explanation: 
// horse -> rorse (replace 'h' with 'r')
// rorse -> rose (remove 'r')
// rose -> ros (remove 'e')

// Example 2:
// Input: word1 = "intention", word2 = "execution"
// Output: 5
// Explanation: 
// intention -> inention (remove 't')
// inention -> enention (replace 'i' with 'e')
// enention -> exention (replace 'n' with 'x')
// exention -> exection (replace 'n' with 'c')
// exection -> execution (insert 'u')
 

// Constraints:

// 0 <= word1.length, word2.length <= 500
// word1 and word2 consist of lowercase English letters.

// Solution:

import java.util.Arrays;
class Solution {
    public int rec(int i, int j, String s1, String s2) {
        if(i<0) return j+1; // only one possible is operation insertion
        if(j<0) return i+1; // only one possible is operation deletion
        if(s1.charAt(i)==s2.charAt(j)){
            return rec(i-1, j-1, s1, s2);
        } else {
            //                  Insert                          Delete                  Replace
            return Math.min(1+rec(i, j-1, s1, s2), Math.min(1+rec(i-1, j, s1, s2), 1+rec(i-1, j-1, s1, s2)));
        }
    }

    public int mem(int i, int j, String s1, String s2, int[][] dp) {
        if(i<0) return j+1;
        if(j<0) return i+1;
        if(dp[i][j]!=-1) return dp[i][j];
        if(s1.charAt(i)==s2.charAt(j)){
            return dp[i][j]= mem(i-1, j-1, s1, s2, dp);
        } else {
            //                  Insert                          Delete                  Replace
            return dp[i][j]= Math.min(1+mem(i, j-1, s1, s2, dp), Math.min(1+mem(i-1, j, s1, s2, dp), 1+mem(i-1, j-1, s1, s2, dp)));
        }
    }

    public int tab(int i, int j, String s1, String s2, int[][] dp) {
        for(int x=0; x<=i; x++) dp[x][0]=x;
        for(int y=0; y<=j; y++) dp[0][y]=y;

        for(int x=1; x<=i; x++) {
            for(int y=1; y<=j; y++) {
                if(s1.charAt(x-1)==s2.charAt(y-1)){
                    dp[x][y]= dp[x-1][y-1];
                } else {
                    //                      Insert                Delete         Replace
                    dp[x][y]= Math.min(1+dp[x][y-1], Math.min(1+dp[x-1][y], 1+dp[x-1][y-1]));
                }
            }
        }
        return dp[i][j];
    }

    public int minDistance(String word1, String word2) {
        int i=word1.length();
        int j=word2.length();
        int[][] dp = new int[i+1][j+1];
        for(int[] row: dp) {
            Arrays.fill(row, -1);
        }
        // return rec(i-1, j-1, word1, word2);
        // return mem(i-1, j-1, word1, word2, dp);
        return tab(i, j, word1, word2, dp);
    }
}
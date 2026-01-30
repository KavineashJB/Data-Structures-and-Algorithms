// 1312. Minimum Insertion Steps to Make a String Palindrome

// Given a string s. In one step you can insert any character at any index of the string.
// Return the minimum number of steps to make s palindrome.
// A Palindrome String is one that reads the same backward as well as forward.


// Example 1:
// Input: s = "zzazz"
// Output: 0
// Explanation: The string "zzazz" is already palindrome we do not need any insertions.

// Example 2:
// Input: s = "mbadm"
// Output: 2
// Explanation: String can be "mbdadbm" or "mdbabdm".

// Example 3:
// Input: s = "leetcode"
// Output: 5
// Explanation: Inserting 5 characters the string becomes "leetcodocteel".
 

// Constraints:
// 1 <= s.length <= 500
// s consists of lowercase English letters.

// Solution:

class Solution {
    public int minInsertions(String s) {
        String s1 = s;
        String s2 = new StringBuilder(s).reverse().toString();
        int n1 = s1.length();
        int n2 = s2.length();
        int[][] dp = new int[n1+1][n2+1];
        
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

        return s1.length()-dp[n1][n2];
    }
}
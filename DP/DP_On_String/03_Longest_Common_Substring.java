// Longest Common Substring
// You are given two strings s1 and s2. Your task is to find the length of the longest common substring among the given strings.

// Examples:

// Input: s1 = "ABCDGH", s2 = "ACDGHR"
// Output: 4
// Explanation: The longest common substring is "CDGH" with a length of 4.

// Input: s1 = "abc", s2 = "acb"
// Output: 1
// Explanation: The longest common substrings are "a", "b", "c" all having length 1.

// Input: s1 = "YZ", s2 = "yz"
// Output: 0

// Constraints:
// 1 <= s1.size(), s2.size() <= 103
// Both strings may contain upper and lower case alphabets.

// Solution:

class Solution {
    // Tabulation method
    // recursion needs extra 1 bool parameter to track previous char matched or not
    public int longCommSubstr(String s1, String s2) {
        int n1=s1.length(), n2=s2.length();
        int[][] dp=new int[n1+1][n2+1];
        
        for(int i=0; i<=n1; i++){
            dp[i][0]=0;
        }
        for(int j=0; j<=n2; j++){
            dp[0][j]=0;
        }
        int maxi=0;
        for(int i=1; i<=n1; i++) {
            for(int j=1; j<=n2; j++) {
                if(s1.charAt(i-1)==s2.charAt(j-1)) {
                    dp[i][j]=1+dp[i-1][j-1];
                    maxi=Math.max(maxi, dp[i][j]);
                }
            }
        }
        return maxi;
    }
}
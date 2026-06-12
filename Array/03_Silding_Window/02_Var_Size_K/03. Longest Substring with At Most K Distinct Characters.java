// Longest Substring with At Most K Distinct Characters

// You are given a string 'str' and an integer ‘K’. Your task is to find the length of the largest substring with at most ‘K’ distinct characters.

// For example:
// You are given ‘str’ = ‘abbbbbbc’ and ‘K’ = 2, then the substrings that can be formed are [‘abbbbbb’, ‘bbbbbbc’]. Hence the answer is 7.
// Detailed explanation ( Input/output format, Notes, Images )
// Constraints:
// 1 <= T <= 10
// 1 <= K <= 26
// 1 <= |str| <= 10^6

// The string str will contain only lowercase alphabets.    

// Time Limit: 1 sec
// Note:
// You do not need to print anything. It has already been taken care of. Just implement the function.
// Sample Input 1:
// 2
// 2
// abbbbbbc
// 3
// abcddefg
// Sample Output 1:
// 7
// 4
// Explanation:
// For the first test case, ‘str’ = ‘abbbbbbc’ and ‘K’ = 2, then the substrings that can be formed are [‘abbbbbb’, ‘bbbbbbc’]. Hence the answer is 7.

// For the second test case, ‘str’ = ‘abcddefg’ and ‘K’ = 3, then the substrings that can be formed is [‘cdde’, ‘ddef’]. Hence the answer is 4.
// Sample Input 2:
// 2
// 3
// aaaaaaaa
// 1
// abcefg
// Sample Output 2:
// 8   
// 1   

// Hints:
// 1. Try to think of a brute force approach.
// 2. Try to think of a two-pointer solution.

// Problem Link: https://www.naukri.com/code360/problems/distinct-characters_2221410?leftPanelTabValue=PROBLEM

import java.util.*;

class Solution {

    public static int kDistinctChars(int k, String s) {
        int left = 0, maxi = 0, n = s.length();
        Map<Character, Integer> map = new HashMap<>();

        for (int right = 0; right < n; right++) {
            char rch = s.charAt(right);
            map.put(rch, map.getOrDefault(rch, 0) + 1);

            while (map.size() > k) {
                char lch = s.charAt(left);

                map.put(lch, map.get(lch) - 1);

                if (map.get(lch) == 0) {
                    map.remove(lch);
                }
                left++;
            }

            maxi = Math.max(maxi, right - left + 1);

            // The only diff is if()
            // if (map.size() == k) {
            // maxLen = Math.max(maxLen, right - left + 1);
            // }
        }
        return maxi;
    }

}

// Longest Substring with K Uniques

// You are given a string s consisting only lowercase alphabets and an integer k. Your task is to find the length of the longest substring that contains exactly k distinct characters.

// Note : If no such substring exists, return -1. 

// Examples:

// Input: s = "aabacbebebe", k = 3
// Output: 7
// Explanation: The longest substring with exactly 3 distinct characters is "cbebebe", which includes 'c', 'b', and 'e'.
// Input: s = "aaaa", k = 2
// Output: -1
// Explanation: There's no substring with 2 distinct characters.
// Input: s = "aabaaab", k = 2
// Output: 7
// Explanation: The entire string "aabaaab" has exactly 2 unique characters 'a' and 'b', making it the longest valid substring.
// Constraints:
// 1 ≤ s.size() ≤ 105
// 1 ≤ k ≤ 26

// Expected Complexities
// Time Complexity: O(n)
// Auxiliary Space: O(1)

// Problem Link: https://www.geeksforgeeks.org/problems/longest-k-unique-characters-substring0853/1
class Solution {
    public int longestKSubstr(String s, int k) {
        int left = 0, maxLen = -1;
        Map<Character, Integer> map = new HashMap<>();

        for (int right = 0; right < s.length(); right++) {

            // Expand window
            char rChar = s.charAt(right);
            map.put(rChar, map.getOrDefault(rChar, 0) + 1);

            // Shrink window if distinct chars > k
            while (map.size() > k) {
                char lChar = s.charAt(left);

                map.put(lChar, map.get(lChar) - 1);

                if (map.get(lChar) == 0) {
                    map.remove(lChar);
                }

                left++;
            }

            // Fixed valid window: exactly k unique chars
            if (map.size() == k) {
                maxLen = Math.max(maxLen, right - left + 1);
            }
        }

        return maxLen;
    }
}
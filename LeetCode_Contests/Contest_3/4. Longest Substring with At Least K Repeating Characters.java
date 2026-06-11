package Contest_3;

// 395. Longest Substring with At Least K Repeating Characters

// Given a string s and an integer k, return the length of the longest substring of s such that the frequency of each character in this substring is greater than or equal to k.

// if no such substring exists, return 0.


// Example 1:

// Input: s = "aaabb", k = 3
// Output: 3
// Explanation: The longest substring is "aaa", as 'a' is repeated 3 times.
// Example 2:

// Input: s = "ababbc", k = 2
// Output: 5
// Explanation: The longest substring is "ababb", as 'a' is repeated 2 times and 'b' is repeated 3 times.
 

// Constraints:
// 1 <= s.length <= 104
// s consists of only lowercase English letters.
// 1 <= k <= 105


// Problem Link: https://leetcode.com/problems/longest-substring-with-at-least-k-repeating-characters/
import java.util.*;
class Solution {
    public int longsubstr(String s, int k) {
        if(s.length()<k) return 0;

        Map<Character, Integer> map = new HashMap<>();

        for(char ch: s.toCharArray()){
            map.put(ch, map.getOrDefault(ch, 0)+1);
        }

        for(int i=0;i<s.length();i++){
            if(map.get(s.charAt(i))<k){
                return Math.max(longsubstr(s.substring(0,i),k), longsubstr(s.substring(i+1, s.length()),k));
            }
        }

        return s.length();
    }
    private int help(String s, int start, int end, int k) {
        if (end - start < k) return 0;
        int[] f = new int[26];
        for (int i = start; i < end; i++) {
            f[s.charAt(i) - 'a']++;
        }
        for (int mid = start; mid < end; mid++) {
            if (f[s.charAt(mid) - 'a'] < k) {
                int midnxt = mid + 1;
                while (midnxt < end &&
                       f[s.charAt(midnxt) - 'a'] < k) {
                    midnxt++;
                }
                return Math.max(
                    help(s, start, mid, k),
                    help(s, midnxt, end, k)
                );
            }
        }
        return end - start;
    }
    public int longestSubstring(String s, int k) {

        // pakka BF
        Map<Character, Integer> map=new HashMap<>();
        int maxLen=0;
        for(int i=0;i<s.length()-k;i++){
            for(int j=i;j<s.length();j++){
                map.put(s.charAt(j), map.getOrDefault(s.charAt(j), 0)+1);
                boolean allValid=true;
                for(int val: map.values()){
                    if(val<k) {
                        allValid=false;
                        break;
                    }
                }
                if(allValid) maxLen=Math.max(maxLen, j-i+1);
            }
            map=new HashMap<>();
        }
        // return maxLen;
        // return longsubstr(s,k);
        return help(s, 0, s.length(), k);
    }
}
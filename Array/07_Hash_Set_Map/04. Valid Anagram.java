// 242. Valid Anagram

// Given two strings s and t, return true if t is an anagram of s, and false otherwise.


// Example 1:
// Input: s = "anagram", t = "nagaram"
// Output: true

// Example 2:
// Input: s = "rat", t = "car"
// Output: false

// Constraints:
// 1 <= s.length, t.length <= 5 * 104
// s and t consist of lowercase English letters.


// Problem Link: https://leetcode.com/problems/valid-anagram/
import java.util.*;
class Solution {
    private int[] freq=new int[26];
    
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;

        for(int i=0; i<s.length();i++){
            freq[s.charAt(i)-'a']++;
            freq[t.charAt(i)-'a']--;
        }
        for(int i:freq) if(i!=0) return false;
        // return true;

        // if the inputs contains upper, lower, or any ASCII characters
        Map<Character, Integer> map=new HashMap<>();

        for(int i=0; i<s.length();i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i),0)+1);
            map.put(t.charAt(i), map.getOrDefault(t.charAt(i),0)-1);
        }

        for(Map.Entry<Character, Integer> e:map.entrySet()) if(e.getValue()!=0) return false;
        return true;
    }
}
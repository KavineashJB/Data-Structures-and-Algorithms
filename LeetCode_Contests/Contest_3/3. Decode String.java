package Contest_3;

// Given an encoded string, return its decoded string.

// The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times. Note that k is guaranteed to be a positive integer.

// You may assume that the input string is always valid; there are no extra white spaces, square brackets are well-formed, etc. Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers, k. For example, there will not be input like 3a or 2[4].

// The test cases are generated so that the length of the output will never exceed 105.

 

// Example 1:

// Input: s = "3[a]2[bc]"
// Output: "aaabcbc"
// Example 2:

// Input: s = "3[a2[c]]"
// Output: "accaccacc"
// Example 3:

// Input: s = "2[abc]3[cd]ef"
// Output: "abcabccdcdcdef"
 

// Constraints:

// 1 <= s.length <= 30
// s consists of lowercase English letters, digits, and square brackets '[]'.
// s is guaranteed to be a valid input.
// All the integers in s are in the range [1, 300].


// Problem Link: https://leetcode.com/problems/decode-string/
import java.util.*;
class Solution {
    public String decodeString(String s) {
        Stack<Integer> countst = new Stack<>();
        Stack<StringBuilder> strst = new Stack<>();
        int currnum=0;
        StringBuilder currstr=new StringBuilder();

        for(char ch: s.toCharArray()){
            if(ch=='['){
                // push currnum & currstr to stack
                countst.push(currnum);
                strst.push(currstr);
                currnum=0;
                currstr=new StringBuilder();
            } else if(ch==']'){
                // pop
                int cnt=countst.pop();
                StringBuilder str= strst.pop();

                while(cnt--!=0){
                    str.append(currstr);
                }
                
                currstr=str;
                
            } else if(ch>='a' && ch<='z'){
                currstr.append(ch);
            } else {
                currnum=(currnum*10)+(ch-'0');
            }
        }
        return currstr.toString();
    }
}
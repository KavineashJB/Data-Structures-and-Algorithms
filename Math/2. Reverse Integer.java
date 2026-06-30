// 7. Reverse Integer

// Given a signed 32-bit integer x, return x with its digits reversed. If
// reversing x causes the value to go outside the signed 32-bit integer range
// [-231, 231 - 1], then return 0.

// Assume the environment does not allow you to store 64-bit integers (signed or
// unsigned).

// Example 1:
// Input: x = 123
// Output: 321

// Example 2:
// Input: x = -123
// Output: -321

// Example 3:
// Input: x = 120
// Output: 21

// Constraints:
// -231 <= x <= 231 - 1

//  Problem Link: https://leetcode.com/problems/reverse-integer/
class Solution {
    public int reverse(int x) {
        int num=0;
        while(x!=0){
            int digit=x%10;
            // if overflow-return 0;
            // num*10 be overflow, so minval/10 also incl of minval also return 0.
            // last minval dig -8 and maxval dig 7
            if(num>Integer.MAX_VALUE/10 || num==Integer.MAX_VALUE && digit==7) return 0;
            if(num<Integer.MIN_VALUE/10 || num==Integer.MIN_VALUE && digit==-8) return 0;
            num=(num*10)+digit;
            x/=10;
        }
        return num;
    }
}
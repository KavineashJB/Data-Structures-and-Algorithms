// GCD of two numbers

// Given two positive integers a and b, find GCD of a and b.

// Note: Don't use the inbuilt gcd function

// Examples:
// Input: a = 20, b = 28
// Output: 4
// Explanation: GCD of 20 and 28 is 4
// Input: a = 60, b = 36
// Output: 12
// Explanation: GCD of 60 and 36 is 12

// Constraints:
// 1 ≤ a, b ≤ 109

// Expected Complexities
// Time Complexity: O(log(min(a, b)))
// Auxiliary Space: O(1)


// Problem Link: https://www.geeksforgeeks.org/problems/gcd-of-two-numbers3459/1class Solution {
class Solution {
    public static int gcd(int a, int b) {
        if(b==0) return a;
        return gcd(b, Math.abs(a%b));
    }
}
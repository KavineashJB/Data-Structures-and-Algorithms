// Count Digits in a Number

// Given a number n, return the count of digits in this number.

// Examples :

// Input: n = 1567
// Output: 4
// Explanation: There are 4 digits in 1567, which are 1, 5, 6 and 7.

// Input: n = 99999
// Output: 5
// Explanation: Number of digit in 99999 is 5

// Constraints:
// 1 ≤ n ≤ 109

// Expected Complexities
// Time Complexity: O(log n)
// Auxiliary Space: O(log n)

// Problem Link: https://www.geeksforgeeks.org/problems/count-total-digits-in-a-number/1
// import java.lang.Math.*;

class Solution {
    public static int countDigits(int n) {
        // if n==Integer.MIN_VALUE then it's abs become overflow
        return ((int) Math.log10(Math.abs((long) n))) + 1;
    }
}

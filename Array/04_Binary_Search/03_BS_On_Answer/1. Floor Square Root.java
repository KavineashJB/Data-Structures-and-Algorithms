// Square Root

// Given a positive integer n, find the square root of n. If n is not a perfect square, then return the floor value.

// Floor value of any number is the greatest Integer which is less than or equal to that number.

// Examples:

// Input: n = 4
// Output: 2
// Explanation: Since, 4 is a perfect square, so its square root is 2.

// Input: n = 11
// Output: 3
// Explanation: Since, 11 is not a perfect square, floor of square root of 11 is 3.

// Input: n = 1
// Output: 1
// Explanation: 1 is a perfect sqaure, so its square root is 1.

// Constraints:
// 1 ≤ n ≤ 3*104

// Expected Complexities
// Time Complexity: O(log n)
// Auxiliary Space: O(1)

// Problem Link: https://www.geeksforgeeks.org/problems/square-root/1
class Solution {
    int floorSqrt(int n) {
        int l=1, h=n;
        
        while(l<=h){
            int mid=l+(h-l)/2;
            if(mid*mid<=n) l=mid+1;
            else h=mid-1;
        }
        return h;
    }
}
// Swap The Numbers

// Given two numbers a and b, you need to swap their values so a holds the value of b and b holds the value of a. Just write the code to swap values of a and b at the specified place.

// Examples :
// Input: a = 1 b = 2
// Output: 2 1
// Explanation: Initially a = 1 and b = 2, now a = 2 and b = 1.

// Input: a = 6 b = 7  
// Output: 7 6 
// Explanation: Initially a = 6 and b = 7, now a = 7 and b = 6.

// Expected Complexities
// Time Complexity: O(1)
// Auxiliary Space: O(1)

// Solution:
class Solution {
    public void swap(int a, int b) {
        // 1. Using Bit manipulation
        a=a^b;
        b=a^b;
        a=a^b;
        System.out.println(a+" "+b);
        
        // 2. General method
        a = a+b;
        b=a-b;
        a=a-b;
        // System.out.println(a+" "+b);
    }
}

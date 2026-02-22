// Swap two numbers
// You are given two numbers a and b. Your task is to swap the given two numbers.
// Note: Try to do it without a temporary variable.

// Examples:
// Input: a = 13, b = 9
// Output: 9 13
// Explanation: After swapping it becomes 9 and 13.

// Input: a = 15, b = 8
// Output: 8 15
// Explanation: after swapping it becomes 8 and 15.


// Constraints:
// 1 ≤ a, b ≤ 106

import java.util.List;
class Solution {
    static List<Integer> get(int a, int b) {
        
        // method 1 - with temporary Variable
        int temp = a;
        a = b;
        b = temp;
        
        // method 2 - Arithmetic but int overflow possible
        a = a + b;
        b = a - b;
        a = a - b;
        
        // method 3 - Bitwise but possible to 0
        a = a^b;
        b = a^b;
        a = a^b;
        return List.of(a,b);
    }
}
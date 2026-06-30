// Prime Number

// Given a number n, determine whether it is a prime number or not.
// Note: A prime number is a number greater than 1 that has no positive divisors other than 1 and itself.

// Examples :
// Input: n = 7
// Output: true
// Explanation: 7 has exactly two divisors: 1 and 7, making it a prime number.
// Input: n = 25
// Output: false
// Explanation: 25 has more than two divisors: 1, 5, and 25, so it is not a prime number.
// Input: n = 1
// Output: false
// Explanation: 1 has only one divisor (1 itself), which is not sufficient for it to be considered prime.

// Constraints:
// 1 ≤ n ≤ 109

// Expected Complexities
// Time Complexity: O(sqrt(n))
// Auxiliary Space: O(1)


// Problem Link: https://www.geeksforgeeks.org/problems/prime-number2314/1
class Solution {
    static boolean isPrime(int n) {
        if(n==1) return false;
        for(int i=2;i<=n/i;i++){
            if(n%i==0) return false;
        }
        return true;
    }
}
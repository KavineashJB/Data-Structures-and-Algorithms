package Contest_4;

// 397. Integer Replacement

// Given a positive integer n, you can apply one of the following operations:

// If n is even, replace n with n / 2.
// If n is odd, replace n with either n + 1 or n - 1.
// Return the minimum number of operations needed for n to become 1.

// Example 1:

// Input: n = 8
// Output: 3
// Explanation: 8 -> 4 -> 2 -> 1

// Example 2:
// Input: n = 7
// Output: 4
// Explanation: 7 -> 8 -> 4 -> 2 -> 1
// or 7 -> 6 -> 3 -> 2 -> 1

// Example 3:
// Input: n = 4
// Output: 2

// Constraints:
// 1 <= n <= 2^31 - 1

// Problem Link: https://leetcode.com/problems/integer-replacement/
class Solution {
    public long rec(long n) {
        if (n == 1)
            return 0;

        if ((n & 1) == 0) {
            return 1 + rec(n >> 1);
        } else {
            long lessOne = rec(n - 1);
            long addOne = rec(n + 1);
            return 1 + Math.min(lessOne, addOne);
        }
    }

    public int integerReplacement(int n) {
        // my approach

        // return (int) rec((long) n);

        // optimal by dry run example and comparing it

        // our ultimate aim is to make the odd nums as the nearest power of 2 so that i
        // can easily be divide until 1 right?? otherwise even if it's even it may be
        // still possible to stuck again and again by odd nums.
        int c = 0;
        long num = n;
        while (num > 1) {
            if ((num & 1) == 0) {
                num >>= 1;
            } else {
                // make last 2 bits as 00
                // if last 2nd bit is 0 which is ...01 then -1 to make 00.
                if (num == 3 || (num & 2) == 0)
                    num--;
                // if last 2nd bit is 0 which is ...11 then +1 to make it 00.
                else
                    num++;
            }
            c++;
        }
        return c;
    }
}
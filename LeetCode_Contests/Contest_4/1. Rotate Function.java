package Contest_4;

// 396. Rotate Function

// You are given an integer array nums of length n.

// Assume arrk to be an array obtained by rotating nums by k positions
// clock-wise. We define the rotation function F on nums as follow:
// F(k) = 0 * arrk[0] + 1 * arrk[1] + ... + (n - 1) * arrk[n - 1].
// Return the maximum value of F(0), F(1), ..., F(n-1).

// The test cases are generated so that the answer fits in a 32-bit integer.

// Example 1:
// Input: nums = [4,3,2,6]
// Output: 26
// Explanation:
// F(0) = (0 * 4) + (1 * 3) + (2 * 2) + (3 * 6) = 0 + 3 + 4 + 18 = 25
// F(1) = (0 * 6) + (1 * 4) + (2 * 3) + (3 * 2) = 0 + 4 + 6 + 6 = 16
// F(2) = (0 * 2) + (1 * 6) + (2 * 4) + (3 * 3) = 0 + 6 + 8 + 9 = 23
// F(3) = (0 * 3) + (1 * 2) + (2 * 6) + (3 * 4) = 0 + 2 + 12 + 12 = 26
// So the maximum value of F(0), F(1), F(2), F(3) is F(3) = 26.

// Example 2:
// Input: nums = [100]
// Output: 0

// Constraints:
// n == nums.length
// 1 <= n <= 105
// -100 <= nums[i] <= 100

// Problem Link: https://leetcode.com/problems/rotate-function/
class Solution {
    public int maxRotateFunction(int[] nums) {

        // pakka BF
        int maxSum = Integer.MIN_VALUE;
        int sum = 0, n = nums.length;
        for (int i = 0; i < n; i++) {
            int s = 0;
            for (int j = 0; j < n; j++) {
                s += (nums[j] * ((j + i) % n));
            }
            maxSum = Math.max(maxSum, s);
        }
        // return maxSum;

        // for the first time i'm without using Gemini AI,
        // I solved this in optimal Approach: Math Calc
        maxSum = Integer.MIN_VALUE;
        sum = 0;
        n = nums.length;
        int totSum = 0;

        for (int i = 0; i < n; i++) {
            if (i != 0)
                sum += i * nums[i];
            totSum += nums[i];
        }

        maxSum = Math.max(maxSum, sum);

        for (int i = n - 1; i >= 0; i--) {
            sum += totSum - (n * nums[i]);
            maxSum = Math.max(maxSum, sum);
        }
        return maxSum;
    }
}
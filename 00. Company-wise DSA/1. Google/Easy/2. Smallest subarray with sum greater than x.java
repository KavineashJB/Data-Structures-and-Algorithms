// Smallest subarray with sum greater than x
// Difficulty: EasyAccuracy: 37.07%Submissions: 164K+Points: 2Average Time: 20m
// Given a number x and an array of integers arr, find the smallest subarray with sum strictly greater than the given value. If such a subarray do not exist return 0 in that case.

// Examples:

// Input: x = 51, arr[] = [1, 4, 45, 6, 0, 19]
// Output: 3
// Explanation: Minimum length subarray is [4, 45, 6]
// Input: x = 100, arr[] = [1, 10, 5, 2, 7]
// Output: 0
// Explanation: No subarray exist
// Constraints:
// 1 ≤ arr.size, x ≤ 105
// 0 ≤ arr[] ≤ 104

// Expected Complexities
// Time Complexity: O(n)
// Auxiliary Space: O(1)

// Problem Link: https://www.geeksforgeeks.org/problems/smallest-subarray-with-sum-greater-than-x5651/1
class Solution {
    public static int smallestSubWithSum(int x, int[] arr) {
        int n = arr.length, minLen = (int) 1e6;
        int left = 0, currSum = 0;

        for (int right = 0; right < n; right++) {
            currSum += arr[right];

            while (currSum > x) {
                minLen = Math.min(minLen, right - left + 1);
                currSum -= arr[left];
                left++;
            }

        }

        return minLen == (int) 1e6 ? 0 : minLen;
    }
}

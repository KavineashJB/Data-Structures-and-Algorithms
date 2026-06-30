// Allocate Minimum Pages

// Given an array arr[] of integers, where each element arr[i] represents the number of pages in the i-th book. You also have an integer k representing the number of students. The task is to allocate books to each student such that:

// Each student receives atleast one book.
// Each student is assigned a contiguous sequence of books.
// No book is assigned to more than one student.
// All books must be allocated.
// The objective is to minimize the maximum number of pages assigned to any student. In other words, out of all possible allocations, find the arrangement where the student who receives the most pages still has the smallest possible maximum.

// Note: If it is not possible to allocate books to all students, return -1.

// Examples:

// Input: arr[] = [12, 34, 67, 90], k = 2
// Output: 113
// Explanation: Allocation can be done in following ways:
// => [12] and [34, 67, 90] Maximum Pages = 191
// => [12, 34] and [67, 90] Maximum Pages = 157
// => [12, 34, 67] and [90] Maximum Pages = 113.
// The third combination has the minimum pages assigned to a student which is 113.

// Input: arr[] = [15, 17, 20], k = 5
// Output: -1
// Explanation: Since there are more students than total books, it's impossible to allocate a book to each student.

// Constraints:
// 1 ≤ arr.size() ≤ 106
// 1 ≤ arr[i], k ≤ 103

// Expected Complexities
// Time Complexity: O( n × log(sum(arr)))
// Auxiliary Space: O(1)

// Problem Link: https://www.geeksforgeeks.org/problems/allocate-minimum-number-of-pages0937/1

// ======================================================================================================
// ======================================================================================================
// ======================================================================================================
// ======================================================================================================

// 410. Split Array Largest Sum

// Given an integer array nums and an integer k, split nums into k non-empty subarrays such that the largest sum of any subarray is minimized.
// Return the minimized largest sum of the split.
// A subarray is a contiguous part of the array.

// Example 1:
// Input: nums = [7,2,5,10,8], k = 2
// Output: 18
// Explanation: There are four ways to split nums into two subarrays.
// The best way is to split it into [7,2,5] and [10,8], where the largest sum among the two subarrays is only 18.

// Example 2:
// Input: nums = [1,2,3,4,5], k = 2
// Output: 9
// Explanation: There are four ways to split nums into two subarrays.
// The best way is to split it into [1,2,3] and [4,5], where the largest sum among the two subarrays is only 9.

// Constraints:
// 1 <= nums.length <= 1000
// 0 <= nums[i] <= 106
// 1 <= k <= min(50, nums.length)

// Problem Link: https://leetcode.com/problems/split-array-largest-sum/

// ======================================================================================================
// ======================================================================================================
// ======================================================================================================
// ======================================================================================================

// The Painter's Partition Problem-II

// Given an array arr[] where each element denotes the length of a board, and an integer k representing the number of painters available. Each painter takes 1 unit of time to paint 1 unit length of a board.
// Determine the minimum amount of time required to paint all the boards, under the constraint that each painter can paint only a contiguous sequence of boards (no skipping or splitting allowed).

// Examples:
// Input: arr[] = [5, 10, 30, 20, 15], k = 3
// Output: 35
// Explanation: The optimal allocation of boards among 3 painters is - 
// Painter 1 → [5, 10] → time = 15
// Painter 2 → [30] → time = 30
// Painter 3 → [20, 15] → time = 35
// Job will be done when all painters finish i.e. at time = max(15, 30, 35) = 35

// Input: arr[] = [10, 20, 30, 40], k = 2
// Output: 60
// Explanation: A valid optimal partition is - 
// Painter 1 → [10, 20, 30] → time = 60
// Painter 2 → [40] → time = 40
// Job will be complete at time = max(60, 40) = 60

// Input: arr[] = [100, 200, 300, 400], k = 1
// Output: 1000
// Explanation: There is only one painter, so the painter must paint all boards sequentially. The total time taken will be the sum of all board lengths, i.e., 100 + 200 + 300 + 400 = 1000.

// Constraints:
// 1 ≤ arr.size() ≤ 105
// 1 ≤ arr[i] ≤ 104
// 1 ≤ k ≤ 105

// Expected Complexities
// Time Complexity: O(n * log(sum(arr)))
// Auxiliary Space: O(1)

// Problem Link: https://www.geeksforgeeks.org/problems/the-painters-partition-problem1535/1
class Solution {

    public boolean cntBook(int mid, int[] arr, int k) {
        // tot=1 => very imp
        int tot = 1, curr = 0;
        for (int i = 0; i < arr.length; i++) {
            if (curr + arr[i] <= mid) {
                curr += arr[i];
            } else {
                tot++;
                curr = arr[i];
                if (tot > k)
                    return false;
            }
        }
        return true;
    }

    public int findPages(int[] arr, int k) {
        int n = arr.length;

        if (n < k)
            return -1;

        int l = arr[0], h = 0;
        for (int num : arr) {
            l = Math.max(l, num);
            h += num;
        }

        int res = -1;
        while (l <= h) {
            int mid = l + (h - l) / 2;
            boolean poss = cntBook(mid, arr, k);
            if (poss) {
                res = mid;
                h = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return res;
    }
}
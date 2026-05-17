// 34. Find First and Last Position of Element in Sorted Array

// Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given target value.

// If target is not found in the array, return [-1, -1].

// You must write an algorithm with O(log n) runtime complexity.

// Example 1:

// Input: nums = [5,7,7,8,8,10], target = 8
// Output: [3,4]
// Example 2:

// Input: nums = [5,7,7,8,8,10], target = 6
// Output: [-1,-1]
// Example 3:

// Input: nums = [], target = 0
// Output: [-1,-1]

// Constraints:

// 0 <= nums.length <= 105
// -109 <= nums[i] <= 109
// nums is a non-decreasing array.
// -109 <= target <= 109

// Problem Link: https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/

// if u r using lower and upper bound separate for each problem this is the structure for lower and upper bound
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int start = lowerBound(nums, target);
        if (start == nums.length || nums[start] != target) {
            return new int[] { -1, -1 };
        }
        return new int[] { start, upperBound(nums, target) - 1 };
    }

    private int lowerBound(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] >= target)
                high = mid - 1;
            else
                low = mid + 1;
        }
        return low;
    }

    private int upperBound(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] > target)
                high = mid - 1;
            else
                low = mid + 1;
        }
        return low;
    }
}

// if u r going to implement both in single problem, use below structure
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int start = binarySearch(nums, target, true);

        // Early exit optimization remains intact
        if (start == -1)
            return new int[] { -1, -1 };

        int end = binarySearch(nums, target, false);
        return new int[] { start, end };
    }

    // A single helper method for both first and last positions
    private int binarySearch(int[] nums, int target, boolean findFirst) {
        int low = 0, high = nums.length - 1;
        int res = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] == target) {
                res = mid;
                if (findFirst) {
                    high = mid - 1; // Keep searching left for the start
                } else {
                    low = mid + 1; // Keep searching right for the end
                }
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return res;
    }
}
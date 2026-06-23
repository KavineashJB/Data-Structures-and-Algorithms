// 852. Peak Index in a Mountain Array

// You are given an integer mountain array arr of length n where the values increase to a peak element and then decrease.
// Return the index of the peak element.
// Your task is to solve it in O(log(n)) time complexity.

// Example 1:
// Input: arr = [0,1,0]
// Output: 1

// Example 2:
// Input: arr = [0,2,1,0]
// Output: 1

// Example 3:
// Input: arr = [0,10,5,2]
// Output: 1

// Constraints:
// 3 <= arr.length <= 105
// 0 <= arr[i] <= 106
// arr is guaranteed to be a mountain array.

// Problem Link: https://leetcode.com/problems/peak-index-in-a-mountain-array/
class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int low = 1, high = arr.length - 2;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            // Exactly at mountain's peak
            if (arr[mid] > arr[mid - 1] && arr[mid] > arr[mid] + 1)
                return mid;
            // left side mountain(asc phase)
            else if (arr[mid] > arr[mid - 1] && arr[mid] < arr[mid + 1])
                low = mid + 1;
            // right side of mountain(desc phase)
            else
                high = mid - 1;
        }
        return low;
    }
}
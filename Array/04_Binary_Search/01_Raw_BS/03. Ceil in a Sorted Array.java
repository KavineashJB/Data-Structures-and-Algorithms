// Ceil in a Sorted Array

// Given a sorted array arr[] and an integer x, find the index (0-based) of the smallest element in arr[] that is greater than or equal to x. This element is called the ceil of x. If such an element does not exist, return -1.

// Note: In case of multiple occurrences of ceil of x, return the index of the first occurrence.

// Examples

// Input: arr[] = [1, 2, 8, 10, 11, 12, 19], x = 5
// Output: 2
// Explanation: Smallest number greater than 5 is 8, whose index is 2.

// Input: arr[] = [1, 2, 8, 10, 11, 12, 19], x = 20
// Output: -1
// Explanation: No element greater than 20 is found. So output is -1.

// Input: arr[] = [1, 1, 2, 8, 10, 11, 12, 19], x = 0
// Output: 0
// Explanation: Smallest number greater than 0 is 1, whose indices are 0 and 1. The index of the first occurrence is 0.

// Constraints:
// 1 ≤ arr.size() ≤ 106
// 1 ≤ arr[i] ≤ 106
// 0 ≤ x ≤ arr[n-1]

// Expected Complexities
// Time Complexity: O(log n)
// Auxiliary Space: O(1)


// Problem Link: https://www.geeksforgeeks.org/problems/ceil-in-a-sorted-array/1
class Solution {
    public int findCeil(int[] arr, int x) {
        int l=0, h=arr.length-1;
        while(l<=h){
            int mid=l+(h-l)/2;
            if(arr[mid]<x) l=mid+1;
            else h=mid-1;
        }
        return l==arr.length?-1:l;
    }
}

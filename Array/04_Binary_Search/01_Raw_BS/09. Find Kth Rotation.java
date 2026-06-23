// Find Kth Rotation

// Given an increasing sorted rotated array arr[] of distinct integers. The array is right-rotated k times. Find the value of k.
// Let's suppose we have an array arr[] = [2, 4, 6, 9], if we rotate it by 2 times it will look like this:
// After 1st Rotation : [9, 2, 4, 6]
// After 2nd Rotation : [6, 9, 2, 4]

// Examples:
// Input: arr[] = [5, 1, 2, 3, 4]
// Output: 1
// Explanation: The given array is [5, 1, 2, 3, 4]. The original sorted array is [1, 2, 3, 4, 5]. We can see that the array was rotated 1 times to the right.

// Input: arr = [1, 2, 3, 4, 5]
// Output: 0
// Explanation: The given array is not rotated.

// Constraints:
// 1 ≤ arr.size() ≤ 105
// 1 ≤ arr[i] ≤ 107

// Expected Complexities
// Time Complexity: O(log n)
// Auxiliary Space: O(1)


// Problem Link: https://www.geeksforgeeks.org/problems/rotation4723/1
class Solution {
    public int findKRotation(int nums[]) {
        int l=0, h=nums.length-1;
        int res=Integer.MAX_VALUE;
        int resInd=-1;
        while(l<=h){
            int mid=l+(h-l)/2;
            if(nums[l]<=nums[mid]){
                if(nums[l]<res) {
                    res=nums[l];
                    resInd=l;
                }
                l=mid+1;
            } else {
                if(nums[mid]<res) {
                    res=nums[mid];
                    resInd=mid;
                }
                h=mid-1;
            }
        }
        return resInd;
    }
}
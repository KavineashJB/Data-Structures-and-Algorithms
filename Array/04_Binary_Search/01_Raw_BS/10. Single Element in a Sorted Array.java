// 540. Single Element in a Sorted Array

// You are given a sorted array consisting of only integers where every element appears exactly twice, except for one element which appears exactly once.

// Return the single element that appears only once.

// Your solution must run in O(log n) time and O(1) space.

// Example 1:
// Input: nums = [1,1,2,3,3,4,4,8,8]
// Output: 2

// Example 2:
// Input: nums = [3,3,7,7,10,11,11]
// Output: 10
 
// Constraints:
// 1 <= nums.length <= 105
// 0 <= nums[i] <= 105

// Problem Link: https://leetcode.com/problems/single-element-in-a-sorted-array/
class Solution {
    public int singleNonDuplicate(int[] nums) {
        int n=nums.length;

        // edge cases
        if(n==1 || nums[0]!=nums[1]) return nums[0];
        if(nums[n-1]!=nums[n-2]) return nums[n-1];

        int l=1, h=nums.length-2;
        while(l<=h){
            int mid=l+(h-l)/2;
            
            if(nums[mid]!=nums[mid-1] && nums[mid]!=nums[mid+1]) return nums[mid];
            
            if(mid%2==0){
                if(nums[mid]==nums[mid+1]) l=mid+1;
                else h=mid-1;
            } else {
                if(nums[mid]==nums[mid-1]) l=mid+1;
                else h=mid-1;
            }
        }
        return 1;
    }
}
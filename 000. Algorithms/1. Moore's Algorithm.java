// 169. Majority Element

// Given an array nums of size n, return the majority element.

// The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.

 

// Example 1:

// Input: nums = [3,2,3]
// Output: 3
// Example 2:

// Input: nums = [2,2,1,1,1,2,2]
// Output: 2
 

// Constraints:

// n == nums.length
// 1 <= n <= 5 * 104
// -109 <= nums[i] <= 109
// The input is generated such that a majority element will exist in the array.
 

// Follow-up: Could you solve the problem in linear time and in O(1) space?

// Problem Link: https://leetcode.com/problems/majority-element/description/
class Solution {
    public int majorityElement(int[] nums) {
        // Moore's algo
        // top 1 major freq ele
        int n=nums.length;
        int candidate=nums[0], cnt=1;
        for(int i=1;i<n;i++){
            if(nums[i]==candidate) cnt++;
            else cnt--;

            if(cnt==0){
                candidate=nums[i];
                cnt=1;
            }
        }
        cnt=0;
        for(int num:nums){
            if(num==candidate) cnt++;
        }
        return cnt>n/2?candidate:-1;
    }
}
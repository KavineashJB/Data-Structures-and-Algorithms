// 219. Contains Duplicate II

// Given an integer array nums and an integer k, return true if there are two distinct indices i and j in the array such that nums[i] == nums[j] and abs(i - j) <= k.


// Example 1:
// Input: nums = [1,2,3,1], k = 3
// Output: true

// Example 2:
// Input: nums = [1,0,1,1], k = 1
// Output: true

// Example 3:
// Input: nums = [1,2,3,1,2,3], k = 2
// Output: false
 

// Constraints:
// 1 <= nums.length <= 105
// -109 <= nums[i] <= 109
// 0 <= k <= 105

// Problem Link: https://leetcode.com/problems/contains-duplicate-ii/?envType=problem-list-v2&envId=sliding-window
import java.util.*;

class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        int left=0;
        Set<Integer> set=new HashSet<>();

        for(int right=0;right<nums.length;right++){
            if(!set.add(nums[right])) return true;

            while(set.size()>k){
                set.remove(nums[left]);
                left++;
            }
        }
        return false;
    }
}
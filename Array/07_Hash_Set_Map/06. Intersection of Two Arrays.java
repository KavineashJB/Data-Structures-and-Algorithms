// 349. Intersection of Two Arrays

// Given two integer arrays nums1 and nums2, return an array of their intersection. Each element in the result must be unique and you may return the result in any order.

// Example 1:
// Input: nums1 = [1,2,2,1], nums2 = [2,2]
// Output: [2]

// Example 2:
// Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
// Output: [9,4]
// Explanation: [4,9] is also accepted.
 
// Constraints:
// 1 <= nums1.length, nums2.length <= 1000
// 0 <= nums1[i], nums2[i] <= 1000


// Problem Link: https://leetcode.com/problems/intersection-of-two-arrays/
import java.util.*;

class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {

        HashSet<Integer> set1 = new HashSet<>();
        HashSet<Integer> result = new HashSet<>();

        // store nums1 elements
        for(int i = 0; i < nums1.length; i++){
            set1.add(nums1[i]);
        }

        // check common elements
        for(int j = 0; j < nums2.length; j++){

            if(set1.contains(nums2[j])){
                result.add(nums2[j]);
            }
        }

        // convert set to array
        int[] ans = new int[result.size()];
        int index = 0;
        for(int val : result){
            ans[index] = val;
            index++;
        }

        return ans;
    }
}
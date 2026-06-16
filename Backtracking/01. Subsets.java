// 78. Subsets

// Given an integer array nums of unique elements, return all possible subsets (the power set).

// The solution set must not contain duplicate subsets. Return the solution in any order.


// Example 1:
// Input: nums = [1,2,3]
// Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]

// Example 2:
// Input: nums = [0]
// Output: [[],[0]]
 

// Constraints:
// 1 <= nums.length <= 10
// -10 <= nums[i] <= 10
// All the numbers of nums are unique.

import java.util.*;
class Solution {
    List<List<Integer>> res;
    public void helper(int start, int[] nums, List<Integer> list) {
        res.add(new ArrayList<>(list));
        for(int i=start; i<nums.length; i++) {
            list.add(nums[i]);
            helper(i+1, nums, list);
            list.remove(list.size()-1);
        }
        
    }
    public void dfs(int i, int[] nums, List<Integer> list) {
        if(i==nums.length){
            res.add(new ArrayList<>(list));
            return;
        }
        list.add(nums[i]);
        dfs(i+1, nums, list);
        list.remove(list.size()-1);
        dfs(i+1, nums, list);
    }
    public List<List<Integer>> subsets(int[] nums) {
        res = new ArrayList<>();
        // helper(0, nums, new ArrayList<>());
        dfs(0, nums, new ArrayList<>());
        return res;
    }
}
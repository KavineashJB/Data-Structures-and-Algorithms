// 46. Permutations

// Given an array nums of distinct integers, return all the possible permutations. You can return the answer in any order.

// Example 1:
// Input: nums = [1,2,3]
// Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]

// Example 2:
// Input: nums = [0,1]
// Output: [[0,1],[1,0]]

// Example 3:
// Input: nums = [1]
// Output: [[1]]
 

// Constraints:
// 1 <= nums.length <= 6
// -10 <= nums[i] <= 10
// All the integers of nums are unique.


// Problem Link: https://leetcode.com/problems/permutations/?envType=problem-list-v2&envId=backtracking
import java.util.*;
class Solution {
    List<List<Integer>> res;

    // wrong intuition - I have to improve intuition
    // public int fact(int n){
    //     if(n==0 || n==1) return 1;
    //     return n*fact(n-1);
    // }

    // public void swap(int i, int j, int[] nums){
    //     int temp=nums[i];
    //     nums[i]=nums[j];
    //     nums[j]=temp;
    // }

    // public List<List<Integer>> permute(int[] nums) {
    //     int n=fact(nums.length);
    //     res=new ArrayList<>();
    //     if(n==1) {
    //         List<Integer> list = Arrays.asList(nums[0]);
    //         res.add(list);
    //         return res;
    //     }

    //     int i=0, j=1;
    //     while(n--!=0){
    //         swap(i,j,nums);
    //         res.add(Arrays.stream(nums).boxed().toList());
    //         i=(i+1)%nums.length;
    //         j=(j+1)%nums.length;
    //     }
        
    //     return res;
    // }

    public void swapList(int i, int j, List<Integer> list){
        int temp=list.get(i);
        list.set(i, list.get(j));
        list.set(j, temp);
    }

    public void dfs(int i, List<Integer> list){
        if(i==list.size()-1){
            res.add(new ArrayList<>(list));
            return;
        }

        for(int j=i;j<list.size();j++){
            swapList(i, j, list);
            dfs(i+1, list);
            // backtrack
            swapList(i, j, list);
        }
    }
    public List<List<Integer>> permute(int[] nums) {
        res=new ArrayList<>();

        List<Integer> list = new ArrayList<>();
        for(int num:nums) list.add(num);
        
        dfs(0, list);

        return res;
    }
}
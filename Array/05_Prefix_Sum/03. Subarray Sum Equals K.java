// 560. Subarray Sum Equals K

// Given an array of integers nums and an integer k, return the total number of subarrays whose sum equals to k.

// A subarray is a contiguous non-empty sequence of elements within an array.


// Example 1:
// Input: nums = [1,1,1], k = 2
// Output: 2

// Example 2:
// Input: nums = [1,2,3], k = 3
// Output: 2

// Constraints:
// 1 <= nums.length <= 2 * 104
// -1000 <= nums[i] <= 1000
// -107 <= k <= 107


// Problem Link: https://leetcode.com/problems/subarray-sum-equals-k/
class Solution {
    public int subarraySum(int[] nums, int k) {
        // since the nums[]  may contain -ve num, so we can't use the var size sliding window. 
        // Where the var size sliding window didn't work due to the -ve nums, we can use the (PrefixSum + HashMap)

        // Approach 1: 
        // Technique: Var size sliding window(Only for +ve nums)

        int left=0, res=0;
        int sum=0;

        for(int right=0;right<nums.length;right++){
            sum+=nums[right];

            while(sum>k){
                sum-=nums[left];
                left++;
            }

            res=Math.max(res,right-left+1);
        }
        return res;


        // Approach 2: 
        // Tehnique: since var size sw fails due to nums[] contain -ve num, I am using (PrefixSum + HashMap)

        Map<Integer, Integer> map=new HashMap<>();
        map.put(0,1);

        int ps=0;
        int cnt=0;
        for(int i=0;i<nums.length;i++){
            ps+=nums[i];

            if(map.containsKey(ps-k)){
                cnt += map.get(ps-k);
            }

            map.put(ps, map.getOrDefault(ps,0)+1);
        }
        return cnt;
    }
}
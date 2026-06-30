// 1838. Frequency of the Most Frequent Element

// The frequency of an element is the number of times it occurs in an array.

// You are given an integer array nums and an integer k. In one operation, you can choose an index of nums and increment the element at that index by 1.

// Return the maximum possible frequency of an element after performing at most k operations.

// Example 1:
// Input: nums = [1,2,4], k = 5
// Output: 3
// Explanation: Increment the first element three times and the second element two times to make nums = [4,4,4].
// 4 has a frequency of 3.

// Example 2:
// Input: nums = [1,4,8,13], k = 5
// Output: 2
// Explanation: There are multiple optimal solutions:
// - Increment the first element three times to make nums = [4,4,8,13]. 4 has a frequency of 2.
// - Increment the second element four times to make nums = [1,8,8,13]. 8 has a frequency of 2.
// - Increment the third element five times to make nums = [1,4,13,13]. 13 has a frequency of 2.

// Example 3:
// Input: nums = [3,9,6], k = 2
// Output: 1
 

// Constraints:
// 1 <= nums.length <= 105
// 1 <= nums[i] <= 105
// 1 <= k <= 105


// Problem Link: https://leetcode.com/problems/frequency-of-the-most-frequent-element/
class Solution {
    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        // int n=nums.length;
        // This is greedy but fails 
        // TC: nums = [1,3,4], k = 1
        // Exp: 2 [1,4,4], op= 1 [1,3,4];
        // int cnt=1;
        // for(int i=1;i<n;i++){
        //     int diff=nums[i]-nums[i-1];
        //     if(k>=diff*i) {
        //         cnt++;
        //         k-=diff*i;
        //     } else {
        //         break;
        //     }
        // }
        // return cnt;

        // Sliding window
        // int n=nums.length;
        // int left=0, maxi=1;
        // int temp=k;
        // for(int r=1;r<n;r++){
        //     int diff=nums[r]-nums[r-1];

        //     if(k>=diff*(r-left)) {
        //         k-=diff*(r-left);
        //     } else {
        //         k=temp;
        //         left=r;
        //     }

        //     maxi=Math.max(maxi,r-left+1);
        // }
        // return maxi;

        int left = 0, n = nums.length, maxLen = 1;
        long tot = 0;
        for (int right = 0; right < n; right++) {
            tot += nums[right];
            // (long) nums[right]*(right-left+1) > tot+k // this getting overflow
            while ((long) nums[right] * (right - left + 1) - tot > k) {
                tot -= nums[left];
                left++;
            }

            maxLen = Math.max(maxLen, right - left + 1);
        }
        return maxLen;
    }
}
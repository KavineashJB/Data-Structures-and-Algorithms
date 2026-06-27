// Allocate Minimum Pages

// Given an array arr[] of integers, where each element arr[i] represents the number of pages in the i-th book. You also have an integer k representing the number of students. The task is to allocate books to each student such that:

// Each student receives atleast one book.
// Each student is assigned a contiguous sequence of books.
// No book is assigned to more than one student.
// All books must be allocated.
// The objective is to minimize the maximum number of pages assigned to any student. In other words, out of all possible allocations, find the arrangement where the student who receives the most pages still has the smallest possible maximum.

// Note: If it is not possible to allocate books to all students, return -1.

// Examples:

// Input: arr[] = [12, 34, 67, 90], k = 2
// Output: 113
// Explanation: Allocation can be done in following ways:
// => [12] and [34, 67, 90] Maximum Pages = 191
// => [12, 34] and [67, 90] Maximum Pages = 157
// => [12, 34, 67] and [90] Maximum Pages = 113.
// The third combination has the minimum pages assigned to a student which is 113.

// Input: arr[] = [15, 17, 20], k = 5
// Output: -1
// Explanation: Since there are more students than total books, it's impossible to allocate a book to each student.

// Constraints:
// 1 ≤ arr.size() ≤ 106
// 1 ≤ arr[i], k ≤ 103

// Expected Complexities
// Time Complexity: O( n × log(sum(arr)))
// Auxiliary Space: O(1)


// Problem Link: https://www.geeksforgeeks.org/problems/allocate-minimum-number-of-pages0937/1


// ======================================================================================================
// ======================================================================================================
// ======================================================================================================
// ======================================================================================================


// 410. Split Array Largest Sum

// Given an integer array nums and an integer k, split nums into k non-empty subarrays such that the largest sum of any subarray is minimized.
// Return the minimized largest sum of the split.
// A subarray is a contiguous part of the array.

// Example 1:
// Input: nums = [7,2,5,10,8], k = 2
// Output: 18
// Explanation: There are four ways to split nums into two subarrays.
// The best way is to split it into [7,2,5] and [10,8], where the largest sum among the two subarrays is only 18.

// Example 2:
// Input: nums = [1,2,3,4,5], k = 2
// Output: 9
// Explanation: There are four ways to split nums into two subarrays.
// The best way is to split it into [1,2,3] and [4,5], where the largest sum among the two subarrays is only 9.

// Constraints:
// 1 <= nums.length <= 1000
// 0 <= nums[i] <= 106
// 1 <= k <= min(50, nums.length)

// Problem Link: https://leetcode.com/problems/split-array-largest-sum/
class Solution {
    
    public boolean cntBook(int mid, int[] arr, int k){
        int tot=1, curr=0;
        for(int i=0;i<arr.length;i++){
            if(curr+arr[i]<=mid){
                curr+=arr[i];
            } else {
                tot++;
                curr=arr[i];
                if(tot>k) return false;
            }
        }
        return true;
    }
    public int findPages(int[] arr, int k) {
        int n=arr.length;
        
        if(n<k) return -1;
        
        int l=arr[0], h=0;
        for(int num:arr){
            l=Math.max(l, num);
            h+=num;
        }
        
        int res=-1;
        while(l<=h){
            int mid=l+(h-l)/2;
            boolean poss=cntBook(mid,arr,k);
            if(poss){
                res=mid;
                h=mid-1;
            } else {
                l=mid+1;
            }
        }
        return res;
    }
}
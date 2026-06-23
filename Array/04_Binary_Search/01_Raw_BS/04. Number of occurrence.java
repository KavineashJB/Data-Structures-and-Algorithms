// Number of occurrence

// Given a sorted array, arr[] and a number target, you need to find the number of occurrences of target in arr[]. 

// Examples :
// Input: arr[] = [1, 1, 2, 2, 2, 2, 3], target = 2
// Output: 4
// Explanation: target = 2 occurs 4 times in the given array so the output is 4.

// Input: arr[] = [1, 1, 2, 2, 2, 2, 3], target = 4
// Output: 0
// Explanation: target = 4 is not present in the given array so the output is 0.

// Input: arr[] = [8, 9, 10, 12, 12, 12], target = 12
// Output: 3
// Explanation: target = 12 occurs 3 times in the given array so the output is 3.

// Constraints:
// 1 ≤ arr.size() ≤ 106
// 1 ≤ arr[i] ≤ 106
// 1 ≤ target ≤ 106

// Expected Complexities
// Time Complexity: O(log n)
// Auxiliary Space: O(1)


// Problem Link: https://www.tle-eliminators.com/snippets/leetcode-weekly-contest-507-problem-d
class Solution {
    int countFreq(int[] arr, int target) {
        int first=bs(arr,target, true);
        if(first==-1 || first==arr.length) return 0;
        int last=bs(arr,target, false);
        return last-first+1;
        
    }
    
    int bs(int[] arr, int target, boolean isFirst){
        int l=0, h=arr.length-1;
        int res=-1;
        while(l<=h){
            int mid=l+(h-l)/2;
            if(arr[mid]==target){
                res=mid;
                if(isFirst) h=mid-1;
                else l=mid+1;
            } else if(arr[mid]<target){
                l=mid+1;
            } else {
                h=mid-1;
            }
        }
        return res;
    }
}

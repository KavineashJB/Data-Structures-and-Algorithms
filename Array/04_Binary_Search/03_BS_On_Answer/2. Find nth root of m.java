// Find nth root of m

// You are given 2 numbers n and m, the task is to find n√m (nth root of m). If the root is not integer then return -1.

// Examples :

// Input: n = 3, m = 8
// Output: 2
// Explanation: 23 = 8

// Input: n = 3, m = 9
// Output: -1
// Explanation: 3rd root of 9 is not integer.

// Input: n = 4, m = 16
// Output: 2
// Explanation: 24 = 16

// Constraints:
// 1 ≤ n ≤ 9
// 0 ≤ m ≤ 20

// Expected Complexities
// Time Complexity: O(n log m)
// Auxiliary Space: O(1)


// Problem Link: https://www.geeksforgeeks.org/problems/find-nth-root-of-m5843/1
class Solution {
    public int nthRoot(int n, int m) {
        // l=0 -> 0^any=0;
        int l=0, h=m;
        
        while(l<=h){
            int mid=l+(h-l)/2;
            
            long val=(long)Math.pow(mid, n);
            if(val==m) return mid;
            if(val<m) l=mid+1;
            else h=mid-1;
        }
        return -1;
    }
}
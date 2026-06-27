// Aggressive Cows

// You are given an array with unique elements of stalls[], which denote the positions of stalls. You are also given an integer k which denotes the number of aggressive cows. The task is to assign stalls to k cows such that the minimum distance between any two of them is the maximum possible.

// Examples:
// Input: stalls[] = [1, 2, 4, 8, 9], k = 3
// Output: 3
// Explanation: The first cow can be placed at stalls[0], 
// the second cow can be placed at stalls[2] and 
// the third cow can be placed at stalls[3]. 
// The minimum distance between cows in this case is 3, which is the largest among all possible ways.

// Input: stalls[] = [10, 1, 2, 7, 5], k = 3
// Output: 4
// Explanation: The first cow can be placed at stalls[0],
// the second cow can be placed at stalls[1] and
// the third cow can be placed at stalls[4].
// The minimum distance between cows in this case is 4, which is the largest among all possible ways.

// Input: stalls[] = [2, 12, 11, 3, 26, 7], k = 5
// Output: 1
// Explanation: There are 6 stalls and only 5 cows, we try to place the cows such that the minimum distance between any two cows is as large as possible.
// The minimum distance between cows in this case is 1, which is the largest among all possible ways.

// Constraints:
// 2 ≤ stalls.size() ≤ 106
// 0 ≤ stalls[i] ≤ 108
// 2 ≤ k ≤ stalls.size()

// Expected Complexities
// Time Complexity: O(n log m)
// Auxiliary Space: O(1)


// Problem Link: https://www.geeksforgeeks.org/problems/aggressive-cows/1
import java.util.*;
class Solution {
    public boolean placeCows(int mid, int[] st, int k){
        int i=0, j=1, c=1;
        while(j<st.length){
            if(st[j]-st[i]>=mid) {
                c++;
                i=j;
            }
            if(c==k) return true;
            j++;
        }
        return false;
    }
    public int aggressiveCows(int[] st, int k) {
        Arrays.sort(st);
        int l=0, h=st[st.length-1];
        int res=-1;
        while(l<=h){
            int mid=l+(h-l)/2;
            boolean poss=placeCows(mid, st, k);
            if(poss) {
                res=mid;
                l=mid+1;
            }
            else h=mid-1;
        }
        return res;
    }
}
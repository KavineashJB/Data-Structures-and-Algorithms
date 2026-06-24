// 875. Koko Eating Bananas

// Koko loves to eat bananas. There are n piles of bananas, the ith pile has piles[i] bananas. The guards have gone and will come back in h hours.

// Koko can decide her bananas-per-hour eating speed of k. Each hour, she chooses some pile of bananas and eats k bananas from that pile. If the pile has less than k bananas, she eats all of them instead and will not eat any more bananas during this hour.

// Koko likes to eat slowly but still wants to finish eating all the bananas before the guards return.

// Return the minimum integer k such that she can eat all the bananas within h hours.


// Example 1:
// Input: piles = [3,6,7,11], h = 8
// Output: 4

// Example 2:
// Input: piles = [30,11,23,4,20], h = 5
// Output: 30

// Example 3:
// Input: piles = [30,11,23,4,20], h = 6
// Output: 23

// Constraints:
// 1 <= piles.length <= 104
// piles.length <= h <= 109
// 1 <= piles[i] <= 109


// Problem Link: https://leetcode.com/problems/koko-eating-bananas/
class Solution {
    public int getMin(int p[]){
        int mini=p[0];
        for(int i=1;i<p.length;i++){
            if(p[i]<mini){
                mini=p[i];
            }
        }
        return mini;
    }
    public int getMax(int p[]){
        int maxi=p[0];
        for(int i=1;i<p.length;i++){
            if(p[i]>maxi){
                maxi=p[i];
            }
        }
        return maxi;
    }
    public long calcHrs(int[] p, int val){
        long totHrs=0;
        for(int i=0;i<p.length;i++){
            totHrs += (long)((p[i]-1)/val)+1;
        }
        return totHrs;
    }
    public int minEatingSpeed(int[] p, int maxHr) {
        int l=1, h=getMax(p);

        while(l<=h){
            int mid=l+(h-l)/2;
            long hrs=calcHrs(p, mid);
            if(hrs>maxHr) l=mid+1;
            else h=mid-1;
        }
        return l;
    }
}
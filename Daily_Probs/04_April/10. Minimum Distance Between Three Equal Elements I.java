// Minimum Distance Between Three Equal Elements I

// You are given an integer array nums.

// A tuple (i, j, k) of 3 distinct indices is good if nums[i] == nums[j] == nums[k].

// The distance of a good tuple is abs(i - j) + abs(j - k) + abs(k - i), where abs(x) denotes the absolute value of x.

// Return an integer denoting the minimum possible distance of a good tuple. If no good tuples exist, return -1.


// Example 1:
// Input: nums = [1,2,1,1,3]
// Output: 6
// Explanation:
// The minimum distance is achieved by the good tuple (0, 2, 3).
// (0, 2, 3) is a good tuple because nums[0] == nums[2] == nums[3] == 1. Its distance is abs(0 - 2) + abs(2 - 3) + abs(3 - 0) = 2 + 1 + 3 = 6.

// Example 2:
// Input: nums = [1,1,2,3,2,1,2]
// Output: 8
// Explanation:
// The minimum distance is achieved by the good tuple (2, 4, 6).
// (2, 4, 6) is a good tuple because nums[2] == nums[4] == nums[6] == 2. Its distance is abs(2 - 4) + abs(4 - 6) + abs(6 - 2) = 2 + 2 + 4 = 8.

// Example 3:
// Input: nums = [1]
// Output: -1
// Explanation:
// There are no good tuples. Therefore, the answer is -1.

// Constraints:
// 1 <= n == nums.length <= 100
// 1 <= nums[i] <= n

// problem link:  https://leetcode.com/problems/minimum-distance-between-three-equal-elements-i/?envType=daily-question&envId=2026-04-11


import java.util.*;
class Solution {
    Map<Integer, List<Integer>> map;
    public int minimumDistance(int[] nums) {
        map=new HashMap<>();
        int n=nums.length;
        for(int i=0; i<n; i++){
            if(!map.containsKey(nums[i])){
                map.put(nums[i], new ArrayList<Integer>());
            }
            map.get(nums[i]).add(i);
        }
        System.out.println(map);
        int mini=(int)1e9;
        for(Map.Entry<Integer, List<Integer>> e:map.entrySet()){
            List<Integer> l = e.getValue();
            int m=l.size();
            if(m>=3) {
                int i=0,j=1,k=2;
                while(i<m && j<m && k<m){
                    // l.get(j)-l.get(i) + l.get(k)-l.get(j) + l.get(k) - l.get(i)
                    // j-i+k-j+k-i
                    // 2k-2i
                    mini=Math.min(mini,2*(l.get(k)-l.get(i)));
                    i++; j++; k++;
                }

            }
        }
        return mini==(int)1e9?-1:mini;
    }
}
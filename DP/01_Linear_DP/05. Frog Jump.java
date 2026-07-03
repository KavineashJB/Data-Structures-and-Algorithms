// Frog Jump

// Given an integer array height[] where height[i] represents the height of the i-th stair, a frog starts from the first stair and wants to reach the last stair. From any stair i, the frog has two options: it can either jump to the (i+1)th stair or the (i+2)th stair. The cost of a jump is the absolute difference in height between the two stairs. Determine the minimum total cost required for the frog to reach the last stair.

// Example:

// Input: heights[] = [20, 30, 40, 20]
// Output: 20
// Explanation:  Minimum cost is incurred when the frog jumps from stair 0 to 1 then 1 to 3:
// jump from stair 0 to 1: cost = |30 - 20| = 10
// jump from stair 1 to 3: cost = |20 - 30| = 10
// Total Cost = 10 + 10 = 20
// Input: heights[] = [30, 20, 50, 10, 40]
// Output: 30
// Explanation: Minimum cost will be incurred when frog jumps from stair 0 to 2 then 2 to 4:
// jump from stair 0 to 2: cost = |50 - 30| = 20
// jump from stair 2 to 4: cost = |40 - 50| = 10
// Total Cost = 20 + 10 = 30

// Constraints:
// 1 ≤ height.size() ≤ 105
// 0 ≤ height[i] ≤ 104

// Expected Complexities
// Time Complexity: O(n)
// Auxiliary Space: O(1)

// Problem Link: https://www.geeksforgeeks.org/problems/geek-jump/1
import java.util.*;

class Solution {
    int[] dp;

    int rec(int n, int[] h) {
        if (n == 0)
            return 0;
        int one = rec(n - 1, h) + Math.abs(h[n] - h[n - 1]);
        int two = Integer.MAX_VALUE;
        if (n > 1) {
            two = rec(n - 2, h) + Math.abs(h[n] - h[n - 2]);
        }
        return Math.min(one, two);
    }

    int mem(int n, int[] h) {
        if (n == 0)
            return 0;
        if (dp[n] != -1)
            return dp[n];

        int one = mem(n - 1, h) + Math.abs(h[n] - h[n - 1]);
        int two = Integer.MAX_VALUE;
        if (n > 1) {
            two = mem(n - 2, h) + Math.abs(h[n] - h[n - 2]);
        }
        return dp[n] = Math.min(one, two);
    }

    int minCost(int[] height) {
        int n = height.length;
        // return rec(n-1,height);
        dp = new int[n + 1];
        Arrays.fill(dp, -1);
        return mem(n - 1, height);
    }
}
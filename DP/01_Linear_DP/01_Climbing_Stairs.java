// 70. Climbing Stairs

// You are climbing a staircase. It takes n steps to reach the top.
// Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?


// Example 1:
// Input: n = 2
// Output: 2
// Explanation: There are two ways to climb to the top.
// 1. 1 step + 1 step
// 2. 2 steps

// Example 2:
// Input: n = 3
// Output: 3
// Explanation: There are three ways to climb to the top.
// 1. 1 step + 1 step + 1 step
// 2. 1 step + 2 steps
// 3. 2 steps + 1 step

// Constraints:

// 1 <= n <= 45


// Solution:

import java.util.Arrays;
class Climbing_Stairs {

    // Time Complexity - O(2^n)
    // Space Complexity - O(n)-> stack for recursion
    public static int rec(int n){
        if(n<=1) return 1;
        return rec(n-1)+rec(n-2);
    }

    // Time Complexity - O(n)
    // Space Complexity - O(n) -> stack for recursion, O(n) -> dp
    public static int mem(int n, int[] dp){
        if(n<=1) return 1;
        if(dp[n]!=-1) return dp[n];
        return dp[n]=rec(n-1)+rec(n-2);
    }

    // Time Complexity - O(n)
    // Space Complexity - O(n) -> dp
    public static int tab(int n, int[] dp){
        dp[1]=dp[0]=1;
        for(int i=2; i<=n; i++){
            dp[i]=dp[i-1]+dp[i-2]; 
        }
        return dp[n];
    }

    // Time Complexity - O(n)
    // Space Complexity - O(1) 
    public static int tabSpace(int n){
        int prev1, prev2;
        prev1=prev2=1;
        for(int i=2; i<=n; i++){
            int curr= prev1+prev2;
            prev2=prev1;
            prev1=curr;
        }
        return prev1;
    }

    public static int climbStairs(int n) {
        // return rec(n);
        int[] dp=new int[n+1];
        Arrays.fill(dp,-1);
        // return mem(n, dp);
        // return tab(n, dp);
        return tabSpace(n);
    }

    public static void main(String[] args){
        climbStairs(3); // 3
        climbStairs(5); // 5
    }
}


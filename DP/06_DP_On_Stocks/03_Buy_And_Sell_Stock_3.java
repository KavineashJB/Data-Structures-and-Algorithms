// 123. Best Time to Buy and Sell Stock III

// You are given an array prices where prices[i] is the price of a given stock on the ith day.
// Find the maximum profit you can achieve. You may complete at most two transactions.
// Note: You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).

 
// Example 1:
// Input: prices = [3,3,5,0,0,3,1,4]
// Output: 6
// Explanation: Buy on day 4 (price = 0) and sell on day 6 (price = 3), profit = 3-0 = 3.
// Then buy on day 7 (price = 1) and sell on day 8 (price = 4), profit = 4-1 = 3.

// Example 2:
// Input: prices = [1,2,3,4,5]
// Output: 4
// Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4.
// Note that you cannot buy on day 1, buy on day 2 and sell them later, as you are engaging multiple transactions at the same time. You must sell before buying again.

// Example 3:
// Input: prices = [7,6,4,3,1]
// Output: 0
// Explanation: In this case, no transaction is done, i.e. max profit = 0.
 

// Constraints:

// 1 <= prices.length <= 105
// 0 <= prices[i] <= 105


// Solution: 1
import java.util.Arrays;
class Solution1 {
    public int rec(int ind, int canBuy, int cap, int[] prices) {
        if(ind==prices.length || cap==0) return 0;
        if(canBuy==1) {
            return Math.max(-1*prices[ind] + rec(ind+1, 0, cap, prices), rec(ind+1, 1, cap, prices));
        } else {
            return Math.max(prices[ind] + rec(ind+1, 1, cap-1, prices), rec(ind+1, 0, cap, prices));
        }
    }

    public int mem(int ind, int canBuy, int cap, int[] prices, int[][][] dp) {
        if(ind==prices.length || cap==0) return 0;
        if(dp[ind][canBuy][cap]!=-1) return dp[ind][canBuy][cap];

        if(canBuy==1) {
            return dp[ind][canBuy][cap]=Math.max(-1*prices[ind] + mem(ind+1, 0, cap, prices, dp), mem(ind+1, 1, cap, prices, dp));
        } else {
            return dp[ind][canBuy][cap]=Math.max(prices[ind] + mem(ind+1, 1, cap-1, prices, dp), mem(ind+1, 0, cap, prices, dp));
        }
    }

    public int tab(int ind, int canBuy, int cap, int[] prices, int[][][] dp) {
        for(int i=0; i<2; i++) {
            for(int j=0; j<3; j++) {
                dp[prices.length][i][j]=0;
            }
        }

        for(int i=0; i<=prices.length; i++) {
            dp[i][0][0]=dp[i][1][0]=0;
        }

        for(int i=prices.length-1; i>=0; i--){
            for(int j=0; j<2; j++) {
                for(int k=1; k<3; k++) {
                    if(j==1) {
                        dp[i][j][k]=Math.max(-1*prices[i] + dp[i+1][0][k], dp[i+1][1][k]);
                    } else {
                        dp[i][j][k]=Math.max(prices[i] + dp[i+1][1][k-1], dp[i+1][0][k]);
                    }
                }
            }
        }
        return dp[ind][canBuy][cap];
    }

    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][][] dp_3d = new int[n+1][2][3]; // 2->canBuy(0/1), 3->cap(2/1/0)

        for(int[][] mat: dp_3d) {
            for(int[] row: mat) {
                Arrays.fill(row, -1);
            }
        }

        // return rec(0, 1, 2, prices);
        // return mem(0, 1, 2, prices, dp_3d);
        return tab(0, 1, 2, prices, dp_3d);
    }
}

// Solution: 2

class Solution2 {

    public int rec(int ind, int trans, int[] prices) {
        if(ind==prices.length || trans==4) return 0;
        boolean canBuy=trans%2==0;
        if(canBuy) {
            return Math.max(-1*prices[ind] + rec(ind+1, trans+1, prices), rec(ind+1, trans, prices));
        } else {
            return Math.max(prices[ind] + rec(ind+1, trans+1, prices), rec(ind+1, trans, prices));
        }
    }

    public int mem(int ind, int trans, int[] prices, int[][] dp) {
        if(ind==prices.length || trans==4) return 0;
        if(dp[ind][trans]!=-1) return dp[ind][trans];
        boolean canBuy=trans%2==0;
        if(canBuy) {
            return dp[ind][trans]=Math.max(-1*prices[ind] + mem(ind+1, trans+1, prices, dp), mem(ind+1, trans, prices, dp));
        } else {
            return dp[ind][trans]=Math.max(prices[ind] + mem(ind+1, trans+1, prices, dp), mem(ind+1, trans, prices, dp));
        }
    }

    public int tab(int ind, int trans, int[] prices, int[][] dp) {
        // if(ind==prices.length) return 0;
        for(int j=0; j<=4; j++) {
            dp[prices.length][j] = 0;
        }
        // if(trans==4) return 0;
        for(int i=0; i<=prices.length; i++){
            dp[i][4] = 0;
        }

        for(int i=prices.length-1; i>=0; i--) {
            for(int j=3; j>=0; j--) {
                boolean canBuy=j%2==0;
                if(canBuy) {
                    dp[i][j]=Math.max(-1*prices[i] + dp[i+1][j+1], dp[i+1][j]);
                } else {
                    dp[i][j]=Math.max(prices[i] + dp[i+1][j+1], dp[i+1][j]);
                }
            }
        }

        return dp[ind][trans];
    }

    public int maxProfit(int[] prices) {
        int n = prices.length;
        
        // int[][] dp_2d = new int[n][4];      // -> for mem
        int[][] dp_2d = new int[n+1][5];      // -> for tab also for mem
        // 4 -> B S B S
        //      0 1 2 3

        for(int[] row: dp_2d) {
            Arrays.fill(row, -1);
        }
        // method: 2
        // return rec2(0, 0, prices);
        // return mem2(0, 0, prices, dp_2d);
        return tab(0, 0, prices, dp_2d);
    }
}
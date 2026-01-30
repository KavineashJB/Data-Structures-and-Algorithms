import java.util.Arrays;
class Solution {
    public int rec(int ind, int canBuy, int[] prices) {
        if(ind==prices.length) {
            return 0;
            // above return 0 explained below
            // if(canBuy==1) return 0;
            // else return -1 * prices[ind-1];            
        }
        if(canBuy==1) {
            return Math.max(-1*prices[ind] + rec(ind+1, 0, prices), 0 + rec(ind+1, 1, prices));
        } else {
            return Math.max(prices[ind] + rec(ind+1, 1, prices), 0 + rec(ind+1, 0, prices));
        }
    }

    public int mem(int ind, int canBuy, int[] prices, int[][] dp) {
        if(ind==prices.length) return 0;
        if(dp[ind][canBuy]!=-1) return dp[ind][canBuy];

        if(canBuy==1) {
            return dp[ind][canBuy] = Math.max(-1*prices[ind] + mem(ind+1, 0, prices, dp), 0 + mem(ind+1, 1, prices, dp));
        } else {
            return dp[ind][canBuy] = Math.max(prices[ind]+mem(ind+1, 1, prices, dp), 0 + mem(ind+1, 0, prices, dp));
        }
    }

    public int tab(int ind, int canBuy, int[] prices, int[][] dp) {
        // dp[n][0]=dp[n][1]=0
        for(int j=0; j<2; j++) dp[prices.length][j]=0;
    
        for(int i=prices.length-1; i>=0; i--) {
            for(int j=0; j<2; j++) {
                if(j==1) {
                    dp[i][j] = Math.max(-1*prices[i] + dp[i+1][0], 0 + dp[i+1][1]);
                } else {
                    dp[i][j] = Math.max(prices[i]+dp[i+1][1], 0 + dp[i+1][0]);
                }
            }
        }
        return dp[ind][canBuy];
    }

    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n+1][2]; // 2->canBuy(0/1) 
        for(int[] row: dp) Arrays.fill(row, -1);

        // return rec(0, 1, prices);
        // return mem(0, 1, prices, dp);
        return tab(0, 1, prices, dp);
    }
}
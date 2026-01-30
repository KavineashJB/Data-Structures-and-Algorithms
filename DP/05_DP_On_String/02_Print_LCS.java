// Solution 1: -> works wel for mem but not for tab
class Solution1 {
    public static String rec(int n1, int n2, String s1, String s2) {
        if(n1<0 || n2<0) return "";
        if(s1.charAt(n1)==s2.charAt(n2)) {
            return rec(n1-1, n2-1, s1, s2)+s1.charAt(n1);
        }
        String a = rec(n1-1, n2, s1, s2);
        String b = rec(n1, n2-1, s1, s2);
        return (a.length()>b.length())?a:b;
    }

    public static String mem(int n1, int n2, String s1, String s2, String[][] dp) {
        if(n1<0 || n2<0) return "";
        if(dp[n1][n2]!=null) return dp[n1][n2];
        if(s1.charAt(n1)==s2.charAt(n2)) {
            return dp[n1][n2]=rec(n1-1, n2-1, s1, s2)+s1.charAt(n1);
        }
        String a = mem(n1-1, n2, s1, s2, dp);
        String b = mem(n1, n2-1, s1, s2, dp);
        return dp[n1][n2]=(a.length()>b.length())?a:b;
    }

    public static String tab(int n1, int n2, String s1, String s2, String[][] dp) {
        for(int i=0; i<=n1; i++) {
            dp[i][0]="";
        }
        for(int j=0; j<=n2; j++) {
            dp[0][j]="";
        }
        for(int i=1; i<=n1; i++) {
            for(int j=1; j<=n2; j++) {
                if(s1.charAt(i-1)==s2.charAt(j-1)) {
                    dp[i][j]=dp[i-1][j-1]+s1.charAt(i-1);
                } else {
                    String a = dp[i-1][j];
                    String b = dp[i][j-1];
                    dp[i][j]=(a.length()>b.length())?a:b;
                }
            }
        }
        return dp[n1][n2];
    }

    public static String findLCS(int n, int m, String s1, String s2){
        String[][] dp = new String[n+1][m+1];
        
        // return rec(n-1,m-1,s1,s2);
        // return mem(n-1, m-1, s1, s2, dp);
        return tab(n, m, s1, s2, dp);
    }
}

// Solution 2: -> work well for tab
class Solution2 {
     public static String tab(int n1, int n2, String s1, String s2, int[][] dp) {
        for(int i=0; i<=n1; i++) {
            dp[i][0]=0;
        }
        for(int j=0; j<=n2; j++) {
            dp[0][j]=0;
        }
        // i-1 -> represent length not index
        for(int i=1; i<=n1; i++) {
            for(int j=1; j<=n2; j++) {
                if(s1.charAt(i-1)==s2.charAt(j-1)){
                    dp[i][j]=1+dp[i-1][j-1];
                } else {
                    dp[i][j]=Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        String s="";
        int i=n1, j=n2;
        while(i>0 && j>0) {
            if(s1.charAt(i-1)==s2.charAt(j-1)){
                s= s1.charAt(i-1)+s;
                i--; 
                j--;
            } 
            else if(dp[i-1][j] > dp[i][j-1]) {
                i--;
            } else {
                j--;
            }
        }
        return s;
    }
    public static String findLCS(int n, int m, String s1, String s2){
        int[][] dp = new int[n+1][m+1];
        return tab(n, m, s1, s2, dp);
    }
}
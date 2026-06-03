import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

public class Standard_Patterns {

    public static void patternA(int n) {

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void patternB(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

    public static void patternC(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void patternD(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }

    public static void patternE(int n) {
        // // i is odd, row startswith 1 
        // // else row startswith 0
        // // following are invert of previous
        
        // // Approach 1: 
        // for (int i = 1; i <= n; i++) {
        //     boolean isOdd=(i % 2 == 1);
        //     for (int j = isOdd ? 1 : 0; j <= (isOdd ? i : i - 1); j++) {
        //         System.out.print(j%2 + " ");
        //     }
        //     System.out.println();
        // }
        
        // Approach 2: Best(readable) 
        for (int i = 1; i <= n; i++) {
            int printVal=(i % 2 == 0)?0:1;
            for (int j = 1; j <= i; j++) {
                System.out.print(printVal + " ");
                printVal^=1;
            }
            System.out.println();
        }
    }

    public static void patternF(int n) {
        int val=1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j<=i; j++) {
                System.out.print(val + " ");
                val++;
            }
            System.out.println();
        }
    }
    
    public static void patternG(int n) {
        // Good Approach
        for (int i = n; i >=1; i--) {
            for (int j = 1; j<=i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
        
        // // formula: n-(i-1) or n-i+1
        // for (int i = 1; i <=n; i++) {
        //     for (int j = 1; j<=n-(i-1); j++) {
        //         System.out.print("*");
        //     }
        //     System.out.println();
        // }
    }
    
    public static void patternH(int n) {
        for (int i = n; i >=1; i--) {
            for (int j = 1; j<=i; j++) {
                System.out.print(i+" ");
            }
            System.out.println();
        }
    }
    
    public static void patternI(int n) {
        for (int i = n; i >= 1; i--) {
            for (int j = 1; j<=i; j++) {
                System.out.print(j+" ");
            }
            System.out.println();
        }
    }

    public static void patternJ(int n){
        for(int i=1;i<=2*n-1;i++){
            int end=(i>n)?n-(i%n):i;
            for(int j=1;j<=end; j++){
                System.out.print("*");
            }
            System.out.println();
        }

        // for(int i=1;i<=2*n-1;i++){
        //     int end=(i>n)?(2*n-i):i;
        //     for(int j=1;j<=end; j++){
        //         System.out.print("*");
        //     }
        //     System.out.println();
        // }
    }

    public static void patternK(int n){
        for(int i=1;i<=n;i++){
            for(int sp=1;sp<=n-i;sp++){
                System.out.print(" ");
            }
            for(int j=1;j<=i;j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void patternL(int n){
        for(int i=n;i>=1;i--){
            for(int sp=1;sp<=n-i;sp++){
                System.out.print(" ");
            }
            for(int j=1;j<=i;j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void patternM(int n) {
        for (int i = 1; i <= n; i++) {
            for (int sp = 1; sp <= n - i; sp++) {
                System.out.print(" ");
            }
            for (int j = 1; j <= 2*i-1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void patternN(int n) {
        for (int i = n; i >= 1; i--) {
            for (int sp = 1; sp <= n - i; sp++) {
                System.out.print(" ");
            }
            for (int j = 1; j <= 2*i-1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
    
    public static void patternO(int n) {
        // for(int i=1;i<=2*n-1;i++){
        //     int downSpace=(i>n)?(i-n):n-i;
        //     int downStar=(i>n)?((2*n-1)-2*(i-n)):2*i-1;
        //     for(int sp=1;sp<=downSpace;sp++){
        //         System.out.print(" ");
        //     }
        //     for(int j=1;j<=downStar;j++){
        //         System.out.print("*");
        //     }
        //     System.out.println();
        // }

        // since rows 6=4,7=3,8=2,9=1  ==> 2*n-i(if n=5,i=6)  => 10-6=4 Done
        // Approach 2: best
        for(int i=1;i<=2*n-1;i++){
            int row=(i<=n)?i:2*n-i;
            for(int sp=1;sp<=n-row;sp++){
                System.out.print(" ");
            }
            for(int j=1;j<=2*row-1;j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void patternP(int n){
        for(int i=1;i<=2*n;i++){
            int row=(i<=n)?i:2*n-i+1;
            for(int sp=1;sp<row;sp++){
                System.out.print(" ");
            }
            for(int j=1;j<=n-row+1;j++){
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    public static void patternQ(int n){

        // My Approach:
        // for(int i=1;i<=n;i++){
        //     for(int sp=1;sp<=n-i;sp++){
        //         System.out.print(" ");
        //     }
        //     System.out.print("*");
        //     if (i != 1) {
        //         for(int sp=1;sp<=2*i-3;sp++){
        //             if(i==n) 
        //                 System.out.print("*");
        //             else System.out.print(" ");
        //         }
        //         System.out.print("*");
        //     }
        //     System.out.println();
        // }

        // clean Approach
        for(int i=1;i<=n;i++){
            for(int sp=1;sp<=n-i;sp++){
                System.out.print(" ");
            }

            for(int j=1;j<=2*i-1;j++){
                if(j==1 || j==2*i-1 || i==n){
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    } 

    public static void patternR(int n){
        for(int i=n;i>=1;i--){
            for(int sp=1;sp<=n-i;sp++){
                System.out.print(" ");
            }

            for(int j=1;j<=2*i-1;j++){
                if(i==n || j==1 || j==2*i-1){
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    public static void patternS(int n){
        for(int i=1;i<=2*n-1;i++){
            int row=i<=n?i:2*n-i;
            for(int sp=1;sp<=n-row;sp++){
                System.out.print(" ");
            }
            
            for(int j=1;j<=2*row-1;j++){
                if(j==1 || j==2*row-1){
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    public static void patternT(int n){
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n-1;j++){
                if(j==1 || j==n-1 || i==1 || i==n){
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    public static void patternU(int n){
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                if(j==1 || j==n || i==1 || i==n){
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    public static void patternV(int n){

        // Approach 1: Formula based
        // int val=0;
        // for(int i=1;i<=2*n;i++){
        //     int row=(i<=n)?i:2*n-i+1;
        //     for(int j=1;j<=2*n;j++){
        //         if(j>(n-row+1) && j<=((n-row+1)+val)){
        //             System.out.print(" ");
        //         } else {
        //             System.out.print("*");
        //         }
        //     }
        //     System.out.print(" -> val: "+val);
        //     if(i!=n) val=(i<n)?val+2:val-2;
            
        //     System.out.println();
        // }

        // Simple and clean
        for(int i=1;i<=2*n;i++){
            int row=(i<=n)?i:2*n-i+1;
            for(int j=1;j<=n-row+1;j++){
                System.out.print("*");
            }
            for(int sp=1;sp<=2*row-2;sp++){
                System.out.print(" ");
            }

            for(int j=1;j<=n-row+1;j++){
                System.out.print("*");
            };
            System.out.println();
        }
    }

    public static void patternW(int n){
        for(int i=1;i<=2*n;i++){
            int row=(i<=n)?i:2*n-i;
            for(int j=1;j<=row;j++){
                System.out.print("*");
            }
            for(int sp=1;sp<=(2*n)-(2*row);sp++){
                System.out.print(" ");
            }
            for(int j=1;j<=row;j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void patternX(int n){
        for(int i=1;i<=n;i++){
            int val=i;
            for(int sp=1;sp<=n-i;sp++){
                System.out.print("  ");
            }
            for(int j=1;j<=2*i-1;j++){
                System.out.print(val+" ");
                val=(j<i)?val-1:val+1;
            }
            System.out.println();
        }
    }

    public static void patternY(int n){
        for(int i=1;i<=n;i++){
            for(int j=1;j<=i;j++){
                System.out.print(j);
            }
            for(int sp=1;sp<=(2*n)-(2*i);sp++){
                System.out.print(" ");
            }
            for(int j=i;j>=1;j--){
                System.out.print(j);
            }
            System.out.println();
        }
    }

    public static void patternZ(int n){

        // My 2-ptr Approach 
        int val=n;
        int left=1, right=2*n-1;
        for(int i=1;i<=2*n-1;i++){
            // System.out.print("left: "+left+", right: "+right+", val: "+val+"; ");
            int num=n;
            for(int j=1;j<=2*n-1;j++){
                if(j>=left && j<=right) {
                    System.out.print(val+" ");
                } else {
                    // System.out.print("-"+" ");
                    if(j<left) System.out.print(num--+" ");
                    else System.out.print(++num+" ");
                }
            }
            if(i<n) {
                left++; right--; val--;
            } else {
                left--;  right++; val++; 
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {

        try {

            PrintStream fileOut = new PrintStream(
                    new FileOutputStream(".vscode/output.txt"));

            System.setOut(fileOut);

            int[] input = { 3, 4, 10 };

            for (int n : input) {

                System.out.println("\nn=" + n);
                // patternA(n);
                // patternB(n);
                // patternC(n);
                // patternD(n);
                // patternE(n);
                // patternF(n);
                // patternG(n);
                // patternH(n);
                // patternI(n);
                // patternJ(n);

                // whitespace intro
                // patternK(n);
                // patternL(n);
                // patternM(n);
                // patternN(n);
                // patternO(n);
                // patternP(n);
                // patternQ(n);
                // patternR(n);
                // patternS(n);
                // patternT(n);
                // patternU(n);
                // patternV(n);
                // patternW(n);
                // patternX(n);
                // patternY(n);

                // tricky pattern - just give more workload to ur brain
                patternZ(n);

                System.out.println();
                System.out.println(
                        "--------------------------------");

                System.out.flush();
            }

            fileOut.close();

        } catch (IOException e) {

            e.printStackTrace();
        }
    }
}
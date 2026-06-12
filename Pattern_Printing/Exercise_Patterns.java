import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

public class Exercise_Patterns {

    public static void pattern1(int n) {
        int val = 1;
        boolean isEven = n % 2 == 0;
        for (int i = 1; i <= n; i++) {
            int row = (i <= (isEven ? n / 2 : (n + 1) / 2)) ? i : n - i + 1;
            for (int j = 1; j <= row; j++) {
                System.out.print(val - j + 1 + " ");
            }
            // val=val+(i<(n+1)/2? i+1: n);

            val = (i <= n / 2) ? val + row + 1 : val + row - 1;
            if (n % 2 == 0 && i == n / 2)
                val--;
            System.out.println();
        }
    }

    public static void pattern2(int[][] mat) {
        int rowStart = 0, rowEnd = mat.length;
        int colStart = 0, colEnd = mat[0].length;

        while (rowStart < rowEnd && colStart < colEnd) {
            // top row(left to right)
            for (int i = colStart; i < colEnd; i++) {
                System.out.print(mat[rowStart][i] + " "); // [col alone is changing]
            }
            rowStart++;

            // right col(top to bottom)
            for (int i = rowStart; i < rowEnd; i++) {
                System.out.print(mat[i][colEnd - 1] + " "); // [row alone is changing]
            }
            colEnd--;

            // bottom row(right to left)
            for (int i = colEnd - 1; i >= colStart; i--) {
                System.out.print(mat[rowEnd - 1][i] + " "); // [col alone is changing]
            }
            rowEnd--;

            // left row(bottom to top)
            for (int i = rowEnd - 1; i >= rowStart; i--) {
                System.out.print(mat[i][colStart] + " ");
            }
            colStart++;
        }

    }

    public static void pattern3(int n) {
        for (int i = 1; i <= n; i++) {
            for (int sp = 1; sp <= n - i; sp++) {
                System.out.print(" ");
            }
            for (int j = 1; j <= n; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void pattern4(int n) {
        for (int i = 1; i <= n; i++) {
            for (int sp = 1; sp < i; sp++) {
                System.out.print(" ");
            }
            for (int j = 1; j <= n - i - 1; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    public static void pattern5(int n) {
        if (n <= 0)
            return;

        // Look and Say Pattern
        StringBuilder current = new StringBuilder("1");
        System.out.println(current);

        for (int i = 2; i <= n; i++) {
            // Pre-allocate memory to avoid internal array resizing
            StringBuilder next = new StringBuilder(current.length() * 2);

            int left = 0;
            int len = current.length();

            for (int right = 1; right < len; right++) {
                if (current.charAt(right) != current.charAt(right - 1)) {
                    next.append(right - left);
                    next.append(current.charAt(left));
                    left = right;
                }
            }

            // Append the last block of characters
            next.append(len - left);
            next.append(current.charAt(left));

            // Swap the builders, throwing away the old one to the Garbage Collector
            current = next;

            System.out.println(current);
        }
    }

    public static void pattern6(String s) {
        int n = s.length();
        int left = 0, right = n - 1;

        // Approach 1:
        for (int i = 1; i <= n; i++) {
            boolean isIGreat = i <= (n + 1) / 2;
            int row = isIGreat ? i : n - i + 1;

            for (int sp = 1; sp < row; sp++)
                System.out.print(" ");

            System.out.print(s.charAt((isIGreat ? left : right)));

            if (left != right) {
                for (int sp = 1; sp < Math.abs(right - left); sp++)
                    System.out.print(" ");

                System.out.print(s.charAt((isIGreat ? right : left)));
            }
            left++;
            right--;

            System.out.println();
        }

        // // Approach 2:
        // for (int i = 1; i <= n; i++) {
        // int row = (i <= (n + 1) / 2) ? i : n - i + 1;

        // for (int sp = 1; sp < row; sp++)
        // System.out.print(" ");

        // System.out.print(s.charAt(left));

        // if (left != right) {
        // for (int sp = 1; sp < right - left; sp++)
        // System.out.print(" ");

        // System.out.print(s.charAt(right));

        // }
        // if (i < (n + 1) / 2) {
        // left++;
        // right--;
        // } else {
        // left--;
        // right++;
        // }

        // System.out.println();
        // }
    }

    // pascal triangle pattern
    public static void pattern7(int n) {
        for (int i = 1; i <= n; i++) {
            for (int sp = 1; sp <= n - i; sp++) {
                System.out.print(" ");
            }
            int val = 1;
            for (int j = 1; j <= i; j++) {
                System.out.print(val + " ");
                // Imp step for pascal triangle
                val = val * (i - j) / j;
            }
            System.out.println();
        }

    }

    public static void pattern8(int n) {
        // In each row, each ele increase with 4,3,2,1. since starts with 4=n-1
        for (int i = 1; i <= n; i++) {
            int val = i;
            for (int j = 1; j <= i; j++) {
                System.out.print(val + " ");
                val += (n - j);
            }
            System.out.println();
        }
    }

    public static void pattern9(int n) {
        // int val = 1;
        int x = 1;
        for (int i = 0; i < n; i++) {
            int val = x;
            for (int j = 2; j <= n - i + 1; j++) {
                System.out.print(val + " ");
                val += j + i;
            }
            x += i + 1;
            System.out.println();
        }
    }

    public static void pattern10(int n) {
        int val = 1;
        for (int i = 1; i <= 2 * n; i++) {
            int row = (i <= n) ? i : 2 * n - i + 1;
            for (int sp = 1; sp <= n - row; sp++) {
                System.out.print(" ");
            }
            for (int j = 1; j <= row; j++) {
                System.out.print(val - (j - 1) + " ");
            }
            if (i != n) {
                val = (i <= n) ? val + i + 1 : val - row;
            }
            System.out.println();
        }
    }

    public static void pattern11(int n) {
        int prev2 = 0, prev1 = 1;
        int temp;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(prev1 + " ");
                temp = prev1 + prev2;
                prev2 = prev1;
                prev1 = temp;
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        try {

            PrintStream fileOut = new PrintStream(
                    new FileOutputStream(".vscode/output.txt"));

            System.setOut(fileOut);

            int[] input = { 3, 5, 6, 10 };

            for (int n : input) {

                System.out.println("\nn=" + n);

                // pattern1(n);
                // pattern3(n);
                // pattern4(n); -> not solved yet

                // special pattern -> look and say
                // pattern5(n);

                // pattern6("PROGRAM"); // only odd length

                // pascal triangle pattern
                // pattern7(n);

                // pattern8(n);
                pattern9(n);

                // pattern10(n);
                // pattern11(n);

                System.out.println();
                System.out.println(
                        "--------------------------------");

                System.out.flush();
            }

            // special pattern printing, Also it's too important
            // int[][] mat = { { 1, 2, 3, 4, 5 },
            // { 16, 17, 18, 19, 6 },
            // { 15, 24, 25, 20, 7 },
            // { 14, 23, 22, 21, 8 },
            // { 13, 12, 11, 10, 9 },
            // };

            // int[][] mat = { { 1, 2, 3, 4, 5 },
            // { 14, 15, 16, 17, 6 },
            // { 13, 20, 19, 18, 7 },
            // { 12, 11, 10, 9, 8 }
            // };
            // pattern2(mat);

            fileOut.close();

        } catch (IOException e) {

            e.printStackTrace();
        }
    }
}

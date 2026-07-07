class Solution {
    public static int rec(int i, int[][] grid, int x, int sum) {
        if (sum == 0)
            return 1;
        if (sum < 0 || i < 0)
            return 0;
        int nt = rec(i - 1, grid, x, sum);
        int t = 0;
        if (sum - grid[i][1] >= 0) {
            t = rec(i - 1, grid, x, sum - grid[i][1]);
        }
        return Math.min(nt, t);
    }

    public static int knap(int[][] grid, int x, int y) {
        return rec(grid.length - 1, grid, x, y);
    }

    public static void main(String[] args) {
        int[][] g = { { 10, 5, 20 }, { 3, 2, 6 }, { 4, 3, 7 } };
        int x = 9, y = 5;
        System.out.println(knap(g, x, y));

    }
}
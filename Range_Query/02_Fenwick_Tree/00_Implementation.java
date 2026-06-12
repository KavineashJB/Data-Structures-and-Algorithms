import java.util.Arrays;

class FenwickTree {
    private static int[] fen;
    private static int n;

    private static void update(int i, int add) {
        while (i <= n) {
            fen[i] += add;
            i = i + (i & (-i));
        }
    }

    private static int sum(int i) {
        int s = 0;
        while (i > 0) {
            s += fen[i];
            i = i - (i & (-i));
        }
        return s;
    }

    private static int querySum(int l, int r) {
        return sum(r) - sum(l - 1);
    }

    public static void main(String[] args) {
        n = 7;
        int[] arr = { 1, 0, 2, 1, 3, 0, 4 };
        fen = new int[n + 1];

        for (int i = 0; i < n; i++) {
            update(i + 1, arr[i]);
        }
        System.out.println(Arrays.toString(fen));

        System.out.println(querySum(0, 7));
        System.out.println(querySum(4, 6));
        System.out.println(querySum(1, 5));
        update(2, 5);
        System.out.println(Arrays.toString(fen));
        System.out.println(querySum(0, 7));
    }
}
import java.util.Arrays;

class Flipping_Sign {
    private static int[] sgt;
    private static int[] lazy;

    private static void build(int s, int e, int ind, int[] arr) {
        if (s == e) {
            sgt[ind] = arr[s];
            return;
        }
        int m = s + (e - s) / 2;
        build(s, m, 2 * ind, arr);
        build(m + 1, e, 2 * ind + 1, arr);

        sgt[ind] = sgt[2 * ind] + sgt[2 * ind + 1];
    }

    private static void updateRange(int s, int e, int ind, int updateIndStart, int updateIndEnd) {
        if (lazy[ind] != 0) {
            sgt[ind] = -sgt[ind];
            if (s != e) {
                lazy[2 * ind] ^= 1;
                lazy[2 * ind + 1] ^= 1;
            }
            lazy[ind] = 0;
        }

        if (s > updateIndEnd || e < updateIndStart)
            return;
        else if (s >= updateIndStart && e <= updateIndEnd) {
            sgt[ind] = -sgt[ind];
            if (s != e) {
                lazy[2 * ind] ^= 1;
                lazy[2 * ind + 1] ^= 1;
            }
            return;
        }

        int mid = s + (e - s) / 2;
        updateRange(s, mid, 2 * ind, updateIndStart, updateIndEnd);
        updateRange(mid + 1, e, 2 * ind + 1, updateIndStart, updateIndEnd);
        sgt[ind] = sgt[2 * ind] + sgt[2 * ind + 1];
    }

    public static int query(int s, int e, int ind, int left, int right) {
        if (lazy[ind] != 0) {
            sgt[ind] = sgt[ind];
            if (s != e) {
                lazy[2 * ind] ^= 1;
                lazy[2 * ind + 1] ^= 1;
            }
            lazy[ind] = 0;
        }

        if (s > right || e < left)
            return 0;
        else if (s >= left && e <= right)
            return sgt[ind];
        int mid = s + (e - s) / 2;
        int leftVal = query(s, mid, 2 * ind, left, right);
        int rightVal = query(mid + 1, e, 2 * ind + 1, left, right);
        return leftVal + rightVal;
    }

    public static void main(String[] args) {
        // Input : arr[] = { 1, 2, 3, 4, 5 }
        // update(0, 2) - { -1, -2, -3, 4, 5 }
        // update(2, 4) - { -1, -2, 3, -4, -5 }
        // query(0, 4)
        // Output: 3
        // After applying update operation array becomes { -1, -2, 3, 4, 5 } .
        // So the sum is -9

        int arr[] = { 1, 2, 3, 4, 5 };
        int n = 5;
        sgt = new int[4 * n];
        lazy = new int[4 * n];

        build(0, n - 1, 1, arr);

        updateRange(0, n - 1, 1, 0, 2);
        updateRange(0, n - 1, 1, 2, 4);

        int res = query(0, n - 1, 1, 0, 4);
        System.out.println(res);
    }
}
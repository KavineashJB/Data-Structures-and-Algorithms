import java.util.*;
import java.io.*;

class Segment_Tree {
    private static int[] sgt = new int[1000];

    public static void build(int start, int end, int index, int[] arr) {
        if (start == end) {
            sgt[index] = arr[start];
            return;
        }

        int mid = start + (end - start) / 2;
        build(start, mid, 2 * index, arr);
        build(mid + 1, end, 2 * index + 1, arr);

        sgt[index] = sgt[2 * index] + sgt[2 * index + 1];
    }

    public static void update(int start, int end, int index, int updateIndex, int updateValue) {
        if (start == end) {
            sgt[index] = updateValue;
            return;
        }

        int mid = start + (end - start) / 2;
        if (updateIndex <= mid) {
            update(start, mid, 2 * index, updateIndex, updateValue);
        } else if (updateIndex > mid) {
            update(mid + 1, end, 2 * index + 1, updateIndex, updateValue);
        }

        sgt[index] = sgt[2 * index] + sgt[2 * index + 1];
    }

    public static int query(int start, int end, int index, int left, int right) {
        // no overlap
        if (start > right || end < left)
            return 0;

        // full overlap
        if (start >= left && end <= right)
            return sgt[index];

        // partial overlap
        int mid = start + (end - start) / 2;
        int leftValue = query(start, mid, 2 * index, left, right);
        int rightValue = query(mid + 1, end, 2 * index + 1, left, right);
        return leftValue + rightValue;

    }

    // Segment Tree is used when query result with updating original array
    // If just asking freq query res then use Difference Array
    public static void main(String[] args) throws Exception {

        File inputFile = new File("../.vscode/input.txt");
        Scanner sc = new Scanner(inputFile);

        FileWriter fw = new FileWriter("../.vscode/output.txt");

        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        build(0, n - 1, 1, arr);

        int tcs = sc.nextInt();
        while (tcs-- != 0) {
            int ch = sc.nextInt();

            // 1 - update the array element
            // 2 - return query result
            if (ch == 1) {
                update(0, n - 1, 1, sc.nextInt(), sc.nextInt());
                continue;
            }

            int res = query(0, n - 1, 1, sc.nextInt(), sc.nextInt());
            fw.write(String.valueOf(res) + "\n");
        }

        sc.close();
        fw.close();
    }

}
import java.util.*;
import java.io.*;

class Segment_Tree {
    private static int[] sgt;
    private static int[] lazy;

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
        // 1. CRITICAL: Clear/push down lazy values first!
        // Even for a point update, this node or its children might have pending 
        // range updates from a previous operation. We must resolve them first.

        if (lazy[index] != 0) {
        sgt[index] += (end - start + 1) * lazy[index];
        if (start != end) {
            lazy[2 * index] += lazy[index];
            lazy[2 * index + 1] += lazy[index];
        }
        lazy[index] = 0;
    }
    
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

    // lazy propagation - optimization of range updates
    // for normal sgt, range update takes O(N*logN) for single range update. For multiple range update it may be large
    // but for lazy propagation - takes O(logN) for every range updates
    public static void updateRange(int start, int end, int index, int updateIndexStart, int updateIndexEnd, int updateValue) {
        if (lazy[index] != 0) {
            sgt[index] += (end - start + 1) * lazy[index];
            if (start != end) {
                lazy[2 * index] += lazy[index];
                lazy[2 * index + 1] += lazy[index];
            }
            lazy[index] = 0;
        }
        if (start > updateIndexEnd || end < updateIndexStart)
            return;
        else if (start >= updateIndexStart && end <= updateIndexEnd) {
            sgt[index] += (end - start + 1) * updateValue;
            if (start != end) {
                lazy[2 * index] += updateValue;
                lazy[2 * index + 1] += updateValue;
            }
            return;
        }
        int mid = start + (end - start) / 2;
        updateRange(start, mid, 2 * index, updateIndexStart, updateIndexEnd, updateValue);
        updateRange(mid + 1, end, 2 * index + 1, updateIndexStart, updateIndexEnd, updateValue);

        sgt[index] = sgt[2 * index] + sgt[2 * index + 1];
    }

    public static int query(int start, int end, int index, int left, int right) {

        // lazy propagation query
        if (lazy[index] != 0) {
            sgt[index] += (end - start + 1) * lazy[index];
            if (start != end) {
                lazy[2 * index] += lazy[index];
                lazy[2 * index + 1] += lazy[index];
            }
            lazy[index] = 0;
        }
        // no overlap
        if (start > right || end < left)
            return 0;

        // full overlap
        if (start >= left && end <= right) // start >= left && end <= right)
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

        File inputFile = new File(".vscode/input.txt");
        // System.out.println(inputFile.getAbsolutePath());
        // System.out.println(inputFile.exists());
        Scanner sc = new Scanner(inputFile);

        FileWriter fw = new FileWriter(".vscode/output.txt");

        int n = sc.nextInt();
        sgt = new int[4 * n];
        lazy = new int[4 * n];
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        build(0, n - 1, 1, arr);

        int tcs = sc.nextInt();
        while (tcs-- != 0) {
            int ch = sc.nextInt();

            // 1 - return query result
            // 2 - update the array element
            // 3 - Range update
            if (ch == 2) {
                update(0, n - 1, 1, sc.nextInt(), sc.nextInt());
                continue;
            }
            if(ch == 3){
                updateRange(0, n-1, 1, sc.nextInt(), sc.nextInt(), sc.nextInt());
                continue;
            }

            int res = query(0, n - 1, 1, sc.nextInt(), sc.nextInt());
            fw.write(String.valueOf(res) + "\n");
        }

        sc.close();
        fw.close();
    }

}
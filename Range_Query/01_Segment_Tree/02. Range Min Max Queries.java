// Range Min Max Queries

// You are given an array of integers of size N and Q queries.

// Your task is to complete the following functions:

// getMinMax(L,R): return the minimum and maximum in the given range [L,R]
// updateValue(index,value): update arr[index] to value.

// Note: 0-based indexing is used.

// Examples:

// Input: N = 6, Q = 3
// arr[] = [11, 3, 7, 5, 9, 1]
// queries = getMinMax(0,2)
// updateValue(3,17)
// getMinMax(0,5)
// Output:
// 3 11
// 1 17
// Explanation: There are 3 queries:
// Query 1 : Min(0, 1, 2) = 3,
// Max(0, 1, 2) = 11
// Query 2 : 5 changes to 17, arr[] = [11, 3, 7, 17, 9, 1]
// Query 3 : Min(0, 1, 2, 3, 4, 5) = 1,
// Max(0, 1, 2, 3, 4, 5) = 17.

// Input: N = 5, Q = 1
// arr = [3, 1, 1, 2, 5]
// queries = getMinMax(0, 4)
// Output: 1 5
// Explanation: There is 1 query:
// Query 1 : Min(0, 1, 2, 3, 4) = 1,
// Max(0, 1, 2, 3, 4) = 5.

// Constraints:
// 1 ≤ N, Q ≤ 105
// 0 ≤ L ≤ R, index < N
// 1 ≤ arr[i], value ≤ 105

// Problem Link: https://www.geeksforgeeks.org/problems/range-min-max-queries4557/1
class Solution {
    // Returns a vector<int> of size 2 where:
    // [0] = minimum value in arr from index L to R (inclusive),
    // [1] = maximum value in arr from index L to R (inclusive).
    // Uses the prebuilt segTree where each node stores [min, max].
    // Segment tree indexing:
    // - For a node at idx, left child is at 2*idx + 1, right child at 2*idx + 2.
    public int[] helperGetMinMax(int s, int e, int ind, int left, int right, int[][] segTree) {
        // no overlap
        if (s > right || e < left) {
            return new int[] { Integer.MAX_VALUE, Integer.MIN_VALUE };
        }
        // full overlap
        else if (s >= left && e <= right) {
            return segTree[ind];
        }
        // partial overlap
        else {
            int m = s + (e - s) / 2;
            int[] leftArr = helperGetMinMax(s, m, 2 * ind + 1, left, right, segTree);
            int[] rightArr = helperGetMinMax(m + 1, e, 2 * ind + 2, left, right, segTree);
            return new int[] {
                    Math.min(leftArr[0], rightArr[0]),
                    Math.max(leftArr[1], rightArr[1])
            };
        }
    }

    public int[] getMinMax(int[] arr, int L, int R, int[][] segTree) {
        int n = arr.length;
        return helperGetMinMax(0, n - 1, 0, L, R, segTree);
    }

    // Updates the value at arr[index] to 'value' and updates the segTree
    // accordingly.
    // Uses the prebuilt segTree where each node stores [min, max].
    // Segment tree indexing:
    // - For a node at idx, left child is at 2*idx + 1, right child at 2*idx + 2.

    public void helperUpdateValue(int s, int e, int ind, int updateInd, int updateVal, int[][] segTree) {
        if (s == e) {
            segTree[ind][0] = updateVal;
            segTree[ind][1] = updateVal;
            return;
        }
        int m = s + (e - s) / 2;
        if (updateInd <= m) {
            helperUpdateValue(s, m, 2 * ind + 1, updateInd, updateVal, segTree);
        } else {
            helperUpdateValue(m + 1, e, 2 * ind + 2, updateInd, updateVal, segTree);
        }

        int mini = Math.min(segTree[2 * ind + 1][0], segTree[2 * ind + 2][0]);
        int maxi = Math.max(segTree[2 * ind + 1][1], segTree[2 * ind + 2][1]);
        segTree[ind][0] = mini;
        segTree[ind][1] = maxi;
    }

    public void updateValue(int[] arr, int index, int value, int[][] segTree) {
        int n = arr.length;
        helperUpdateValue(0, n - 1, 0, index, value, segTree);
    }
};
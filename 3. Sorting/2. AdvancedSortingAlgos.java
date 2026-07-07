import java.util.*;

class AdvancedSortingAlgos {
    public static void reIntialize(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            arr[i] = n - i;
        }
    }

    public static void MergeSort(int left, int right, int[] arr) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            MergeSort(left, mid, arr);
            MergeSort(mid + 1, right, arr);
            Merge(left, mid, right, arr);
        }
    }

    public static void Merge(int left, int mid, int right, int[] arr) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        int[] l = new int[n1];
        int[] r = new int[n2];
        for (int i = 0; i < n1; i++)
            l[i] = arr[left + i];
        for (int i = 0; i < n2; i++)
            r[i] = arr[mid + 1 + i];

        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            if (l[i] < r[j]) {
                arr[k++] = l[i++];
            } else {
                arr[k++] = r[j++];
            }
        }

        while (i < n1)
            arr[k++] = l[i++];
        while (j < n2)
            arr[k++] = r[j++];
    }

    public static void QuickSort(int[] arr) {

    }

    public static void main(String[] args) {
        int arr[] = { 5, 4, 3, 2, 1 };
        System.out.println("Before Sorting: " + Arrays.toString(arr) + "\n");
        MergeSort(0, 4, arr);
        System.out.println("Merge Sorting:     " + Arrays.toString(arr));
        reIntialize(arr);

        QuickSort(arr);
        reIntialize(arr);

    }
}

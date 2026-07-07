import java.util.*;

class BasicSortingAlgos {
    public static void reIntialize(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            arr[i] = n - i;
        }
    }

    public static void swap(int a, int b, int[] arr) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public static void BubbleSort(int[] arr) {
        // Bubble sort compares the adjacent elements
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            boolean isSorted = true;
            for (int j = 1; j < n; j++) {
                if (arr[j - 1] > arr[j]) {
                    isSorted = false;
                    swap(j - 1, j, arr);
                }
            }
            if (isSorted)
                break;
        }
        System.out.println("Bubble Sorting:     " + Arrays.toString(arr));
    }

    public static void InsertionSort(int[] arr) {
        // insertion sort insert the ele into correct place previous to it
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
        System.out.println("Insertion Sorting:  " + Arrays.toString(arr));
    }

    public static void selectionSort(int[] arr) {
        // select min ele and move left
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int minInd = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minInd]) {
                    minInd = j;
                }
            }
            swap(i, minInd, arr);
        }
        System.out.println("Selection Sorting:  " + Arrays.toString(arr));
    }

    public static void main(String[] args) {
        int arr[] = { 5, 4, 3, 2, 1 };
        System.out.println("Before Sorting: " + Arrays.toString(arr) + "\n");
        BubbleSort(arr);
        reIntialize(arr);

        InsertionSort(arr);
        reIntialize(arr);

        selectionSort(arr);
        reIntialize(arr);
    }
}

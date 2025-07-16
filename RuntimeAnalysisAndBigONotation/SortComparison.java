package RuntimeAnalysisAndBigONotation;
import java.util.Arrays;
import java.util.Random;

public class SortComparison {

    // Bubble Sort (inefficient for large data)
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++)
            for (int j = 0; j < n - i - 1; j++)
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
    }

    // Merge Sort
    public static void mergeSort(int[] arr) {
        if (arr.length < 2) return;
        int mid = arr.length / 2;
        int[] left = Arrays.copyOfRange(arr, 0, mid);
        int[] right = Arrays.copyOfRange(arr, mid, arr.length);

        mergeSort(left);
        mergeSort(right);
        merge(arr, left, right);
    }

    private static void merge(int[] arr, int[] left, int[] right) {
        int i = 0, j = 0, k = 0;
        while (i < left.length && j < right.length)
            arr[k++] = (left[i] < right[j]) ? left[i++] : right[j++];
        while (i < left.length) arr[k++] = left[i++];
        while (j < right.length) arr[k++] = right[j++];
    }

    // Quick Sort
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high], i = low - 1;
        for (int j = low; j < high; j++)
            if (arr[j] < pivot)
                swap(arr, ++i, j);
        swap(arr, i + 1, high);
        return i + 1;
    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i]; arr[i] = arr[j]; arr[j] = tmp;
    }

    public static void main(String[] args) {
        int size = 10_000; // Change to 1000 or 1_000_000 as needed
        Random rand = new Random();

        int[] original = new int[size];
        for (int i = 0; i < size; i++) original[i] = rand.nextInt(size);

        int[] arr1 = Arrays.copyOf(original, size);
        int[] arr2 = Arrays.copyOf(original, size);
        int[] arr3 = Arrays.copyOf(original, size);

        long start, time;

        start = System.nanoTime();
        bubbleSort(arr1);
        time = System.nanoTime() - start;
        System.out.println("Bubble Sort Time: " + time / 1_000_000.0 + " ms");

        start = System.nanoTime();
        mergeSort(arr2);
        time = System.nanoTime() - start;
        System.out.println("Merge Sort Time: " + time / 1_000_000.0 + " ms");

        start = System.nanoTime();
        quickSort(arr3, 0, arr3.length - 1);
        time = System.nanoTime() - start;
        System.out.println("Quick Sort Time: " + time / 1_000_000.0 + " ms");
    }
}

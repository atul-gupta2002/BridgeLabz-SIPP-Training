package RuntimeAnalysisAndBigONotation;
import java.util.Arrays;

public class SearchComparison {

    public static int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++)
            if (arr[i] == target)
                return i;
        return -1;
    }

    public static int binarySearch(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] == target) return mid;
            else if (arr[mid] < target) left = mid + 1;
            else right = mid - 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        int size = 1_000_000;
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) arr[i] = i;

        int target = size - 1;

        long start = System.nanoTime();
        int linearIndex = linearSearch(arr, target);
        long linearTime = System.nanoTime() - start;

        Arrays.sort(arr); // ensure sorted for binary search
        start = System.nanoTime();
        int binaryIndex = binarySearch(arr, target);
        long binaryTime = System.nanoTime() - start;

        System.out.println("Linear Search Index: " + linearIndex + ", Time: " + linearTime / 1_000_000.0 + " ms");
        System.out.println("Binary Search Index: " + binaryIndex + ", Time: " + binaryTime / 1_000_000.0 + " ms");
    }
}

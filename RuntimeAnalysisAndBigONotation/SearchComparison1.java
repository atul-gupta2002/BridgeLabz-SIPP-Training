package RuntimeAnalysisAndBigONotation;
import java.util.*;

public class SearchComparison1{
    public static void main(String[] args) {
        int N = 1_000_000;
        int[] array = new int[N];
        HashSet<Integer> hashSet = new HashSet<>();
        TreeSet<Integer> treeSet = new TreeSet<>();

        // Fill all data structures with numbers from 0 to N-1
        for (int i = 0; i < N; i++) {
            array[i] = i;
            hashSet.add(i);
            treeSet.add(i);
        }

        int target = N - 1; // Last element

        // Linear Search in Array
        long start = System.nanoTime();
        boolean foundInArray = false;
        for (int num : array) {
            if (num == target) {
                foundInArray = true;
                break;
            }
        }
        long end = System.nanoTime();
        System.out.println("Array Search (O(N)): " + (end - start) / 1_000_000.0 + " ms");

        // Search in HashSet
        start = System.nanoTime();
        boolean foundInHashSet = hashSet.contains(target);
        end = System.nanoTime();
        System.out.println("HashSet Search (O(1)): " + (end - start) / 1_000_000.0 + " ms");

        // Search in TreeSet
        start = System.nanoTime();
        boolean foundInTreeSet = treeSet.contains(target);
        end = System.nanoTime();
        System.out.println("TreeSet Search (O(log N)): " + (end - start) / 1_000_000.0 + " ms");
    }
}

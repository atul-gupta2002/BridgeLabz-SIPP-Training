package RuntimeAnalysisAndBigONotation;
public class FibonacciComparison {

    // Recursive Fibonacci (Exponential Time)
    public static int fibonacciRecursive(int n) {
        if (n <= 1) return n;
        return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
    }

    // Iterative Fibonacci (Linear Time)
    public static int fibonacciIterative(int n) {
        if (n <= 1) return n;
        int a = 0, b = 1, sum = 0;
        for (int i = 2; i <= n; i++) {
            sum = a + b;
            a = b;
            b = sum;
        }
        return b;
    }

    public static void main(String[] args) {
        int n = 30; // You can change this to test performance difference

        // Recursive
        long startRecursive = System.nanoTime();
        int recResult = fibonacciRecursive(n);
        long endRecursive = System.nanoTime();
        System.out.println("Recursive Fibonacci(" + n + ") = " + recResult);
        System.out.println("Recursive Time: " + (endRecursive - startRecursive) / 1_000_000.0 + " ms");

        // Iterative
        long startIterative = System.nanoTime();
        int iterResult = fibonacciIterative(n);
        long endIterative = System.nanoTime();
        System.out.println("Iterative Fibonacci(" + n + ") = " + iterResult);
        System.out.println("Iterative Time: " + (endIterative - startIterative) / 1_000_000.0 + " ms");
    }
}

package RuntimeAnalysisAndBigONotation;
public class StringConcatPerformance {

    public static void main(String[] args) {
        int N = 100_000; // Try with 1_000_000 if your system supports

        // 1. String (Inefficient)
        long start = System.nanoTime();
        String str = "";
        for (int i = 0; i < N; i++) {
            str += "a";
        }
        long timeString = System.nanoTime() - start;
        System.out.println("String Time: " + timeString / 1_000_000.0 + " ms");

        // 2. StringBuilder (Efficient)
        start = System.nanoTime();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append("a");
        }
        long timeBuilder = System.nanoTime() - start;
        System.out.println("StringBuilder Time: " + timeBuilder / 1_000_000.0 + " ms");

        // 3. StringBuffer (Thread-safe, slower than StringBuilder)
        start = System.nanoTime();
        StringBuffer sbf = new StringBuffer();
        for (int i = 0; i < N; i++) {
            sbf.append("a");
        }
        long timeBuffer = System.nanoTime() - start;
        System.out.println("StringBuffer Time: " + timeBuffer / 1_000_000.0 + " ms");
    }
}


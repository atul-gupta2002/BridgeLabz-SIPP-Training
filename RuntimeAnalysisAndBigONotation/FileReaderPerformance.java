package RuntimeAnalysisAndBigONotation;
import java.io.*;

public class FileReaderPerformance {
    public static void main(String[] args) {
        long startTime = System.nanoTime();

        try (BufferedReader reader = new BufferedReader(new FileReader("largefile.txt"))) {
            while (reader.readLine() != null) {
                // Reading line by line
            }
        } catch (IOException e) {
            System.out.println("FileReader Error: " + e.getMessage());
            return;
        }

        long endTime = System.nanoTime();
        System.out.println("FileReader Time: " + (endTime - startTime) / 1_000_000.0 + " ms");
    }
}

package RuntimeAnalysisAndBigONotation;
import java.io.*;

public class LargeFileReadingComparison {

    public static void readUsingFileReader(String filePath) {
        try (FileReader reader = new FileReader(filePath);
             BufferedReader br = new BufferedReader(reader)) {

            long start = System.nanoTime();
            while (br.readLine() != null) {
                // Just read, no output for performance
            }
            long end = System.nanoTime();
            System.out.println("Time using FileReader: " + (end - start) / 1_000_000 + " ms");

        } catch (IOException e) {
            System.out.println("Error reading using FileReader: " + e.getMessage());
        }
    }

    public static void readUsingInputStreamReader(String filePath) {
        try (FileInputStream fis = new FileInputStream(filePath);
             InputStreamReader isr = new InputStreamReader(fis);
             BufferedReader br = new BufferedReader(isr)) {

            long start = System.nanoTime();
            while (br.readLine() != null) {
                // Just read, no output for performance
            }
            long end = System.nanoTime();
            System.out.println("Time using InputStreamReader: " + (end - start) / 1_000_000 + " ms");

        } catch (IOException e) {
            System.out.println("Error reading using InputStreamReader: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        String filePath = "largefile.txt"; // Ensure this file exists

        System.out.println("Reading file using FileReader...");
        readUsingFileReader(filePath);

        System.out.println("Reading file using InputStreamReader...");
        readUsingInputStreamReader(filePath);
    }
}

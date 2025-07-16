package RuntimeAnalysisAndBigONotation;
import java.io.*;

public class CreateLargeFile {
    public static void main(String[] args) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("largefile.txt"))) {
            for (int i = 0; i < 1000000; i++) {
                writer.write("This is line number " + i + "\n");
            }
            System.out.println("largefile.txt created successfully!");
        } catch (IOException e) {
            System.out.println(" Error creating file: " + e.getMessage());
        }
    }
}

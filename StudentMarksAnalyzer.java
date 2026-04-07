

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.IntStream;

public class StudentMarksAnalyzer {

    public static void main(String[] args) {

        try (IntStream marks = Files.lines(Paths.get("StreamAPI2/marks.txt"))
                                   .mapToInt(Integer::parseInt)) {

            int[] arr = marks.toArray();

            int total = IntStream.of(arr).sum();
            double average = IntStream.of(arr).average().orElse(0);
            int highest = IntStream.of(arr).max().orElse(0);

            System.out.println("Total Marks: " + total);
            System.out.println("Average Marks: " + average);
            System.out.println("Highest Mark: " + highest);

        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}
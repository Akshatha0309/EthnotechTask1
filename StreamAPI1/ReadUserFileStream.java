import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;
import java.util.stream.Stream;

public class ReadUserFileStream {

    public static void main(String[] args) {

        try (Stream<String> lines = Files.lines(Paths.get("user.txt"))) {
            lines.forEach(System.out::println);
        } 
        catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}
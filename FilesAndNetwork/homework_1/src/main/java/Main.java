import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.IllegalFormatException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        long sizeOfDirectory = 0;
        String input;

        while (true) {
            input = getInput("Введите путь: ");
            if (!Files.isDirectory(Paths.get(input))) {
                throw new IllegalArgumentException("Несуществующий путь");
            }
            try {
                sizeOfDirectory = FileUtils.calculateFolderSize(input);
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }

            System.out.println(FileUtils.formatSize(sizeOfDirectory));


        }

    }

    private static String getInput (String message) {
        System.out.println(message);
        String input = new Scanner(System.in).nextLine();
        return input;
    }
}

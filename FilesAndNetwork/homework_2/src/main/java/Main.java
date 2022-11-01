import java.awt.geom.IllegalPathStateException;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        while (true) {
            String sourceDirectory = "";
            String destinationDirectory = "";
            try {
                sourceDirectory = takeInput("Введите путь до копируемой папки: ");
                destinationDirectory = takeInput("Введите путь до папки, в которую требуется скопировать: ");

            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }

            try {
                FileUtils.copyFolder(sourceDirectory, destinationDirectory);
                System.out.println("Готово!");
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    public static String takeInput(String message) {
        System.out.println(message);
        String input = new Scanner(System.in).nextLine();
        if(!Files.isDirectory(Path.of(input))) {
            throw new IllegalPathStateException("Неверно указан путь");
        }
        return input;
    }
}

import java.io.*;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;

public class FileUtils {




    private static void copyDirectory(File sourceDirectory, File destinationDirectory) throws IOException {
        if (!destinationDirectory.exists()) {
            destinationDirectory.mkdir();
        }
        for (String file : sourceDirectory.list()) {
            copyFolder((new File(sourceDirectory, file)).getPath(), (new File(destinationDirectory, file)).getPath());
        }
    }

    public static void copyFolder(String sourceDirectory, String destinationDirectory) throws IOException {
        if (new File(sourceDirectory).isDirectory()) {
            copyDirectory(new File(sourceDirectory), new File(destinationDirectory));
        } else {
            copyFile(new File(sourceDirectory), new File(destinationDirectory));
        }
    }

    private static void copyFile(File sourceFile, File destinationFile)
            throws IOException {
        Files.copy(sourceFile.toPath(), destinationFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
    }

}

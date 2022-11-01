import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.TreeSet;
import java.util.concurrent.atomic.AtomicLong;

public class FileUtils {

    public static long calculateFolderSize(String path) {
        long size = 0;
        File file = new File(path);
        TreeSet<File> files = new TreeSet<>(List.of(file.listFiles()));

        for (File file1 : files) {
            try {

                size += Files.size(Path.of(file1.getPath()));
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }
        return size;
    }

    public static String formatSize(long size) {
        String kByte = " КБ";
        String mByte = " МБ";
        String gByte = " ГБ";
        String tByte = " ТБ";
        String output = "";
        Double sizeOfDouble = Double.valueOf(size);
        for (int i = 0; i<= 3; i++) {
            sizeOfDouble = sizeOfDouble / 1000;
            if (sizeOfDouble < 1) {
                sizeOfDouble = sizeOfDouble * 1_000_000;
                size = Math.round(sizeOfDouble);
                sizeOfDouble = Double.valueOf(size / 1000);
                output += sizeOfDouble;
                if (i == 0) {
                    output += kByte;
                }

                if (i == 1) {
                    output += mByte;
                }

                if (i == 2) {
                    output += gByte;
                }

                if (i == 3) {
                    output += tByte;
                }

                break;
            }
        }

        return output;
    }
}

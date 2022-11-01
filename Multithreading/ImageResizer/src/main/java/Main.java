import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;

public class Main {

    private static final int CORES_COUNT = Runtime.getRuntime().availableProcessors();
    private static final int NEW_WIDTH = 300;

    public static void main(String[] args) {

        String srcFolder = "data/src";
        String dstFolder = "data/dst";

        File srcDir = new File(srcFolder);

        long start = System.currentTimeMillis();

        File[] files = srcDir.listFiles();

        int endFile = Math.round(Float.parseFloat(String.valueOf(files.length)) / Float.parseFloat(String.valueOf(CORES_COUNT)));

        for (int i = 0; i < CORES_COUNT; i++) {

            File[] filesShort;

            if (i == CORES_COUNT - 1) {
                int lastEndFile = files.length - (endFile * i);
                filesShort = new File[lastEndFile];
            } else {
                filesShort = new File[endFile];
            }

            int fileNumber = i * endFile;

            System.arraycopy(files, fileNumber, filesShort, 0, filesShort.length);

            ImageResizer resizer = new ImageResizer(filesShort, NEW_WIDTH, dstFolder);
            new Thread(resizer).start();


        }


        System.out.println("Duration: " + (System.currentTimeMillis() - start));
    }
}

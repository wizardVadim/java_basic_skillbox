import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Loader implements Runnable {
    public Loader(int region) {
        this.region = region;
    }

    private int region;

    private final static int MAX_REGION = 100;
    private final static int MAX_NUMBER = 1000;

    private static long start;

    private final static char LETTERS[] = {'У', 'К', 'Е', 'Н', 'Х', 'В', 'А', 'Р', 'О', 'С', 'М', 'Т'};

    public static void main(String[] args) throws Exception {
        start = System.currentTimeMillis();
        List<Thread> threads = new ArrayList<>();

        for (int regionCode = 1; regionCode < MAX_REGION; regionCode++) {
            Thread thread = new Thread(new Loader(regionCode));
            threads.add(thread);
            thread.start();
        }

        for (Thread thread : threads) {
            thread.join();
        }

        System.out.println((System.currentTimeMillis() - start) + " ms");

    }

    private static String padNumber(int number, int numberLength) {
        StringBuffer numberStr = new StringBuffer();
//        String numberStr = Integer.toString(number);
        int padSize = numberLength - Integer.toString(number).length();

        for (int i = 0; i < padSize; i++) {
            numberStr.append("0");
        }

        numberStr.append(number);
//        for (int i = 0; i < padSize; i++) {
//            numberStr = '0' + numberStr;
//        }
//        return numberStr;
        return numberStr.toString();
    }

    @Override
    public void run() {

        FileOutputStream writer = null;
        try {
            writer = new FileOutputStream("res/RegionCode" + Integer.toString(region) + ".txt");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        StringBuffer carNumber = new StringBuffer();
            for (int number = 1; number < MAX_NUMBER; number++) {
                for (char firstLetter : LETTERS) {
                    for (char secondLetter : LETTERS) {
                        for (char thirdLetter : LETTERS) {
                            carNumber.append(firstLetter);
                            carNumber.append(padNumber(number, 3));
                            carNumber.append(secondLetter);
                            carNumber.append(thirdLetter);
                            carNumber.append(padNumber(region, 2));
                            carNumber.append("\n");
                        }
                    }
                }
            }

        try {
            writer.write(carNumber.toString().getBytes());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try {
            writer.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}

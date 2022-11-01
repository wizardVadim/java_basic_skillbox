
import org.jsoup.Jsoup;

import java.util.ArrayList;
import java.util.concurrent.ForkJoinPool;

public class Main {

    public static final String URL = "https://skillbox.ru/";

    public static void main(String[] args) {

        MapParser parser = new MapParser(URL);

        ForkJoinPool forkJoinPool = new ForkJoinPool();

        forkJoinPool.invoke(parser);

        parser.writeToFile(parser.getFinalBranches());
    }
}

import org.jsoup.Jsoup;
import org.jsoup.internal.StringUtil;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.RecursiveAction;

public class MapParser extends RecursiveAction {

    private static HashSet<String> usedURL = new HashSet<>();

    public MapParser(String url) {
        this.url = url;
    }

    private String url;

    private static List<String> finalBranches = new ArrayList<>();

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public static List<String> getFinalBranches() {
        return finalBranches;
    }

    public ArrayList<String> getBranchList(String url) {

        usedURL.add(url);

        Set<String> urlList = new HashSet<>();

        Document doc = null;

        ArrayList<String> branchList = new ArrayList<>();

        try {

            doc = Jsoup.connect(url).get();

        } catch (Exception e) {

            System.out.println(e.getMessage());

        }
        
        Elements elements = null;

        try {

        if (isEndUrl(doc)) {

            finalBranches.add(url);

        } else {

            elements = doc.getElementsByAttribute("href");


            String regex1 = "[/][A-z0-9._/-]+";

            elements.stream().filter(element -> element.attr("href").contains(url)
                            || element.attr("href").matches(regex1))
                    .forEach(element -> urlList.add(element.attr("href")));

            urlList.remove(url);
            HashSet<String> newUrlList = new HashSet<>();
            urlList.stream().filter(u -> !usedURL.contains(u)).forEach(u -> newUrlList.add(u));

            for (String url1 : newUrlList) {

                String newUrl = null;

                if (url1.indexOf('/') == 0) {

                    int end = Main.URL.lastIndexOf("/");

                    newUrl = Main.URL.substring(0, end) + url1;

                    branchList.add(newUrl);

                    usedURL.add(url1);


                } else {

                    branchList.add(url1);

                }
            }
        }

        } catch (Exception ex) {

            System.out.println(ex.getMessage());

        }

        if (branchList.isEmpty()) {
           finalBranches.add(url);
        }

        return branchList;

    }

    protected boolean isEndUrl (Document doc) throws IOException {
        if (doc.attr("href") == null
                || doc == null) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    protected void compute() {
        ArrayList<MapParser> parsers = new ArrayList<>();

        try {
            Thread.sleep(150);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        getBranchList(url).stream().filter(u -> !finalBranches.contains(u)).forEach(u -> parsers.add(new MapParser(u)));

        System.out.print(".");

        invokeAll(parsers);

    }

    public void writeToFile (List<String> strings) {

        FileWriter writer = null;

        try {
            writer = new FileWriter(new File("txt/map.txt"));

            String map = "";

            for (String string : strings) {

                if (!string.equals(Main.URL)) {

                    map += "\n";

                    int countSlash = 0;

                    for (int i = 0; i < string.length(); i++) {
                        if (string.charAt(i) == '/') {
                            countSlash++;
                        }
                    }

                    boolean isFile = false;

                    if (string.lastIndexOf('/') != string.length() - 1) {
                        countSlash++;
                        isFile = true;
                    }

                    int end = string.indexOf('/');
                    end = string.indexOf('/', ++end);
                    end = string.indexOf('/', ++end);

                    for (int i = 0; i <= countSlash - 3; i++) {

                        end = string.indexOf('/', end + i);

                        map += "\n";

                        if (i > 0) {
                            for (int j = 0; j < i; j++) {
                                map += "\t";
                            }
                        }

                        if (isFile && i == countSlash - 3) {
                            map += string;
                        } else {
                            map += string.substring(0, end + 1);
                        }
                    }

                }

            }

            writer.write(map);
            writer.flush();

        } catch (IOException ex) {
            ex.printStackTrace();
        }


    }
}

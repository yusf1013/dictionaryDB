import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){

        String baseUrl = "https://dictionary.cambridge.org/dictionary/english/";
        File file = new File("small.txt");
        Scanner scanner = null;
        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        while (scanner.hasNext())
        {
            String word = scanner.next(), url = baseUrl + word;
            Document document;
            try {
                document = Jsoup.connect(url).get();
                System.out.println(document.title());
                //Elements paragraphs = document.getElementsByTag("div");
                Elements paragraphs = document.getElementsByClass("ddef_h");
                for (Element paragraph : paragraphs) {
                    System.out.println(paragraph.text());
                }
                System.out.println(url);
            } catch (IOException e) {
                System.out.println("ERROR: " + url + " does not exist");
            }

        }


        /*Document document = Jsoup.connect(url).get();
        System.out.println(document.title());
        //Elements paragraphs = document.getElementsByTag("div");
        Elements paragraphs = document.getElementsByClass("ddef_h");
        for (Element paragraph : paragraphs) {
            System.out.println(paragraph.text());
        }*/
    }
}
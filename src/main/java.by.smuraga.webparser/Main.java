import model.Product;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import service.FileService;
import service.ParserService;

import java.io.IOException;
import java.util.*;

public class Main {
    private static ParserService parserService = new ParserService();
    private static FileService fileService = new FileService();

    public static void main(String[] args){
        List<Product> products = new ArrayList<>();
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the number pages to parse:");
        int n = scan.nextInt();

        try {
            for(int i = 0; i < n; i++) {
                String url = "https://www.scalemates.com/search.php?q=*&sortby=date&page=news&fkSECTION[]=Kits&fkYEAR[]=2017&fkYEAR[]=2018&fkYEAR[]=2019&mode=ajax&start="+(n+1)+"&df=ok";
                Document doc = Jsoup.connect(url).get();
                products.addAll(parserService.parsePage(doc, n*125 - i*125));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Amount of all products : " + products.size());

        fileService.parseToJson(products);
        System.out.println("File 'Products.json' recorded");
    }
}

package service;

import model.Product;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

public class ParserService {

    public List<Product> parsePage(Document document,int n) {
        List<Product> list = new ArrayList<Product>();
        String location = "https://www.scalemates.com";
        Elements divElements = document.getElementsByAttributeValue("class", "ac");
        for (Element element : divElements) {
            if(n!=0) {
                String url = element.child(0).attr("href").trim();//URL
                String boxartUrl = location + element.child(0).select("img").attr("src").trim();//boxartUrl
                boxartUrl = boxartUrl.substring(0, boxartUrl.lastIndexOf("-"));
                Element divElem = element.child(1);
                String name = divElem.select("a").text();
                name = name + divElem.select("em").text().trim();//name
                String year = divElem.children().select("div").get(divElem.children().select("div").size() - 1).text();
                String description = "";
                if (year.indexOf(" ") != -1) {
                    description = year.substring(year.indexOf("|") + 2, year.length()).trim();//descriotion
                    year = year.substring(0, year.indexOf(" ")).trim();//year
                }
                String brand = "";//brand
                String scale = divElem.html();
                scale = scale.substring(scale.indexOf("<br>"), scale.lastIndexOf("<br>"));
                if (scale.indexOf(":") != -1) {
                    brand = scale.substring(4, scale.indexOf(":") - 1).trim();
                    scale = scale.substring(scale.indexOf(":") + 1, scale.length() - 1).trim();//scale
                } else {
                    brand = scale.substring(4, scale.length() - 1).trim();
                    scale = "";
                }
                int scaleForProduct = 0;
                if(!scale.equals("")) {
                    Integer.valueOf(scale);
                }
                String brandCatno = divElem.html();
                brandCatno = brandCatno.substring(brandCatno.lastIndexOf("<br>") + 4, brandCatno.lastIndexOf("<div"))
                        .replaceAll("\\s+", "").trim();//brandCatno
                list.add(new Product(url, brand, brandCatno, name, scaleForProduct, description, boxartUrl, year));
                --n;
            }
            else{
                break;
            }
        }
        return list;
    }
}

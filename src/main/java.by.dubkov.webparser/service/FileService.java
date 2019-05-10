package service;

import model.Product;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class FileService {

    public void parseToJson(List<Product> products) {
        JSONArray productsList = new JSONArray();

        products.forEach(product -> {
            JSONObject productObject = new JSONObject();
            productObject.put("url", product.getUrl());
            productObject.put("brand", product.getBrand());
            productObject.put("brandCatno", product.getBrandCatno());
            productObject.put("name", product.getName());
            productObject.put("scale", product.getScale());
            productObject.put("description", product.getDescription());
            productObject.put("boxartUrl", product.getBoxartUrl());
            productObject.put("year", product.getYear());

            //Add product to list
            productsList.add(productObject);
        });

        //Write JSON file
        try (FileWriter file = new FileWriter("Products.json")) {
            file.write(productsList.toJSONString());
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

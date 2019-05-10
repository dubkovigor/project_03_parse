package model;

public class Product {
    private String url;
    private String brand;
    private String brandCatno;
    private String name;
    private int scale;
    private String description;
    private String boxartUrl;
    private String year;

    public Product(String url, String brand, String brandCatno, String name, int scale, String description, String boxartUrl, String year) {
        this.url = url;
        this.brand = brand;
        this.brandCatno = brandCatno;
        this.name = name;
        this.scale = scale;
        this.description = description;
        this.boxartUrl = boxartUrl;
        this.year = year;
    }

    public String getUrl() {
        return url;
    }

    public String getBrand() {
        return brand;
    }

    public String getBrandCatno() {
        return brandCatno;
    }

    public String getName() {
        return name;
    }

    public int getScale() {
        return scale;
    }

    public String getDescription() {
        return description;
    }

    public String getBoxartUrl() {
        return boxartUrl;
    }

    public String getYear() {
        return year;
    }
}

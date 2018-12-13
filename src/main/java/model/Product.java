package model;

public class Product {

    private Long id;
    private double price;
    private double discountedPrice;
    private String productName;

    public Product() {
    }

    public Product(Long id, double price, double discountedPrice, String productName) {
        this.id = id;
        this.price = price;
        this.discountedPrice = discountedPrice;
        this.productName = productName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getDiscountedPrice() {
        return discountedPrice;
    }

    public void setDiscountedPrice(double discountedPrice) {
        this.discountedPrice = discountedPrice;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }
}

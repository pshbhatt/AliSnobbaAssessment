package model;

public class Cart {

    private Long id;
    private LineItem lineItem;
    private Product product;

    public Cart(Long id, LineItem lineItem, Product product) {
        this.id = id;
        this.lineItem = lineItem;
        this.product = product;
    }

    public Cart() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LineItem getLineItem() {
        return lineItem;
    }

    public void setLineItem(LineItem lineItem) {
        this.lineItem = lineItem;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}

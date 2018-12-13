package model;

import java.util.List;

public class LineItem {

    private Long id;
    private int quantity;
    private List<Product> product;

    public LineItem(Long id, int quantity, List<Product> product) {
        this.id = id;
        this.quantity = quantity;
        this.product = product;
    }

    public LineItem() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public List<Product> getProduct() {
        return product;
    }

    public void setProduct(List<Product> product) {
        this.product = product;
    }
}

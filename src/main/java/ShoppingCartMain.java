import model.Cart;
import model.Product;

import java.util.HashMap;
import java.util.Map;

public class ShoppingCartMain {


    public int quantity(Cart cart){
        if(cart.getLineItem().getQuantity()==0) {
            return 0;
        } else {
        return cart.getLineItem().getQuantity();
        }
    }

    public int addQuantity(int quantity, Cart cart){
            cart.getLineItem().setQuantity(cart.getLineItem().getQuantity() + quantity);
            return cart.getLineItem().getQuantity();
    }

    public int removeQuantity(int quantity, Cart cart){
        int remaining = cart.getLineItem().getQuantity() - quantity;
        if(remaining>0) {
            cart.getLineItem().setQuantity(remaining);
        } else{
            cart.setLineItem(null);
        }
        return cart.getLineItem().getQuantity();
    }

    public Map<String, Double> getAllPrices(Cart cart){
        Map<String, Double> priceMap = new HashMap<>();
            for(Product product: cart.getLineItem().getProduct()) {
                priceMap.put(product.getProductName(),cart.getLineItem().getQuantity()*product.getDiscountedPrice());
                System.out.println("Product Name: " + product.getProductName() + " and Discounted Price: "+ cart.getLineItem().getQuantity()*product.getDiscountedPrice());
            }

        return priceMap;
    }

    public Map<String, String> getAllUndiscountedPrices(Cart cart){
        Map<String, String> priceMap = new HashMap<>();
        for(Product product: cart.getLineItem().getProduct()) {
            priceMap.put(product.getProductName(), "UndiscountedPrice: "+ product.getPrice()*cart.getLineItem().getQuantity() +
                    ". The total saving is: " + (product.getPrice()*cart.getLineItem().getQuantity()-product.getDiscountedPrice()*cart.getLineItem().getQuantity()));
            System.out.println("Product Name: " + product.getProductName() +
                    " and UndiscountedPrice: "+ product.getPrice() +
                    ". The total saving is: " +
                    (product.getPrice()*cart.getLineItem().getQuantity()-product.getDiscountedPrice()*cart.getLineItem().getQuantity()));
        }

        return priceMap;
    }

    public double totalUndiscountedPrice(Cart cart){
        double totalPrice =0.0;
        for(Product product: cart.getLineItem().getProduct()) {
            totalPrice = totalPrice + (product.getPrice()*cart.getLineItem().getQuantity());
        }
        return totalPrice;
    }

    public double totalDiscountedPrice(Cart cart){
        double totalPrice =0.0;
        for(Product product: cart.getLineItem().getProduct()) {
            totalPrice = totalPrice + (product.getDiscountedPrice()*cart.getLineItem().getQuantity());
        }
        return totalPrice;
    }


}

import model.Cart;
import model.LineItem;
import model.Product;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShoppingCartTests {


    //Test for checking the empty cart
    @Test
    public void testEmptyCart(){
        LineItem item = new LineItem();
        item.setQuantity(0);
        Cart cart = new Cart();
        cart.setLineItem(item);
        ShoppingCartMain shoppingCart = new ShoppingCartMain();
        Assert.assertEquals(shoppingCart.quantity(cart),0);

    }

    //Test for checking adding one quantity to the cart
    @Test
    public void testOneQuantity(){
    LineItem item = new LineItem();
    item.setQuantity(0);
    Cart cart = new Cart();
    cart.setLineItem(item);
        ShoppingCartMain shoppingCart = new ShoppingCartMain();
        Assert.assertEquals(shoppingCart.addQuantity(1,cart),1);
    }


    //Test for checking adding any quantity to the cart
    @Test
    public void testAddOneQuantity(){
        LineItem item = new LineItem();
        item.setQuantity(1);
        Cart cart = new Cart();
        cart.setLineItem(item);
        ShoppingCartMain shoppingCart = new ShoppingCartMain();
        Assert.assertEquals(shoppingCart.addQuantity(1,cart),2);
    }

    //Test for removing one quantity
    @Test
    public void testRemoveOneQuantity(){
        LineItem item = new LineItem();
        item.setQuantity(2);
        Cart cart = new Cart();
        cart.setLineItem(item);
        ShoppingCartMain shoppingCart = new ShoppingCartMain();
        Assert.assertEquals(shoppingCart.removeQuantity(1,cart),1);
        //Assert.assertEquals(shoppingCart.removeQuantity(1,cart),0);
    }

    @Test(expected = NullPointerException.class)
    public void testZeroQuantity(){
        LineItem item = new LineItem();
        item.setQuantity(1);
        Cart cart = new Cart();
        cart.setLineItem(item);
        ShoppingCartMain shoppingCart = new ShoppingCartMain();
        shoppingCart.removeQuantity(1,cart);
        Assert.assertEquals(cart.getLineItem().getQuantity(),0);
    }

    @Test
    public void testAllDiscountedPrices(){
        LineItem item = new LineItem();
        item.setQuantity(2);
        Product product = new Product();
        product.setProductName("LV");
        product.setDiscountedPrice(11.34);

        Product product1 = new Product();
        product1.setProductName("DG");
        product1.setDiscountedPrice(12.34);
        List<Product> productList = new ArrayList<>();
        productList.add(product);
        productList.add(product1);
        item.setProduct(productList);
        Cart cart = new Cart();
        cart.setLineItem(item);
        Map<String, Double> priceMap = new HashMap<>();
        priceMap.put("LV", 11.34*2);
        priceMap.put("DG", 12.34*2);
        ShoppingCartMain shoppingCart = new ShoppingCartMain();

        Assert.assertEquals(shoppingCart.getAllPrices(cart),priceMap);
    }

    @Test
    public void testAllUnDiscountedPrices(){
        LineItem item = new LineItem();
        item.setQuantity(2);
        Product product = new Product();
        product.setProductName("LV");
        product.setDiscountedPrice(11.34);
        product.setPrice(15.34);

        Product product1 = new Product();
        product1.setProductName("DG");
        product1.setDiscountedPrice(12.34);
        product1.setPrice(18.34);
        List<Product> productList = new ArrayList<>();
        productList.add(product);
        productList.add(product1);
        item.setProduct(productList);
        Cart cart = new Cart();
        cart.setLineItem(item);
        Map<String, String> priceMap = new HashMap<>();
        priceMap.put("LV", "UndiscountedPrice: "+ (15.34*2) + ". The total saving is: " + (15.34*2-11.34*2));
        priceMap.put("DG", "UndiscountedPrice: "+ (18.34*2) + ". The total saving is: " + (18.34*2-12.34*2));
        ShoppingCartMain shoppingCart = new ShoppingCartMain();

        Assert.assertEquals(shoppingCart.getAllUndiscountedPrices(cart),priceMap);
    }

    @Test
    public void testTotalUndiscountedPrice(){
        LineItem item = new LineItem();
        item.setQuantity(2);
        Product product = new Product();
        product.setProductName("LV");
        product.setDiscountedPrice(11.34);
        product.setPrice(15.34);

        Product product1 = new Product();
        product1.setProductName("DG");
        product1.setDiscountedPrice(12.34);
        product1.setPrice(18.34);
        List<Product> productList = new ArrayList<>();
        productList.add(product);
        productList.add(product1);
        item.setProduct(productList);
        Cart cart = new Cart();
        cart.setLineItem(item);

        ShoppingCartMain shoppingCart = new ShoppingCartMain();

        Assert.assertEquals(shoppingCart.totalUndiscountedPrice(cart),67.36,0);
    }

    @Test
    public void testTotalDiscountedPrice(){
        LineItem item = new LineItem();
        item.setQuantity(2);
        Product product = new Product();
        product.setProductName("LV");
        product.setDiscountedPrice(11.34);
        product.setPrice(15.34);

        Product product1 = new Product();
        product1.setProductName("DG");
        product1.setDiscountedPrice(12.34);
        product1.setPrice(18.34);
        List<Product> productList = new ArrayList<>();
        productList.add(product);
        productList.add(product1);
        item.setProduct(productList);
        Cart cart = new Cart();
        cart.setLineItem(item);

        ShoppingCartMain shoppingCart = new ShoppingCartMain();

        Assert.assertEquals(shoppingCart.totalDiscountedPrice(cart),47.36,0);
    }



}

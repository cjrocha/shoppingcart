package ro.ddroidd.summerinternshipp2022.backend;

import java.util.ArrayList;
import java.util.List;


public class ShoppingCart {
    String productName;
    double subtotal;
    double shipping;
    double quantity;

    /**
     * Constructor for cart object
     * @param productName
     * @param subtotal
     * @param shipping
     * @param quantity
     */
    public ShoppingCart(String productName, double subtotal, double shipping, double quantity) {
        this.productName = productName;
        this.subtotal = subtotal;
        this.shipping = shipping;
        this.quantity = quantity;
    }

    /**
     * getters for cart elements
     * @return
     */
    public String getProductName() {
        return productName;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public double getShipping() {
        return shipping;
    }

    public double getQuantity() {
        return quantity;
    }

    /**
     * Adding products to the shipping cart
     * @param product
     */
    public static List<Product> addProductToCart(Product product){
        List<Product> productsInCart = new ArrayList<>();
        //Product p = new Product();
        if (productsInCart.size() == 0){
            productsInCart.add(product);
        } else {
            if(productsInCart.contains(product)){
                product.setQuantity(product.getQuantity() + 1);
            } else{
                productsInCart.add(product);
            }
        }
        return productsInCart;
    }

    /**
     * Removing products from shopping cart
     * @param product
     * @return
     */
    public static List<Product> removeProductToCart(Product product){
        List<Product> productsInCart = new ArrayList<>();
        if (productsInCart.size() == 0){
            productsInCart.remove(product);
        } else {
            if(productsInCart.contains(product)){
                product.setQuantity(product.getQuantity() - 1);
            } else{
                productsInCart.remove(product);
            }
        }
        return productsInCart;
    }
}

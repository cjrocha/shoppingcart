package ro.ddroidd.summerinternshipp2022.backend;

import java.util.ArrayList;
import java.util.List;


public class ShoppingCart {
    private Product product;;
    private int quantity;
    static List<Product> productsInCart = new ArrayList<>();
    /**
     * Constructor for cart object
     * @param product
     * @param quantity
     */
    public ShoppingCart(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    /**
     * getters for cart elements
     * @return
     */
    public Product getProduct() {
        return product;
    }

    public double getQuantity() {
        return quantity;
    }

    /**
     * Adding products to the shipping cart
     * @param product
     */
    public static List<Product> addProductToCart(Product product){
        int quantity = 0;
        if (productsInCart.isEmpty()){
            productsInCart.add(product);
            quantity = quantity + 1;
        } else {
            if(productsInCart.contains(product)){
                productsInCart.setQuantity(product.getQuantity() + 1);
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

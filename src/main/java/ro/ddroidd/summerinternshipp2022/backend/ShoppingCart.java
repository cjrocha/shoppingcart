package ro.ddroidd.summerinternshipp2022.backend;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class ShoppingCart {
    private Product product;
    private int quantity;
    private Set<ShoppingCart> productsInCart = new HashSet<>();
    /**
     * Constructor for cart object
     * @param product
     * @param quantity
     */
    public ShoppingCart(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }
    public ShoppingCart(){}

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

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Set<ShoppingCart> getProductsInCart() {
        return productsInCart;
    }

    /**
     * Adding products to the shipping cart
     * @param product
     */
    public Set<ShoppingCart> addProductToCart(Product product){
        if (productsInCart.isEmpty()){
            productsInCart.add(new ShoppingCart(product, quantity+1));
        } else {
            if(productsInCart.contains(product)){
                for (ShoppingCart p : productsInCart) {
                    if (p == ShoppingCart.this) {
                        quantity = (int) (p.getQuantity() + 1);
                        ShoppingCart.this.setQuantity(quantity);
                    }
                }
            } else{
                productsInCart.add(new ShoppingCart(product, quantity+1));
            }
        }
        return productsInCart;
    }

    /**
     * Removing products from shopping cart
     * @param product
     * @return
     */
    public Set<ShoppingCart> removeProductToCart(Product product){
        if (productsInCart.size() == 0){
            productsInCart.remove(product);
        } else {
            if(productsInCart.contains(product)){
                for (ShoppingCart p : productsInCart) {
                    if (p == ShoppingCart.this) {
                        quantity = (int) (p.getQuantity() - 1);
                        ShoppingCart.this.setQuantity(quantity);
                    }
                }
            } else{
                productsInCart.remove(product);
            }
        }
        return productsInCart;
    }
}

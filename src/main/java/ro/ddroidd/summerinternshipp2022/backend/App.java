package ro.ddroidd.summerinternshipp2022.backend;

import java.util.List;
import java.util.Scanner;

/**
 * Console App to print cart products and calculate totals
 * based on shipping rates.
 * Products catalog and shipping rates are being imported from
 * csv files.
 *
 */
public class App {
    public static void main( String[] args ) {
        Scanner scanner = new Scanner(System.in);
        //Logger logger = Logger.getLogger("log.txt");
        ReadData newCatalog = new ReadData();
        List<Product> products = newCatalog.readCatalog();
        List<ShippingRate> shippingRates = newCatalog.readRates();
        System.out.println("Welcome to our store.\n" +
                "Please find bellow our catalog of products:\n");
        for (Product product : products){
            System.out.println(product.getName()+" - $"+product.getPrice());
        }
        boolean value = true;
        while (value){
            System.out.println("Please let us know what you want to do do:\n"+
                "1. Add products to cart\n2. Remove products from cart");
            System.out.println("Please insert the number of your choice:");
            String choice = scanner.nextLine();
            Product prod = new Product();
            switch (choice){
                case "1":
                    System.out.println("Let us know witch product should be added to cart\n"+
                        "Please type the name of product:");
                    String addProduct = scanner.nextLine();
                    ShoppingCart sc = new ShoppingCart();
                    for (Product p : products){
                        if (addProduct == prod.getName()){
                            sc.addProductToCart(p);
                        }
                    }
                    for(ShoppingCart product : sc.getProductsInCart()){
                        System.out.println("Cart items are: "+product.getProduct().getName()+" x "+product.getQuantity());
                    }
                    break;
                case "2":
                    System.out.println("Let us know witch product should be removed from cart\n"+
                        "Please type the name of product:");
                    String removeProduct = scanner.nextLine();
                    sc = new ShoppingCart();
                    for (Product p : products){
                        if (removeProduct == prod.getName()){
                            sc.removeProductToCart(p);
                        }
                    }
                    for(ShoppingCart product : sc.getProductsInCart()){
                        System.out.println("Cart items are: "+product.getProduct().getName()+" x "+product.getQuantity());
                    }
                    break;
                default:
                    System.out.println("You need to select the number of the action required!");
            }
            System.out.println("Whenever you want you can go ahead to checkout or continue shopping\n"+
                "Please select what you want to do next:\n"+
                "1. Continue shoppign\n2. Checkout\n"+"Insert option's number bellow:");
            int next = scanner.nextInt();
            String paused = scanner.nextLine();
            switch(next){
                case 1:
                    return;
                case 2:
                    CalculateCart invoice = new CalculateCart();
                    invoice.calculateCart();
                    value = false;
                    break;
            }
        }
    }
}

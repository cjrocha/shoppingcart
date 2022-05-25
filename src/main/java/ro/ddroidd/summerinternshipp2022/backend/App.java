package ro.ddroidd.summerinternshipp2022.backend;

import java.util.List;
import java.util.Scanner;

import static ro.ddroidd.summerinternshipp2022.backend.ShoppingCart.removeProductToCart;


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
        System.out.println("Please let us know what you want to do do:\n"+
                "1. Add products to cart\n2. Remove products from cart");
        System.out.println("Please insert the number of your choice:");
        String choice = scanner.nextLine();
        switch (choice){
            case "1":
                System.out.println("Let us know witch product should be added to cart\n"+
                        "Please type the name of product:");
                String addProduct = scanner.nextLine();
                for (Product product : products){
                    if (addProduct == product.getName()){
                        ShoppingCart.addProductToCart(product);
                    }
                }
                for(Product product : ShoppingCart.addProductToCart()){
                    System.out.println("Cart items are: "+product.getName()+" x "+product.getQuantity());
                }
                //getInvoice();
                break;
            case "2":
                System.out.println("Let us know witch product should be removed from cart\n"+
                        "Please type the name of product:");
                String removeProduct = scanner.nextLine();
                for (Product product : products){
                    if (removeProduct == product.getName()){
                        ShoppingCart.removeProductToCart(product);
                    }
                }
                for(Product product : ShoppingCart.removeProductToCart()){
                    System.out.println("Cart items are: "+product.getName()+" x "+product.getQuantity());
                }
                //getInvoice();
                break;
            default:
                System.out.println("You need to select the number of the action required!");
        }
    }
}

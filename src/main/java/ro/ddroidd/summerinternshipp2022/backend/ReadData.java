package ro.ddroidd.summerinternshipp2022.backend;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ReadData {
    /**
     * Reads data from file and
     * @return - a list of products catalog
     */
    public List<Product> readCatalog(){
        int quantity = 0;
        //Logger logger = Logger.getLogger("log.txt");
        List<Product> products = new ArrayList<>();
        Path pathToFile = Paths.get("D:/code/ShoppingCart/src/main/java/ro/ddroidd/summerinternshipp2022/backend/resources/catalog.csv");
        try (BufferedReader br = Files.newBufferedReader(pathToFile, StandardCharsets.US_ASCII)) {
            String line = br.readLine();
            while (line != null) {
                String[] entries = line.split(",");
                products.add(new Product(entries[0], Double.parseDouble(entries[1]), entries[2], Double.parseDouble(entries[3]), quantity));
                line = br.readLine();
                //logger.info("File was read successfully");
            }
        }catch (IOException ioe) {
            //logger.severe("Something went wrong! The input file was not read!");
            ioe.printStackTrace();
        }
    return products;
    }

    /**
     * Reads data from file and
     * @return - a list of rates based on location
     */
    public List<ShippingRate> readRates(){
        //Logger logger = Logger.getLogger("log.txt");
        List<ShippingRate> rates = new ArrayList<>();
        Path pathToFile = Paths.get("D:/code/ShoppingCart/src/main/java/ro/ddroidd/summerinternshipp2022/backend/resources/shippingrates.csv");
        try (BufferedReader br = Files.newBufferedReader(pathToFile, StandardCharsets.US_ASCII)) {
            String line = br.readLine();
            while (line != null) {
                String[] entries = line.split(",");
                rates.add(new ShippingRate(entries[0], Integer.parseInt(entries[1])));
                line = br.readLine();
                //logger.info("File was read successfully");
            }
        }catch (IOException ioe) {
            //logger.severe("Something went wrong! The input file was not read!");
            ioe.printStackTrace();
        }
        return rates;
    }
}

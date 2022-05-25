package ro.ddroidd.summerinternshipp2022.backend;

import java.util.Objects;

public class Product {
    private String name;
    private double price;
    private String location;
    private double weight;
    private int quantity;

    /**
     * Product object constructor
     * @param name
     * @param price
     * @param location
     * @param weight
     * @param quantity
     */
    public Product(String name, double price, String location, double weight, int quantity) {
        this.name = name;
        this.price = price;
        this.location = location;
        this.weight = weight;
        this.quantity = quantity;
    }

    public Product(){}

    /**
     * Setters and getters for this object
     * @return
     */
    public String getName() {
        return name;
    }


    public double getPrice() {
        return price;
    }


    public String getLocation() {
        return location;
    }


    public double getWeight() {
        return weight;
    }


    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     * Overiding equal and hashcode methods to
     * keep the products catalog clean with no duplicates
     * @param o
     * @return
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product)) return false;
        Product product = (Product) o;
        return Double.compare(product.getPrice(), getPrice()) == 0 && Double.compare(product.getWeight(), getWeight()) == 0 && getQuantity() == product.getQuantity() && Objects.equals(getName(), product.getName()) && Objects.equals(getLocation(), product.getLocation());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getPrice(), getLocation(), getWeight(), getQuantity());
    }

    /*
    Used to print in console
     */
    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", location='" + location + '\'' +
                ", weight=" + weight +
                ", quantity=" + quantity +
                '}';
    }
}

package ro.ddroidd.summerinternshipp2022.backend;

public class ShippingRate {

    private String location;
    private int rate;

    /**
     * Constructor for the object
     * @param location
     * @param rate
     */
    public ShippingRate(String location, int rate) {
        this.location = location;
        this.rate = rate;
    }

    /**
     * Getters for the object params
     * @return
     */
    public String getLocation() {
        return location;
    }

    public int getRate() {
        return rate;
    }

    /*
    Used to print in console
     */
    @Override
    public String toString() {
        return "ShippingRate{" +
                "location='" + location + '\'' +
                ", rate=" + rate +
                '}';
    }
}

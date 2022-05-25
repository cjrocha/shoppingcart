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
    public ShippingRate(){}

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

    public double getShippingCost(Product product){
        double shippingCost;
        switch (product.getLocation()){
            case "RO":
                shippingCost = product.getWeight()/0.1*1;
                break;
            case "UK":
                shippingCost = product.getWeight()/0.1*2;
                break;
            case "US":
                shippingCost = product.getWeight()/0.1*2;
                break;
            default:
                shippingCost = 0;
        }
        return shippingCost;
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

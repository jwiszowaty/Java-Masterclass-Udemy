package Polymorphism.OOPMasterChallenge;

public class Drink {
    private String type;
    private String size;
    private double price;

    public Drink(String type, String size, double price) {
        this.type = type;
        this.size = size;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Drink{" +
                "type='" + type + '\'' +
                ", size='" + size + '\'' +
                ", price=" + price +
                '}';
    }
}

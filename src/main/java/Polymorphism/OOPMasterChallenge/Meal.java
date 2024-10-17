package Polymorphism.OOPMasterChallenge;

public class Meal {
    private Burger burger;
    private Drink drink;
    private Side side;

    public Meal() {
        this.burger = new Burger("regular", 2.99);
        this.drink = new Drink("coke", "regular", 0.99);
        this.side = new Side("fries", "regular");
    }

    @Override
    public String toString() {
        return "Meal{" +
                "burger=" + burger +
                ", drink=" + drink +
                ", side=" + side +
                '}';
    }
}

package Polymorphism.OOPMasterChallenge;

import java.util.ArrayList;
import java.util.Scanner;

public class Burger {
    Scanner scanner = new Scanner(System.in);
    private String type;
    private double price;
    private ArrayList<String> toppings = new ArrayList<>();

    public Burger(String type, double price) {
        this.type = type;
        this.price = price;
        if(type.equals("regular")) {
            while(toppings.size() < 3) {
                System.out.println("Please choose a topping or type 's' to skip (" + (toppings.size() + 1) + " of 3)");
                String nextTopping = scanner.nextLine();
                if (nextTopping.equals("s")) break;
                toppings.add(nextTopping);
            }
        }
    }

    @Override
    public String toString() {
        return "Burger{" +
                "type='" + type + '\'' +
                ", price=" + price +
                ", toppings=" + toppings +
                '}';
    }
}

package Polymorphism.EncapsulationChallenge;

public class Main {
    public static void main(String[] args) {
        Printer printer = new Printer(50,true);
        System.out.println(printer.printPages(4));
    }
}

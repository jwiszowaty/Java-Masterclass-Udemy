package Polymorphism.CompositionChallenge;

public class CoffeeMaker extends Appliance{
    public CoffeeMaker(boolean hasWorkToDo) {
        super(hasWorkToDo);
    }
    public void brewCoffee() {
        updateStatus(true);
    }
}

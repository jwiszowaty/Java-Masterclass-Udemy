package Polymorphism.CompositionChallenge;

public class Refrigerator extends Appliance{

    public Refrigerator(boolean hasWorkToDo) {
        super(hasWorkToDo);
    }
    public void orderFood() {
        updateStatus(true);
    }
}
